<script setup>

</script>

<template>
  <div style="width: 1200px;margin: 0 auto;">
    <el-row :gutter="10" style="margin-top: 5px;">
      <el-col v-for="item in 4" :span="6">
        <el-card class="box-card">
          <router-link style="text-decoration: none" to="/detail">
            <img alt="" src="/imgs/a.jpg" style="width: 100%;height: 150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <el-row :gutter="10" style="margin-top: 5px;">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size: 20px;line-height: 40px">传奇哥</el-col>
            <el-col :span="4" style="line-height: 40px">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<style scoped>

</style>