<script setup>

import {ref} from "vue";
import router from "@/router";
import axios from "axios";
import qs from "qs"
import {ElMessage} from "element-plus";
import {Plus} from '@element-plus/icons-vue'

const weibo = ref({
  content: '',
})

const post = () => {
  if (fileList.value.length > 0) {
    let imgUrls = [];
    for (let file of fileList.value) {
      let imgUrl = file.response.data;
      imgUrls.push(imgUrl)
    }
    weibo.value.imgUrls = imgUrls.toString();
  }
  //得到用户信息
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  //判断是否登录
  if (user == null) {
    alert('请登录！')
    router.push('/login')
  }
  //设置作者ID
  weibo.value.userId = user.id;
  //将数据转化为查询字符串
  let data = qs.stringify(weibo.value)
  axios.post('http://localhost:8080/v1/weibo/post', data).then((response) => {
    if (response.data.code === 2001) {
      ElMessage.success('发布成功')
      router.push('/')
    } else {
      ElMessage.error(response.data.msg)
    }
  })
}

const fileList = ref([])
const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (uploadFile, uploadFiles) => {
  //得到要删除图片的路径
  let imgUrl = uploadFile.response.data;
  axios.post('http://localhost:8080/v1/remove?imgUrl=' + imgUrl).then(
      (response) => {
        if (response) {
          if (response.data.code === 2001) {
            ElMessage.success('删除图片成功')
          }
        }
      }
  )
}
const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>

<template>
  <h1>发布微博</h1>
  <div style="width: 500px;margin: 0 auto;">
    <el-input v-model="weibo.content" placeholder="说点啥"></el-input>
    <el-button type="primary" style="width: 100px;font-weight: bold;margin: 10px;" @click="post()">发布微博</el-button>
    <!--头像上传开始-->
    <el-upload
        v-model:file-list="fileList"
        action="http://localhost:8080/v1/upload"
        limit="9"
        name="file"
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
    <!--头像上传结束-->
  </div>
</template>

<style scoped>

</style>