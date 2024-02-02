<script setup>

import {ref} from "vue";

const edu = ref("学历");

const arr = ref([
  {title: "apple🍎", price: 5},
  {title: "banana🍌", price: 3},
  {title: "pear🍐", price: 6},
  {title: "orange🍊", price: 7},
])

const showPrice = ref("$$$")
</script>

<template>
<h1>单选组件</h1>
  <el-radio-group v-model="edu">
    <el-radio-button label="初中">学历：初中</el-radio-button>
    <el-radio-button label="高中">学历：高中</el-radio-button>
    <el-radio-button label="专科">学历：专科</el-radio-button>
    <el-radio-button label="本科">学历：本科</el-radio-button>
  </el-radio-group>
  <h4>{{ edu }}</h4>

  <hr>

  <el-radio-group v-model="showPrice">
    <el-radio-button :label="fruit.price" v-for="fruit in arr">{{ fruit.title }}</el-radio-button>
  </el-radio-group>
  <h4>{{ showPrice }}</h4>
</template>

<style scoped>

</style>