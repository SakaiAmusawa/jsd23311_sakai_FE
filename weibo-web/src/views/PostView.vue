<script setup>

import {ref} from "vue";
import router from "@/router";
import axios from "axios";
import qs from "qs"
import {ElMessage} from "element-plus";

const weibo = ref({
  content: '',
})

const post = () => {
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
  axios.post('https://localhost:8080/v1/users/post', data).then((response) => {
    if (response.data.code === 2001) {
      ElMessage.success('发布成功')
      router.push('/')
    } else {
      ElMessage.error(response.data.msg)
    }
  })
}

</script>

<template>
  <h1>发布微博</h1>
  <div style="width: 500px;margin: 0 auto;">
    <el-input v-model="weibo.content" placeholder="说点啥"></el-input>
    <el-button type="primary" style="width: 100px;font-weight: bold;margin: 10px;" @click="post()">发布微博</el-button>
  </div>
</template>

<style scoped>

</style>