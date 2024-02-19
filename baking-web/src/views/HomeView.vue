<template>
  <div class="common-layout">
    <el-container>
      <el-header style="background-color: #fff;height: 80px;">
        <!--头部-->
        <el-row :gutter="20" style="width: 1200px;margin: 0 auto;">
          <el-col :span="6">
            <!--头部logo图片-->
            <img alt="LOGO" src="/imgs/icon.png" style="width: 200px;">
          </el-col>
          <el-col :span="10">
            <!--头部导航栏-->
            <el-menu active-text-color="orange" mode="horizontal" style="height: 70px;">
              <el-menu-item index="1">食谱</el-menu-item>
              <el-menu-item index="2">视频</el-menu-item>
              <el-menu-item index="3">咨询</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="6">
            <!--头部搜索框-->
            <el-input placeholder="请输入您要搜索的内容" style="margin-top: 25px;">
              <template #append>
                <el-button :icon="Search"></el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="2">
            <!--气泡卡片-->
            <el-popover title="欢迎访问烘焙坊">
              <template #reference>
                <router-link to="/personal">
                  <el-icon size="25" style="margin-top: 30px;" color="#666">
                    <User/>
                  </el-icon>
                </router-link>
              </template>
              <div style="text-align: center">
                <el-button type="info" size="small">注册</el-button>
                <el-button type="warning" size="small">登录</el-button>
              </div>
            </el-popover>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script setup>
import {Search} from '@element-plus/icons-vue'
</script>
