<script setup>
import {ref} from "vue";

const arr = ref(["张三", "李四", "王五", "赵六", "钱七", "周八"])
</script>

<template>
  <h1>循环指令练习</h1>
  <!-- 遍历arr数组，取出每个值存入uname中，uname就是当前遍历到的元素 -->
  <ul>
    <li v-for="uname in arr">{{ uname }}</li>
  </ul>
  <!-- 从1到20遍历，固定写法，默认从1开始，步长为1，结束数字可以自定义 -->
  <ol>
    <li v-for="item in 20">{{ item }}</li>
  </ol>
</template>

<style scoped>

</style>