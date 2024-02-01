<script setup>
import {ref} from "vue";

const info = ref("双向绑定");
</script>

<template>

  <h1>双向绑定</h1>
  <hr>
  {{ info }}
  <input :value="info" type="text">
  <hr>
  <!-- 双向绑定的用法 -->
  <input v-model="info" type="text">

</template>

<style scoped>

</style>