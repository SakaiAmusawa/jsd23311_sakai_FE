<script setup>

import router from "@/router";
import {onMounted, ref} from "vue";
import axios from "axios";
import qs from "qs";

//1.定义一个数字，装二级分类
const recipeCatArr = ref([]);
const videoCatArr = ref([]);
const infoCatArr = ref([]);
console.log(recipeCatArr)
//2.立即执行
onMounted(() => {
  //3.分别获取三个数据的二级分类
  axios.get('http://localhost:8080/v1/categories/1/sub')
      .then((response) => {
        if (response.data.code === 2001) {
          recipeCatArr.value = response.data.data;
        }
      })
  axios.get('http://localhost:8080/v1/categories/2/sub')
      .then((response) => {
        if (response.data.code === 2001) {
          videoCatArr.value = response.data.data;
        }
      })
  axios.get('http://localhost:8080/v1/categories/3/sub')
      .then((response) => {
        if (response.data.code === 2001) {
          infoCatArr.value = response.data.data;
        }
      })
  //6.调用加载内容的方法   加载三种类型的全部内容
  loadContents(1, 0)
  loadContents(2, 0)
  loadContents(3, 0)
})

//4.准备三个内容数组
const recipeArr = ref([]);
const videoArr = ref([]);
const infoArr = ref([]);
//5.定义加载内容方法
const loadContents = (type, categoryId) => {
  let data = qs.stringify({type: type.value, categoryId: categoryId})
  axios.get('http://localhost:8080/v1/content/index?' + data)
      .then((response) => {
        if (response.data.code === 2001) {
          //三合一：根据不同的type将响应数据存入不同的内容数组中去
          switch (type) {
            case 1:
              recipeArr.value = response.data.data;
              break;
            case 2:
              videoArr.value = response.data.data;
              break;
            case 3:
              infoArr.value = response.data.data;
          }
        }
      })
};
</script>

<template>
  <div style="width: 1200px;margin: 0 auto;">

    <el-carousel>
      <el-carousel-item v-for="item in 3">
        <img :src="'/imgs/banner'+item+'.jpg'" alt="轮播图" style="width: 100%;height: 100%;">
      </el-carousel-item>
    </el-carousel>

    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">烘焙食谱</p>
      </el-col>
      <el-col :span="21">
        <el-menu active-text-color="orange" mode="horizontal" default-active="0">
          <el-menu-item index="0">全部</el-menu-item>
          <el-menu-item v-for="c in recipeCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col v-for="item in 4" :span="6">
        <el-card class="box-card">
          <router-link style="text-decoration: none;color: #333" to="/detail">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">烘焙视频</p>
      </el-col>
      <el-col :span="21">
        <el-menu active-text-color="orange" mode="horizontal" default-active="0">
          <el-menu-item index="0">全部</el-menu-item>
          <el-menu-item v-for="c in videoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col v-for="item in 4" :span="6">
        <el-card class="box-card">
          <router-link style="text-decoration: none;color: #333" to="/detail">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
    <el-row :gutter="10" style="background-color: #fff; margin-top: 10px;">
      <el-col :span="3">
        <p style="font-size: 28px;margin: 10px">行业资讯</p>
      </el-col>
      <el-col :span="21">
        <el-menu active-text-color="orange" mode="horizontal" default-active="0">
          <el-menu-item index="0">全部</el-menu-item>
          <el-menu-item v-for="c in infoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col v-for="item in 4" :span="6">
        <el-card class="box-card">
          <router-link style="text-decoration: none;color: #333" to="/detail">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <!--作者与分类-->
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin: 10px;">
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
  </div>
</template>

<style scoped>

</style>