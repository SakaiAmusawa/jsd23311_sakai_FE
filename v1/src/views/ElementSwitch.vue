<template>
  <h1>开关组件</h1>
  <el-switch v-model="value1"/>
  <el-switch v-model="value2" class="ml-2"
             style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949"
  />
  <hr>
  是否是管理员:
  <el-switch v-model="isAdmin"></el-switch>
  <hr>
  是否显示图片:
  <el-switch v-model="isShow"></el-switch>
  <hr>
  <img v-show="isShow" src="fcq.jpg" width="200px">
</template>

<script setup>
import {ref} from 'vue'

const value1 = ref(false)
const value2 = ref(true)
const isAdmin = ref(false);
const isShow = ref(true);
</script>

<style scoped>

</style>