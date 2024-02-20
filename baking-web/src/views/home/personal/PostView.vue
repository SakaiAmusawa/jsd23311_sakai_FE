<script setup>

import {Plus} from "@element-plus/icons-vue";
import {onMounted, ref} from 'vue'
import Editor from "wangeditor";

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

const handleRemove = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>
<!--稿件发布页-->
<template>
  <h1 style="color: orange">发布内容页面</h1>
  <el-form label-width="100px">
    <el-form-item label="文章标题">
      <el-input placeholder="请输入文章标题"></el-input>
    </el-form-item>
    <el-form-item label="文章类型">
      <el-radio-group>
        <el-radio-button label="1">烘焙食谱</el-radio-button>
        <el-radio-button label="2">烘焙视频</el-radio-button>
        <el-radio-button label="3">行业资讯</el-radio-button>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="二级分类">
      <el-select placeholder="select">
        <el-option label="面包" value="1"></el-option>
        <el-option label="小食" value="2"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="封面">
      <!--   封面上传开始    -->
      <el-upload
          v-model:file-list="fileList"
          action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
      >
        <el-icon>
          <Plus/>
        </el-icon>
      </el-upload>

      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
      <!--   封面上传结束    -->
    </el-form-item>
    <el-form-item label="文章内容">
      <div ref="editorDiv"></div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary">发布内容</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>