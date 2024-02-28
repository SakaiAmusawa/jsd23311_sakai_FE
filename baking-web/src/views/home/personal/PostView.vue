<script setup>

import {Plus} from "@element-plus/icons-vue";
import {onMounted, ref} from 'vue'
import Editor from "wangeditor";
import axios from "axios";
import {ElMessage} from "element-plus";
import qs from "qs"
import router from "@/router";

//创建响应式变量,代表页面的div元素
const editorDiv = ref(null)
//用来保存一会创建好的富文本编辑器对象
let editor = null;
//挂在完毕立即执行的方法
onMounted(() => {
  editor = new Editor(editorDiv.value);
  editor.config.placeholder = "请输入内容详情"
  editor.create()
})

const fileList = ref([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

//完成删除图片的方法
const handleRemove = (uploadFile) => {
  let imgUrl = uploadFile.response.data; //被删除图片的路径
  axios.post('http://localhost:8080/v1/remove?imgUrl=' + imgUrl).then(
      (response) => {
        if (response.data.code === 2001) {
          ElMessage.success('删除成功')
        }
      }
  )
}

const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}

const catTypeArr = ref([])
onMounted(
    () => {
      //当以GET请求携带参数过来时，此方式可获取到？后参数
      if (location.search.includes('id')) {
        let id = new URLSearchParams(location.search).get('id')
        console.log(id)
        axios.get('http://localhost:8080/v1/content/' + id + '/update').then(
            (response) => {
              if (response.data.code === 2001) {
                console.log(response.data.data)
                //根据id查询到的内容装载到content中回显在页面上
                content.value = response.data.data
              }
            }
        )
      }
      //发送请求获取一级分类
      axios.get('http://localhost:8080/v1/categories/type').then(
          (response) => {
            if (response.data.code === 2001) {
              catTypeArr.value = response.data.data;
            }
          }
      )
      //发送请求获取二级分类
      axios.get('http://localhost:8080/v1/categories/1/sub').then(
          (response) => {
            if (response.data.code === 2001) {
              categoryArr.value = response.data.data;
            }
          }
      )
    }
)

const content = ref({title: '', type: 1, categoryId: ''});

const categoryArr = ref();

//点击的文章类型发生改变，获取对应类型的二级分类
const typeChange = () => {
  content.value.categoryId = '';//该行代码为了防止切换一级分类时把原来的二级分类ID带过去
  axios.get('http://localhost:8080/v1/categories/' + content.value.type + '/sub'
  ).then(
      (response) => {
        if (response.data.code === 2001) {
          categoryArr.value = response.data.data;
        }
      }
  )
}

const videoList = ref([]);

const post = () => {
  //验证用户登陆状态
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  if (user == null) {
    router.push('/login')
  }
  content.value.userId = user.id
  if (content.value.title.trim() === '') {
    ElMessage.error('请输入标题');
    return;
  }
  if (content.value.categoryId === '') {
    ElMessage.error('请选择二级分类')
    return;
  }
  if (fileList.value.length === 0) {
    ElMessage.error('请上传封面')
    return;
  }
  let imgUrl = fileList.value[0].response.data;//获取fileList中图片路径
  content.value.imgUrl = imgUrl;//将图片路径装载到content对象中去

  //判断是视频还是文章
  if (content.value.type === 2) {//视频
    if (videoList.value.length === 0) {
      ElMessage.error('请先选择视频文件');
      return;
    }
    let videoUrl = videoList.value[0].response.data;
    content.value.videoUrl = videoUrl;
  } else {//文章
    content.value.content = editor.txt.html();//获取文章的内容
    content.value.brief = editor.txt.text().slice(0, 30);//获取文章的摘要,截取前30个字符
  }

  console.log(content.value)
  let data = qs.stringify(content.value)
  axios.post('http://localhost:8080/v1/content/add-new', data)
      .then((response) => {
        if (response.data.code === 2001) {
          ElMessage.success('发布成功!');
          router.push('/personal/management')
        }
      })
}
</script>
<!--稿件发布页-->
<template>
  <h1 style="color: orange">发布内容页面</h1>
  <el-form label-width="100px">
    <el-form-item label="文章标题">
      <el-input placeholder="请输入文章标题" v-model="content.title"></el-input>
    </el-form-item>
    <el-form-item label="文章类型">
      <el-radio-group v-model="content.type" @change="typeChange()">
        <!--        <el-radio-button label="1">烘焙食谱</el-radio-button>
                <el-radio-button label="2">烘焙视频</el-radio-button>
                <el-radio-button label="3">行业资讯</el-radio-button>-->
        <el-radio-button v-for="c of catTypeArr" :label="c.type">{{ c.name }}</el-radio-button>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="二级分类">
      <el-select placeholder="请选择" v-model="content.categoryId">
        <!--        <el-option label="面包" value="1"></el-option>
                <el-option label="小食" value="2"></el-option>-->
        <el-option v-for="c in categoryArr" :label="c.name" :value="c.id"></el-option>
      </el-select>
    </el-form-item>
    <!--   封面上传开始    -->
    <el-form-item label="封面">
      <el-upload
          v-model:file-list="fileList"
          limit="1"
          name="file"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          action="http://localhost:8080/v1/upload"
          list-type="picture-card"
      >
        <el-icon>
          <Plus/>
        </el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible">
        <img :src="dialogImageUrl" alt="Preview Image" w-full/>
      </el-dialog>
    </el-form-item>
    <!--   封面上传结束    -->
    <!--   视频开始上传   -->
    <el-form-item label="视频" v-show="content.type===2">
      <el-upload
          v-model:file-list="videoList"
          limit="1"
          name="file"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          action="http://localhost:8080/v1/upload"
          accept="video/*"
      >
        <el-button type="warning">点击上传视频</el-button>
        <div>(只能上传不超过不超过100M的MP4文件)</div>
      </el-upload>

      <el-dialog v-model="dialogVisible">
        <img :src="dialogImageUrl" alt="Preview Image" w-full/>
      </el-dialog>
    </el-form-item>
    <!--  视频上传结束  -->
    <el-form-item label="文章内容" v-show="content.type!==2">
      <div ref="editorDiv"></div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="post()">发布内容</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>