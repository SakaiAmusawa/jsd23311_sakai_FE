<template>
  <h1>登录页</h1>
  <el-card class="box-card" style="width: 500px;height: 200px;margin: 0 auto;">
    <el-form label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="login.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="login.password" placeholder="密码" type="password" @keydown.enter="log()"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 100%;" type="primary" @click="log()">登录</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script setup>

import {ref} from "vue";
import qs from "qs"
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const login = ref({
  username: '',
  password: ''
})

const log = () => {
  let data = qs.stringify(login.value)
  axios.post('http://localhost:8080/v1/users/login', data).then((response) => {
    if (response.data.code === 2001) {
      let user = response.data.data;
      ElMessage.success('登录成功!欢迎' + user.nickname + '回来');
      localStorage.setItem('user', JSON.stringify(user))
      router.push('/')
    } else {
      ElMessage.error(response.data.msg)
    }
  })
}

</script>

<style scoped>

</style>