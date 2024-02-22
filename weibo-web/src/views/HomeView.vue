<template>
  <h1>首页</h1>
  <!-- 如果用户信息为空，显示登录注册 -->
  <div v-if="user==null">
    <router-link to="/reg">注册</router-link>
    <router-link to="/login">登录</router-link>
  </div>
  <!-- 如果用户信息不为空，显示欢迎信息，并显示发微博与退出登录 -->
  <div v-else>
    <h2>欢迎{{ user.nickname }}回来！</h2>
    <router-link to="/post">
      <el-button>发微博</el-button>
    </router-link>
    <router-link to="/personal">
      <el-button>我的微博</el-button>
    </router-link>
    <el-button @click="logout()">退出登录</el-button>
  </div>

  <hr>
  <div v-for="weibo in arr">
    <router-link :to="'/detail?id='+weibo.id" style="text-decoration: none;color: black"><h3>{{ weibo.nickname }}说：{{
        weibo.content
      }}</h3>
    </router-link>

  </div>

</template>

<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";

const user = ref(localStorage.user ? JSON.parse(localStorage.user) : null)

const logout = () => {
  if (confirm('确认退出吗？')) {
    //清空上次登录成功存入的用户信息，但不会影响已经取出来的user数据
    localStorage.clear();
    //还需要将响应式变量user的值充值为null，上面的页面才会一起重置
    user.value = null;
  }

}

const arr = ref([
  onMounted(() => {
    axios.get('http://localhost:8080/v1/weibo/list').then((response) => {
      if (response.data.code === 2001) {
        arr.value = response.data.data;
      }
    })
  })
]);

</script>
