<script setup>

</script>

<template>
  <h1>隐藏显示指令</h1>
  <!-- v-if="boolean" 控制元素是否显示 true显示，false隐藏（默认true）  -->
  <p v-if="true">张三</p>
  <p v-if="true">李四</p>
  <p v-if="false">王五</p>
</template>

<style scoped>

</style>