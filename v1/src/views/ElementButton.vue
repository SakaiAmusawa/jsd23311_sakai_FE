<script setup>

</script>

<template>
  <h1>
    El-按钮组建
  </h1>
  <el-button>默认按钮</el-button>
  <el-button type="primary">主要按钮</el-button>
  <el-button type="success">成功按钮</el-button>
  <el-button type="info">信息按钮</el-button>
  <el-button type="warning">警告按钮</el-button>
  <el-button type="danger">危险按钮</el-button>
  <br>
  <el-button plain>朴素按钮</el-button>
  <el-button plain type="primary">主要按钮</el-button>
  <el-button plain type="success">成功按钮</el-button>
  <el-button plain type="info">信息按钮</el-button>
  <el-button plain type="warning">警告按钮</el-button>
  <el-button plain type="danger">危险按钮</el-button>
  <br>
  <el-button round>圆角按钮</el-button>
  <el-button round type="primary">主要按钮</el-button>
  <el-button round type="success">成功按钮</el-button>
  <el-button round type="info">信息按钮</el-button>
  <el-button round type="warning">警告按钮</el-button>
  <el-button round type="danger">危险按钮</el-button>
  <br>
  <el-button circle icon="el-icon-search"></el-button>
  <el-button circle icon="el-icon-edit" type="primary"></el-button>
  <el-button circle icon="el-icon-check" type="success"></el-button>
  <el-button circle icon="el-icon-message" type="info"></el-button>
  <el-button circle icon="el-icon-star-off" type="warning"></el-button>
  <el-button circle icon="el-icon-delete" type="danger"></el-button>

  <hr>

  <el-button disabled type="primary">禁用按钮</el-button>

  <hr>

  <a href="https://www.baidu.com">
    <el-button link>链接按钮</el-button>
  </a>
  <a href="https://www.jd.com">
    <el-button link type="danger">链接按钮</el-button>
  </a>

</template>

<style scoped>

</style>