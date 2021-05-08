<template>
  <div>
    <div class="main-logo-div">
      <img :src="Logo" class="logo" style="">
    </div>
    <user />
    <license />
    <notice />
    <exam />
    <div class="main-bottom" />
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
import exam from '../exam'
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
