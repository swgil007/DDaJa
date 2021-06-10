<template>
  <div class="main">
    <div class="main-logo-div">
      <img :src="Logo" class="logo" style="">
    </div>
    <router-link to="/admin/user">
      <el-button type="primary" icon="el-icon-user-solid">회원 관리</el-button>
    </router-link>
    <router-link to="/admin/license">
      <el-button type="primary" icon="el-icon-star-on">자격증 관리</el-button>
    </router-link>
    <router-link to="/admin/notice">
      <el-button type="primary" icon="el-icon-tickets">공지사항 관리</el-button>
    </router-link>
    <router-link to="/admin/question">
      <el-button type="primary" icon="el-icon-star-on">문제 관리</el-button>
    </router-link>
    <div class="main-bottom" />

    <el-calendar v-model="CalendarDate" />
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
// import question from '../question'
// import notice from '../notice'
// import license from '../license'
// import user from '../user'

export default {
//    components: {
//   question,
//   notice,
//   license,
//   user
// },
  data() {
    return {
      Logo: mainLogo,
      CalendarDate: new Date()
    }
  }

}
</script>

<style lang="scss" scoped>
.main{
  background-color: rgb(11, 8, 49);
}
.main-logo-div{
  padding-left: 44%;
  width: 100%;
  float: left;
  background-color: rgb(197, 241, 232);
  .logo{
        width: 200px;
        height: 200px;
  }
}
.main-bottom{
  width: 100%;
  height: 200px;
  float: left;
  background-color: rgb(197, 241, 232);
}
</style>
