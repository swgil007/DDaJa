<template>
  <div class="main-container">
    <div class="main-title"><font class="title-font">{{ licenseInfo.licenseName }} - 한문제씩 풀기 🌠</font></div>
    <div class="subject-content-box">
      <div v-for="vo in subject" :key="vo.subjectid" class="subject-content">
        <div
          class="subject-box"
          :class="colorSelect(vo.subjectid)"
        >
          <span class="subject-name-style">
            <div class="name-div">{{ vo.subjectName }} </div>
            <div class="beginning-div"><el-button class="button" @click="examinationPopupOpen(vo.subjectid)"><i class="el-icon-edit" /> 처음부터 풀래요</el-button></div>
            <div class="next-div"><el-button class="button" @click="examinationPopupOpen(vo.subjectid)"><i class="el-icon-edit" /> 이어서 풀래요</el-button></div>
          </span>
        </div>
        <div class="chart-box">
          <div class="box"> 푼거 <el-progress :text-inside="true" :stroke-width="26" :percentage="80" class="chart" /></div>
          <div class="box"> 틀림 <el-progress :text-inside="true" :stroke-width="26" :percentage="30" class="chart" status="success" /></div>
          <div class="box"> 맞음 <el-progress :text-inside="true" :stroke-width="26" :percentage="50" class="chart" status="warning" /></div>
          <div class="box"> 다시 <el-progress :text-inside="true" :stroke-width="26" :percentage="40" class="chart" status="exception" /></div>
        </div>
      </div>
    </div>
    <examinationPopup
      :popup-val="popupVal"
      :subject-examination="subjectExamination"
      @close:examination="examinationPopupClose"
    />
  </div>
</template>

<script>
import examinationPopup from './component/examinationPopup'
import testJson from '../../../assets/jsonFile/subjectExaminationTestJson1'

export default {
  name: '',
  components: {
    testJson,
    examinationPopup
  },
  data() {
    return {
      attachRed: false,
      popupVal: false,
      licenseInfo: [],
      subject: [],
      subjectExamination: testJson
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
    },
    examinationPopupOpen(subjectid) {
      // subjectid 로 해당 과목 문제 가지고 와서
      // subjectExamination 에 담아
      // examinationPopup 에 보내주기.
      this.popupVal = true
    },
    examinationPopupClose(value) {
      this.popupVal = value
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
            float: left;
            border: 20px solid rgb(250, 250, 238);
            .subject-name-style{
                color: aliceblue;
                font-size: 40px;
                font-family: 'Kirang Haerang', cursive;

                .name-div{
                    padding-top: 20%;
                    padding-left: 15%;
                    float: left;
                    width: 50%;
                    height: 100%;
                }
                .beginning-div{
                    padding-top: 7%;
                    float: left;
                    width: 50%;
                    height: 50%;
                    .button{
                        border: 5px solid rgb(173, 187, 252);
                        height: 100px;
                        width: 170px;
                        font-weight: bold;
                    }
                }
                .next-div{
                    padding-top: 3%;
                    float: left;
                    width: 50%;
                    height: 50%;
                    .button{
                        border: 3px solid rgb(253, 183, 183);
                        height: 100px;
                        width: 170px;
                        font-weight: bold;
                    }
                }
            }
        }
        .chart-box{
            width: 38%;
            height: 350px;
            margin-top: 20px;
            margin-left: 2%;
            padding: 4%;
            float: left;
            border: 20px solid rgb(255, 255, 194);
            color: aliceblue;
            .box{
                height: 50px;
                .chart{
                    float: left;
                    width: 90%;
                }
            }

        }
    }
}

.bgc1 { background-color: #23049d;}
.bgc2 { background-color: #aa2ee6;}
.bgc3 { background-color: #ff79cd;}
.bgc4 { background-color: #ffdf6b;}
.bgc5 { background-color: #96bb7c;}
.bgc6 { background-color: #ff5200;

}

</style>
