<template>
  <div class="cotegory-container">
    <div class="title-style"><font class="title-font">{{ licenseInfo.licenseName }}</font></div>
    <div>
      <router-link to="/explore/examination-one"><div class="box-style-1"> <font class="box-font">한 문 제 씩 탐 험 해 보 기</font> </div> </router-link>
      <router-link to="/explore/examination-word"><div class="box-style-2"> <font class="box-font">단 어 암 기</font> </div></router-link>
      <router-link to="/explore/examination"><div class="box-style-3"> <font class="box-font">모 의 고 사</font> </div></router-link>
    </div>
    <div>
      <router-link to="/explore/acceptance-review"><div class="box-style-4"> <font class="box-font">합 격 후 기</font> </div></router-link>
      <router-link to="/explore/license-information"><div class="box-style-5"> <font class="box-font">자 격 증 정 보</font> </div></router-link>
      <router-link to=""><div class="box-style-6"> <font class="box-font">-</font> </div></router-link>
    </div> 
  </div>
</template>

<script>

export default {
  name: '',
  components: { },
  data() {
    return {
      licenseInfo: []
    }
  },
  created() {
    this.licenseInfo = this.$session.get('licenseInfo') 
  },
  methods: { }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap'); 
.cotegory-container {
  text-align: left;
  padding: 30px;
  overflow:auto; 
}
.title-style{ 
  margin-top: 5px;
  margin-bottom: 5px; 
  color: rgb(0, 0, 0);
  margin-left: 1%;
  margin-right: 2%;
  padding: 1.5% 2% 1.5% 2%;
}
.title-font{ font-size: 50px;   font-family: 'Do Hyeon', sans-serif;}
.box-style-1{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px; float: left; width: 31%; height: 230px; background-color:#e9bcc5; margin: 1%; text-align: center; padding-top:85px }
.box-style-1:hover { background-color: #f75273; }
.box-style-2{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px; float: left; width: 31%; height: 230px; background-color:#f5da9f; margin: 1%; text-align: center; padding-top:85px }
.box-style-2:hover { background-color:#fcc141; }
.box-style-3{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 230px; background-color:#ecf7b3; margin: 1%; text-align: center; padding-top:85px }
.box-style-3:hover { background-color:#daf74b; }
.box-style-4{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 230px; background-color:#b7ffa9; margin: 1%; text-align: center; padding-top:85px }
.box-style-4:hover { background-color:#6af34e; }
.box-style-5{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 230px; background-color:#a1cff5; margin: 1%; text-align: center; padding-top:85px }
.box-style-5:hover { background-color:#4caaf7; }
.box-style-6{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 230px; background-color:#5a70ee; margin: 1%; text-align: center; padding-top:85px }
.box-style-6:hover { background-color:#2645f7; }
.box-font{ font-size: 40px;  font-family: 'Do Hyeon', sans-serif; }

</style>
