<template>
  <div class="main">
    <div class="main-logo-div">
      <img :src="Logo" class="logo" style="">
    </div>
    <router-link to="/admin/user">
      <user />
    </router-link>
    <router-link to="/admin/license">
      <license />
    </router-link>
    <router-link to="/admin/notice">
      <notice />
    </router-link>
    <router-link to="/admin/exam">
      <exam />
    </router-link>
    <div class="main-bottom" />
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
import exam from '../examination'
import notice from '../notice'
import license from '../license'
import user from '../user'

export default { components: {
  exam,
  notice,
  license,
  user
},
data() {
  return {
    Logo: mainLogo
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
