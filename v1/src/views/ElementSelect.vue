<template>
  <h1>选择器组件</h1>
  <el-select v-model="city" placeholder="请选择城市" style="width: 50%;">
    <el-option label="北京" value="bj"></el-option>
    <el-option label="成都" value="cd"></el-option>
    <el-option label="杭州" value="hz"></el-option>
    <el-option label="南京" value="nj"></el-option>
  </el-select>
</template>

<script setup>
import {ref} from "vue";

const city = ref("hz");
</script>

<style scoped>

</style>