<template>
  <nav>
    <router-link to="/">Home</router-link>
    |
    <router-link to="/about">About</router-link>
    |
    <router-link to="/bind">属性绑定联系</router-link>
    |
    <router-link to="/TW-bind">双向绑定</router-link>
    |
    <router-link to="/Event-bind">事件绑定</router-link>
    |
    <router-link to="/For-cmd">循环指令</router-link>
    |
    <router-link to="/hidden-display">隐藏显示指令</router-link>
    |
    <br>
    <router-link to="/calculator">计算器</router-link>
    |
    <router-link to="/guess">猜数字练习</router-link>
    |
    <router-link to="/empList">员工列表练习</router-link>
    |
    <router-link to="/resume">个人简历练习</router-link>
    |
    <br>
    <router-link to="/elButton">El-按钮组件</router-link>
    |
    <router-link to="/elIcon">El-图标组件</router-link>
    |
    <router-link to="/elMessage">El-消息组件</router-link>
    |
    <router-link to="/elRadio">El-单选组件</router-link>
    |
    <router-link to="/elSelect">El-选择器组件</router-link>
    |
    <router-link to="/elSwitch">El-开关组件</router-link>
    |
    <router-link to="/elForm">El-表单组件</router-link>
    |
    <router-link to="/r">El-组件</router-link>
    |
    <router-link to="/s">El-组件</router-link>
    |
    <router-link to="/t">El-组件</router-link>
    |
    <router-link to="/u">El-组件</router-link>
    |
    <router-link to="/v">El-组件</router-link>
    |
    <router-link to="/w">El-组件</router-link>
    |
    <router-link to="/x">El-组件</router-link>
    |
    <router-link to="/EmployeesList">员工列表综合练习</router-link>
    |
    <router-link to="/exec">综合练习</router-link>
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script setup>
</script>