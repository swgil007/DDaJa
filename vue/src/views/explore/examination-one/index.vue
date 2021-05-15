<template>
  <div class="main-container">
    <div class="main-title"><font class="title-font">{{ licenseInfo.licenseName }} - 한문제씩 풀기 🌠</font></div>
    <div class="subject-content-box">
      <div v-for="vo in subject" :key="vo.subjectid" class="subject-content">
        <div
          class="subject-box"
          :class="colorSelect(vo.subjectid)"
        >
          <span class="subject-name-style">{{ vo.subjectName }} </span>
        </div>
        <div class="chart-box">
          <span>==> {{ vo.subjectName }} </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: '',
  components: { },
  data() {
    return {
      attachRed: false,
      licenseInfo: [],
      subject: []
    }
  },
  created() {
    this.licenseInfo = this.$session.get('licenseInfo')
    this.subject = this.licenseInfo.subject
  },
  methods: {
    colorSelect: function(colorKey) {
    	return colorKey % 7 === 1 ? 'bgc1'
        : colorKey % 7 === 2 ? 'bgc2'
          : colorKey % 7 === 3 ? 'bgc3'
            : colorKey % 7 === 4 ? 'bgc4'
              : colorKey % 7 === 5 ? 'bgc5'
                : colorKey % 7 === 6 ? 'bgc6'
                  : colorKey % 7 === 7 ? 'bgc7' : 'bgc1'
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');

.main-container{
    width: 100%;
    text-align: center;
    padding: 30px;
    overflow:auto;
    background-color: rgb(11, 8, 49);
    .main-title{
        border: 20px solid #ffde24;
        margin-top: 5px;
        margin-bottom: 30px;
        background-color: rgb(252, 255, 62);
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1.5% 2% 1.5% 2%;
        .title-font{
            font-size: 50px;
            font-family: 'Kirang Haerang', cursive;
        }
    }
}

.subject-content-box{
    height: 400px;
    .subject-content{
        height: 400px;
        .subject-box{
            width: 38%;
            height: 350px;
            margin-top: 20px;
            margin-left: 10%;
            margin-right: 1%;
            padding-top: 8%;
            float: left;
            border: 20px solid rgb(255, 255, 255);

            .subject-name-style{

                color: aliceblue;
                font-size: 40px;
                font-family: 'Kirang Haerang', cursive;
            }
        }
        .chart-box{
            width: 38%;
            height: 350px;
            margin-top: 20px;
            margin-left: 2%;
            padding-top: 8%;
            float: left;
            border: 1px solid yellow;
            color: aliceblue;
        }
    }
}

.bgc1 { background-color: #23049d;}
.bgc2 { background-color: #aa2ee6;}
.bgc3 { background-color: #ff79cd;}
.bgc4 { background-color: #ffdf6b;}
.bgc5 { background-color: #96bb7c;}
.bgc6 { background-color: #ff5200; }
</style>
