<template>
  <el-form v-show="isUserInfoForm" ref="form" :model="form" label-width="120px">
    <el-form-item label="닉네임">
      <el-col :span="11">
        <el-input v-model="form.name" />
      </el-col>
    </el-form-item>
    <el-form-item label="프로필">
      <el-col :span="11">
        <el-upload
          class="avatar-uploader"
          action="http://localhost/user/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
        >
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-col>
    </el-form-item>
    <el-form-item label="가입일">
      <el-col :span="11">
        <el-date-picker v-model="form.date1" type="date" placeholder="Pick a date" style="width: 100%;" :disabled="true" />
      </el-col>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel{{ isUserInfoForm }}</el-button>
    </el-form-item>
  </el-form>

</template>
<script>
export default {
  props: {
    isUserInfoForm: {}
  },
  data() {
    return {
      userInfo: {

      },
      form: {
        name: '',
        date1: '2021-09-27',
        imageUrl: '',
        region: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  created() {
    this.getUserInfo()
  },
  methods: {
    getUserInfo() {
      const jwt = window.localStorage.getItem('jwt')
      if (!jwt) {
        alert('잘못된 접근입니다.')
        // window.history.go(-1)
      }
      this.$http
        .get('http://localhost/users/' + window.localStorage.getItem('userID'), {
          headers: {
            Authorization: jwt
          }
        })
        .then(res => {
          console.log(res)
        })
        .catch(err => {
          console.log(err)
        })
    },
    onSubmit() {
      console.log('submit!')
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
      console.log(this.imageUrl)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('Avatar picture must be JPG format!')
      }
      if (!isLt2M) {
        this.$message.error('Avatar picture size can not exceed 2MB!')
      }
      return isJPG && isLt2M
    }
  }
}
</script>
<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
