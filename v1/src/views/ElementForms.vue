<template>
  <h1>表单组件</h1>
  <h2>注册页面</h2>
  <el-form label-width="80px" style="width: 500px;margin: 0 auto;">
    <el-form-item label="用户名">
      <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="user.password" placeholder="请输入密码" show-password></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-radio-group v-model="user.gender">
        <el-radio-button label="男"></el-radio-button>
        <el-radio-button label="女"></el-radio-button>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="所在地">
      <el-select v-model="user.city" placeholder="请选择城市">
        <el-option label="北京" value="bj"></el-option>
        <el-option label="成都" value="cd"></el-option>
        <el-option label="杭州" value="hz"></el-option>
        <el-option label="南京" value="nj"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="管理员">
      <el-switch v-model="user.isAdmin"></el-switch>
    </el-form-item>
    <el-form-item>
      <el-button type="success">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {ref} from "vue";

const user = ref({username: "", password: "", gender: "女", city: "", isAdmin: true});
</script>

<style scoped>

</style>