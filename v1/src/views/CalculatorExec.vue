<script setup>
import {ref} from "vue";

const a = ref("");
const b = ref("");
const result = ref("0");

const calculator = (o) => {
  result.value = a.value + o + b.value;
  // eval("字符串") 作用:将字符串以JS代码的形式运行
  // eval("5+2") 结果:7
  result.value = eval(a.value + o + b.value);
}
</script>

<template>
  <h1>计算器</h1>
  <input v-model="a" name="" placeholder="请输入数字" type="text">
  <input v-model="b" name="" placeholder="请输入数字" type="text">
  <br>
  <button @click="calculator('+')">加</button>
  <button @click="calculator('-')">减</button>
  <button @click="calculator('*')">乘</button>
  <button @click="calculator('/')">除</button>
  <br>
  <h4>运算结果：{{ result }}</h4>
</template>

<style scoped>

</style>