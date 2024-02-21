<script setup>
import {ref} from "vue";

const info = ref("双向绑定");

const user = ref({username: "sakai", password: "root", gender: "1"})

const submit = () => {
  // 注意：在JS中响应式变量必须加.value(在HTML和CSS中不需要添加)
  console.log(user.value.username)
  console.log(user.value.password)
  console.log(user.value.gender)
}
</script>

<template>

  <h1>双向绑定</h1>
  {{ info }}
  <input :value="info" type="text">
  <hr>
  <!--
   双向绑定的用法：将页面与数据进行绑定
   1.info中的数据会显示在页面中
   2.页面的值发生改变，info变量的值也会随之改变
    -->
  <input v-model="info" type="text">

  <h3>登录页面</h3>
  <input v-model="user.username" placeholder="请输入用户名" type="text">
  <input v-model="user.password" placeholder="请输入密码" type="password">
  <br>性别
  <input v-model="user.gender" name="gender" type="radio" value="1">男
  <input v-model="user.gender" name="gender" type="radio" value="0">女
  <br>
  <input type="button" value="login" @click="submit()">

</template>

<style scoped>

</style>