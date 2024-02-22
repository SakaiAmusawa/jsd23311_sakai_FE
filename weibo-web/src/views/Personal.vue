<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const arr = ref([])

onMounted(() => {
  let user = localStorage.user ? JSON.parse(localStorage.user) : null
  /*获取数据，并将获取的数据装载到arr数组中*/
  axios.get('http://localhost:8080/v1/weibo?userId=' + user.id).then(
      (response) => {
        if (response.data.code === 2001) {
          arr.value = response.data.data
          if (arr.value.length === 0) {
            ElMessage.warning('快来发布一条微博吧')
            router.push('/post')
          }
        }
      }
  )
})

</script>

<template>
  <h1>个人中心页</h1>
  <div v-for="weibo in arr">
    <h3>{{ weibo.nickname }}说：{{ weibo.content }}</h3>
  </div>
</template>

<style scoped>

</style>