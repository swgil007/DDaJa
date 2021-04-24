<template>
  <div>
    <div class="main-logo-div">
      <img v-bind:src="Logo" class="logo" style="">
    </div> 
    <mainCategory/>
    <successfulStatus/> 
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
import mainCategory from './component/main-category'
import successfulStatus from './component/successful-status'
import examinationDay from './component/examination-day'

export default {
  data() {
    return {
      Logo: mainLogo  
    };
  },
  components :{
    mainCategory,
    successfulStatus,
    examinationDay
  }
};
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
</style>