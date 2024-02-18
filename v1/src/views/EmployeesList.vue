<script setup>
import {ref} from "vue";

const tableColumns = ref([
  {type: 'index', label: '编号', width: 80},
  {prop: 'name', label: '姓名'},
  {prop: 'salary', label: '工资'},
  {prop: 'job', label: '岗位'},
]);

//所有员工数组
const arr = ref([])

//新添加员工数组
const emp = ref({
  name: '', salary: '', job: ''
})

//定义函数
const add = () => {
  arr.value.push({...emp.value})
}

const del = ($index, row) => {

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
    <el-table-column v-for="item in tableColumns" v-bind="item"></el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>