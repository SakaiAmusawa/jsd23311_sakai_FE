<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-menu mode="horizontal" background-color="#0aa1ed" text-color="#fff" active-text-color="#ff0"
                 default-active="1">
          <el-menu-item index="1">精彩活动</el-menu-item>
          <el-menu-item index="2">精品女装</el-menu-item>
          <el-menu-item index="3">品牌男装</el-menu-item>
          <el-menu-item index="4">母婴产品</el-menu-item>
          <el-menu-item index="5">数码科技</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <!--   主体部分是可变区域     -->
        <router-view/>
      </el-main>
      <el-footer style="background-color: #282c30;color: #666;height: 200px;padding-top: 40px;">
        <p>.......</p>
        <p>.......</p>
        <p>.......</p>
      </el-footer>
    </el-container>
  </div>
</template>

<script setup>

</script>
