<script setup>

import {Check, SwitchFilled} from "@element-plus/icons-vue";
import {ref} from "vue";

let trueNumber = parseInt(Math.random() * 100) + 1
console.log(trueNumber)
const input = ref();
const result = ref("小提示");

const guessNumber = () => {
  if (isNaN(input.value)) {
    alert("给我滚出去")
    return
  }

  if (input.value > trueNumber) {
    result.value = "大了，往小的猜"
  } else if (input.value == trueNumber) {
    result.value = "有了有了有了"
    alert("📢< ---")
  } else if (input.value < trueNumber) {
    result.value = "小了，往大的猜"
  } else {
    result.value = "我不到啊"
  }
}


</script>

<template>
  <h1>
    <switch-filled style="width: 1em; height: 1em; margin-top: 20px;"/>
    猜数字小游戏
  </h1>

  <input type="text" placeholder="请输入一个1~100之内的数字" v-model="input">

  <el-button type="success" :icon="Check" circle @click="guessNumber()"/>

  <h2>{{ result }}</h2>
</template>

<style scoped>

</style>