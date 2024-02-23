<template>
  <h1>详情页</h1>
  <hr>
  <h1>{{ weibo.nickname }}说：{{ weibo.content }}</h1>
  <p>发布于:{{ weibo.created }}</p>
  <hr>
  <el-input v-model="comment.content" placeholder="留下你的评论吧" style="width: 500px;"></el-input>
  <el-button type="primary" @click="post()" style="margin: 10px;">发布评论</el-button>
</template>

<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";
import qs from "qs"

const weibo = ref({})
onMounted(() => {
  let id = new URLSearchParams(location.search).get('id')
  axios.get('http://localhost:8080/v1/weibo/' + id + '/detail').then(
      (response) => {
        if (response.data.code === 2001) {
          ElMessage.success('操作成功！')
          weibo.value = response.data.data
        } else {
          ElMessage.error(response.data.msg)
        }
      }
  )
})

const comment = ref({content: ''})

const post = () => {
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  if (user === null) {
    ElMessage.error('请登录')
    router.push('/login')
  }

  comment.value.userId = user.id;//设置是谁评论的
  comment.value.weiboId = weibo.value.id;//评论的那条微博
  let data = qs.stringify(comment.value);

  axios.post('http://localhost:8080/v1/comment/add-new', data).then((response) => {
    if (response.data.code === 2001) {
      ElMessage.success('评论成功')
    } else {
      ElMessage.error(response.data.msg)
    }
  })
}
</script>

<style scoped>

</style>