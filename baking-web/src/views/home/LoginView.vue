<!--登录页-->
<template>
  <div id="main-div">
    <el-card style="width:500px;height:300px;
    margin:0 auto;position:relative;top:100px;">
      <el-form label-width="60px">
        <el-form-item label="用户名" style="margin-top:60px;">
          <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="user.password" placeholder="请输入密码" type="password"
                    @keydown.enter="login()"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width:100px;margin-left: 120px;" type="primary" @click="login()">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import {ref} from "vue";
import qs from "qs";
import axios from "axios";
import {ElMessage} from "element-plus";

const user = ref({username: '', password: ''});
const login = () => {
  let data = qs.stringify(user.value);
  axios.post('http://localhost:8080/v1/users/login', data)
      .then((response) => {
        if (response.data.code === 2001) {
          ElMessage.success('登录成功!');
          let user = response.data.data;
          localStorage.user = JSON.stringify(user);
          //router.push('/');
          location.href = '/';//登录成功存入用户信息后，立即自动刷新页面
        } else {
          ElMessage.error(response.data.msg);
        }
      })
}
</script>

<style scoped>
#main-div {
  height: 500px;
  background-image: url('/public/imgs/loginbg.gif');
  /*常用于设置封面*/
  background-size: cover;
  background-position: center;
}
</style>