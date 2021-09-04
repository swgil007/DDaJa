<template>
  <div>
    <div class="main-logo-div">
      <img :src="Logo" class="logo" style="" @click="test123()">
    </div>
    <mainCategory />
    <successfulStatus />
    <div class="status-div">
      <div class="status-div-realtime"><realTimeStatus /></div>
      <div class="status-div-dday"><examinationDay /></div>
    </div>
    <notice />
    <div class="main-bottom" />
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
import mainCategory from './component/main-category'
import successfulStatus from './component/successful-status'
import examinationDay from './component/examination-day'
import realTimeStatus from './component/real-time-status'
import notice from './component/notice'
import { getToken } from '@/utils/auth'
import {test} from '@/api/test'

export default {
  components: {
    mainCategory,
    successfulStatus,
    examinationDay,
    realTimeStatus,
    notice,
    getToken
  },

  data() {
    return {
      Logo: mainLogo
    }
  },

  /** Token 이 없다면 visitor 부여 **/
  beforeCreate: function() {
    var token = getToken()

    if (token != 'admin-token' && token != 'editor-token') {
      var visitorInfo = {
        username: 'visitor',
        password: '111111'
      }

      this.$store.dispatch('user/login', visitorInfo)
        .then(() => {
          this.$router.push({ path: this.redirect || '/', query: '' })
        })
    }
  }

  , methods :{
    async test123(){
  try{
    await test().then( response => {
        console.log(response)
      })
  }
      catch (error) {
        console.log('error.response.data.message============ ')

        console.log(error)
      }

    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');

.status-div{
  float: left;
  width: 100%;
  height: 100%;
  padding-left: 7%;
  padding-top: 30px;
  padding-bottom: 30px;
  background-color: rgb(11, 8, 49);
  .status-div-realtime{
    width: 800px;
    height: 500px;
    float: left;
    margin-right: 28px;
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .status-div-dday{
    width: 800px;
    height: 500px;
    float: left;
    margin-top: 20px;
    margin-bottom: 20px;
  }
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
