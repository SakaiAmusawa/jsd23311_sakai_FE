<script setup>
//自动导入的内容
import {ref} from "vue";

//声明一个常量，他是一个响应式的
const pi = ref(3.1415926)
let name = ref("周佳伟")
let test = ref("点击按钮加粗字体")

let ButtonFunction = () => {
  name.value = "佳伟哥的英文名字出现了：sakai amusawa"
  test.value = "<b>字体已加粗</b>"
}
</script>


<template>
  <h1>{{ pi }}</h1>
  {{ name }}

  <!-- v-text="响应式变量名" 让此处的文本与变量进行绑定 -->
  <p v-text="name"></p>

  <p v-html="test"></p>


  <button @click="ButtonFunction()">点击按钮发现秘密</button>
</template>

<style scoped>

</style>