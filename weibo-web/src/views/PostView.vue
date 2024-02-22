<script setup>

import {ref} from "vue";

const weibo = ref({
  content: '',
})

const post = () => {

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