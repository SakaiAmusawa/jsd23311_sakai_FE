<script setup>

import router from "@/router";
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import qs from "qs";

const arr = ref([]);
const type = ref('1');
const catTypeArr = ref([])

let user = localStorage.user ? JSON.parse(localStorage.user) : null;

onMounted(() => {
  //发送请求获取一级分类数据
  axios.get('http://localhost:8080/v1/categories/type').then(
      (response) => {
        if (response.data.code === 2001) {
          catTypeArr.value = response.data.data;
        }
      }
  )

  let data = qs.stringify({userId: user.id, type: type.value});

  axios.get('http://localhost:8080/v1/content/management?' + data).then(
      (response) => {
        if (response.data.code === 2001) {
          arr.value = response.data.data;
        }
      }
  )
})

const del = (i) => {
  if (confirm('确认删除吗？')) {
    arr.value.splice(i, 1)
    ElMessage.success('删除成功')
  }
}
const typeChange = (type) => {

  let data = qs.stringify({userId: user.id, type: type});

  axios.get('http://localhost:8080/v1/content/management?' + data).then(
      (response) => {
        if (response.data.code === 2001) {
          arr.value = response.data.data;
        }
      }
  )
}
</script>

<template>
  <el-radio-group>
    <!--    <el-radio-button label="1">烘焙食谱</el-radio-button>
        <el-radio-button label="2">烘焙视频</el-radio-button>
        <el-radio-button label="3">行业资讯</el-radio-button>-->
    <el-radio-button v-for="c of catTypeArr" :label="c.type" @change="typeChange(c.type)">{{ c.name }}</el-radio-button>
  </el-radio-group>
  <el-button style="margin-left: 20px;margin-top: 7px;" type="primary" @click="router.push('/personal/post')">发布内容
  </el-button>
  <el-table :data="arr">
    <el-table-column align="center" label="编号" type="index" width="80"></el-table-column>
    <el-table-column align="center" label="标题" prop="title" width="290"></el-table-column>
    <el-table-column align="center" label="分类" prop="categoryName" width="80"></el-table-column>
    <el-table-column align="center" label="浏览量" prop="viewCount" width="80"></el-table-column>
    <el-table-column align="center" label="评论量" prop="commentCount" width="80"></el-table-column>
    <el-table-column align="center" label="发布时间" prop="createTime" width="120"></el-table-column>
    <el-table-column align="center" label="操作">
      <template #default="scope">
        <el-button-group>
          <el-button size="small" type="success">编辑</el-button>
          <el-button size="small" type="danger" @click="del(scope.$index)">删除</el-button>
        </el-button-group>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>