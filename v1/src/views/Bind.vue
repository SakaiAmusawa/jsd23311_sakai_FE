<script setup>
import {ref} from "vue";

const info = ref("属性绑定");
const url = ref("https://www.baidu.com")
url.value = "https://www.jd.com"
</script>

<template>

  <h1>属性绑定练习</h1>

  <!-- 属性绑定：将属性值与变量绑定 -->
  <input type="text" v-bind:value="info">
  <!-- 简写 -->
  <input type="text" :value="info">
  <!-- 可以拼接 -->
  <input type="text" :value="info+'内容拼接'">

  <hr>
  <a :href="url">超链接</a>

</template>

<style scoped>

</style>