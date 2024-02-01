<script setup>

let count = 0;
const f = () => {
  count++;
  console.log("点击了" + count + "次")
}

const enter = () => {
  alert("输入成功")
}
</script>

<template>
  <h1>事件绑定</h1>
  <!-- 下面两种按钮的点击事件效果一样 -->
  <h3>鼠标点击事件</h3>
  <button @click="f()">按钮一</button>
  <button @click="f()">按钮二</button>
  <h3>回车键按下事件</h3>
  <!--
   @keydown 表示在键盘上按下指定的键来触发
   .enter 代表的是按下回车键触发
   -->
  <input type="text" @keydown.enter="enter()">
</template>
<style scoped>

</style>