<script setup>
import {ref} from "vue";

const isShow = ref(true)
</script>

<template>
  <h1>隐藏显示指令</h1>
  <!-- v-if="boolean" 控制元素是否显示 true显示，false隐藏（默认true）  -->
  <p v-if="true">张三</p>
  <p v-if="true">李四</p>
  <p v-if="false">王五</p>

  <hr>

  <!-- v-if="变量" 进一步使用变量来控制元素是否显示 -->
  <p v-if="isShow">🌙</p>
  <p v-if="isShow">✨</p>
  <!-- 与v-if相反 -->
  <p v-else>☀️</p>

  <hr>

  <!-- v-show是使用display:none；修改元素的显示模式为隐藏 -->
  <!-- v-if=“false” 是直接在HTML中=删除元素 -->
  <p v-show="false">小绿</p>
  <p>小红</p>
  <!-- 推荐 v-show 开销较小 -->

</template>

<style scoped>

</style>