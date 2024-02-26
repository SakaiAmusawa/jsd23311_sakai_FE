<!--个人信息页面-->
<template>
  <el-form label-width="100px" style="width:500px;">
    <el-form-item label="头像">
      <!--头像上传开始-->
      <el-upload
          v-model:file-list="fileList"
          action="http://localhost:8080/v1/upload"
          limit="1"
          name="file"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
      >
        <el-icon>
          <Plus/>
        </el-icon>
      </el-upload>

      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
      <!--头像上传结束-->
    </el-form-item>
    <el-form-item label="昵称">
      <el-input placeholder="请输入昵称" v-model="user.nickname"></el-input>
    </el-form-item>
    <el-form-item label="用户名">
      <el-input placeholder="请输入用户名" :value="user.username" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="save()">保存修改</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {ref} from 'vue'
import {Plus} from '@element-plus/icons-vue'
import qs from "qs";
import axios from "axios";
import {ElMessage} from "element-plus";

const user =
    ref(localStorage.user ? JSON.parse(localStorage.user) : null);
console.log(user)
const save = () => {
  let newUser = {id: user.value.id, nickname: user.value.nickname};
  if (fileList.value.length > 0) {
    //得到图片路径
    let url = fileList.value[0].response.data;
    //装到newUser中，给后端更新数据入库使用
    newUser.imgUrl = url;
    //装到user中，一会更新成功存入localStorage中
    user.value.imgUrl = url;

  }
  let data = qs.stringify(newUser);
  axios.post('http://localhost:8080/v1/users/update', data)
      .then((response) => {
        if (response.data.code === 2001) {
          ElMessage.success('修改成功!');
          localStorage.user = JSON.stringify(user.value);
          location.reload()
        }
      })
}

const fileList = ref([])
const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}
const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>

<style scoped>

</style>