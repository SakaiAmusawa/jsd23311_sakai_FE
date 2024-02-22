<template>
  <h1>详情页</h1>
  <hr>
  <h1>{{ weibo.nickname }}说：{{ weibo.content }}</h1>
  <p>发布于:{{ weibo.created }}</p>
</template>

<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

const weibo = ref({})
onMounted(() => {
  let id = new URLSearchParams(location.search).get('id')
  axios.get('http://localhost:8080/v1/weibo/' + id + '/detail').then(
      (response) => {
        if (response.data.code === 2001) {
          ElMessage.success('操作成功！')
        } else {
          ElMessage.error(response.data.msg)
        }
      }
  )
})
</script>

<style scoped>

</style>