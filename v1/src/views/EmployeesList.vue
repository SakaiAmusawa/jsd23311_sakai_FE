<script setup>
import {ref} from "vue";

const tableColumns = ref([
  {prop: 'name', lable: '姓名'},
  {prop: 'salary', lable: '工资'},
  {prop: 'job', lable: '岗位'},
]);

const arr = ref([])

const emp = ref({
  name: '', salary: '', job: ''
})

//定义函数
const add = () => {
  arr.value.push({...emp.value})
}
</script>

<template>
  <h1>员工列表综合练习</h1>
  <el-form style="width: 600px;margin: 0 auto">
    <el-form-item label="姓名">
      <el-input placeholder="请输入姓名" v-model="emp.name"></el-input>
    </el-form-item>
    <el-form-item label="工资">
      <el-input placeholder="请输入工资" v-model="emp.salary"></el-input>
    </el-form-item>
    <el-form-item label="岗位">
      <el-input placeholder="请输入岗位" v-model="emp.job"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="success" @click="add()">点我提交</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="arr" style="width: 600px;margin: 0 auto">
    <el-table-column v-for="item in tableColumns">

    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>