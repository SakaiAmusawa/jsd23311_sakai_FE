<template>
  <h1>布局组件</h1>
  <!--gutter设置间距  -->
  <el-row :gutter="10">
    <!--分row的列,一共有24列 :span="6"表示当前行占6列,也就是1/4    -->
    <el-col :span="6" style="background-color: #0aa1ed;">哈哈哈</el-col>
    <el-col :span="6">哈哈哈</el-col>
    <el-col :span="6" style="background-color: #0aa1ed;">哈哈哈</el-col>
    <el-col :span="6">哈哈哈</el-col>
  </el-row>

  <h3>两张图</h3>
  <el-row :gutter="10">
    <el-col :span="12"><img src="rich.jpg" style="width:100%"></el-col>
    <el-col :span="12"><img src="rich.jpg" style="width:100%"></el-col>
  </el-row>
  <h3>六张图</h3>
  <el-row :gutter="10">
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
    <el-col :span="4"><img src="2024.png" style="width:100%"></el-col>
  </el-row>
  <h3>列偏移</h3>
  <el-row :gutter="10">
    <!-- :offset="0" 0就表示不偏移,默认靠左   -->
    <el-col :offset="0" :span="20"><img src="rich.jpg" style="width:100%"></el-col>
  </el-row>
  <el-row :gutter="10">
    <!-- :offset="4" 4表示偏移4列,因为就剩4列了,所以靠右   -->
    <el-col :offset="4" :span="20"><img src="rich.jpg" style="width:100%"></el-col>
  </el-row>
  <el-row :gutter="10">
    <!-- :offset="2" 2表示偏移2列,最右边还剩2列,左右各两列,所以居中   -->
    <el-col :offset="2" :span="20"><img src="rich.jpg" style="width:100%"></el-col>
  </el-row>
  <!-- 练习1:创建8等分 里面分别显示1,2,3...8 -->
  <el-row :gutter="10">
    <el-col v-for="item in 8" :span="3" style="border:5px solid #f00">{{ item }}</el-col>
  </el-row>
  <!-- 练习2:创建3部分 比例为 1:2:3 每个里面显示图片 间距20 -->
  <el-row :gutter="20">
    <el-col :span="4"><img src="rich.jpg" width="100%"></el-col>
    <el-col :span="8"><img src="rich.jpg" width="100%"></el-col>
    <el-col :span="12"><img src="rich.jpg" width="100%"></el-col>
  </el-row>
  <!-- 练习3:创建一部分里面显示一张图片，宽度为屏幕的一半，并且居中 -->
  <el-row :gutter="10">
    <el-col :offset="6" :span="12"><img src="rich.jpg" width="100%"></el-col>
  </el-row>
  <h3>布局嵌套</h3>
  <el-row :gutter="10">
    <el-col :span="12" style="border:5px solid #f00;">12</el-col>
    <el-col :span="12" style="border:5px solid #0f0;">
      <el-row :gutter="10">
        <el-col v-for="item in 4" :span="6" style="border:2px solid #00f">6</el-col>
      </el-row>
    </el-col>
  </el-row>
</template>

<script setup>

</script>

<style scoped>

</style>