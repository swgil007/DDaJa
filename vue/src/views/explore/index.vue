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
      <router-link to="/explore/examination-again"><div class="box-style-6"> <font class="box-font">틀 린 문 제 재 탐 험</font> </div></router-link>
    </div>
    <div>
      <router-link to="/explore/score-status"><div class="box-style-7"> <font class="box-font">'{{ licenseInfo.licenseName }}' 점 수</font> </div></router-link>
      <router-link to="/explore/communication"><div class="box-style-8"> <font class="box-font">ㅡ</font> </div></router-link>
      <router-link to="/explore/communication"><div class="box-style-9"> <font class="box-font">ㅡ</font> </div></router-link>
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
  // background-color: rgb(255, 255, 255);
}
.title-style{
  // border: 20px solid whitesmoke;
  margin-top: 5px;
  margin-bottom: 5px;
  // background-color: rgb(226, 226, 226);
  color: rgb(0, 0, 0);
  margin-left: 1%;
  margin-right: 2%;
  padding: 1.5% 2% 1.5% 2%;
}
.title-font{ font-size: 50px;   font-family: 'Do Hyeon', sans-serif;}
.box-style-1{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px; float: left; width: 31%; height: 173px; background-color:#e9bcc5; margin: 1%; text-align: center; padding-top:60px }
.box-style-2{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px; float: left; width: 31%; height: 173px; background-color:#f5da9f; margin: 1%; text-align: center; padding-top:60px }
.box-style-3{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#ecf7b3; margin: 1%; text-align: center; padding-top:60px }
.box-style-4{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#b7ffa9; margin: 1%; text-align: center; padding-top:60px }
.box-style-5{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#a1cff5; margin: 1%; text-align: center; padding-top:60px }
.box-style-6{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#5a70ee; margin: 1%; text-align: center; padding-top:60px }
.box-style-7{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#ce77f1; margin: 1%; text-align: center; padding-top:60px }
.box-style-8{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#a2e6da; margin: 1%; text-align: center; padding-top:60px }
.box-style-9{ border: 10px solid rgb(255, 255, 255); border-radius: 40px 80px / 80px 40px;  float: left; width: 31%; height: 173px; background-color:#ffced2; margin: 1%; text-align: center; padding-top:60px }
.box-font{ font-size: 40px;  font-family: 'Do Hyeon', sans-serif; }
</style>
