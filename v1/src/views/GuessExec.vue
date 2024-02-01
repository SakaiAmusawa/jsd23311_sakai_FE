<script setup>
import {ref} from "vue";

const result = ref("小提示");
let answer = parseInt(Math.random() * 100) + 1;
console.log(answer)
const number = ref();
let count = 0;
const guess = () => {
  count++;
  if (isNaN(number.value)) {
    alert("给我滚出去");
    return;
  }
  if (number.value > answer) {
    result.value = "big";
  } else if (number.value < answer) {
    result.value = "small";
  } else {
    result.value = "回答正确,共计猜测了：" + count + "次";
  }
}

</script>

<template>
  <h1>猜数字练习</h1>
  <input type="text" placeholder="请输入一个1~100之间的整数" v-model="number"><br>
  <input type="button" value="猜测" @click="guess()">
  <h3>{{ result }}</h3>
</template>

<style scoped>

</style>