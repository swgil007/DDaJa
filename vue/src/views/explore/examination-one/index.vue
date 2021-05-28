<template>
<div class="main-container">
<div class="main-title"><font class="title-font">{{ licenseInfo.licenseName }} - 한문제씩 풀기 🌠</font></div>
<div class="selectbox-box"> 
<el-select v-model="examYearCountTitle" placeholder="Select" class="exam-select-box" size="lazy">
    <el-option
        v-for="item in examYearCount"
        :key="item.examKey"
        :count="item.count"
        :value="item.year">
        <span style="float: left; font-size: 15px; padding:5px">{{ item.year }}</span>
        <span style="float: right; color: #8492a6; font-size: 15px; padding:5px">{{ item.count }}</span>
    </el-option>
</el-select>    
</div>
<div  class="subject-content-box"> 
    <div v-for="vo in subject" :key="vo.subjectid" class="subject-content">
        <div class="subject-box"
            :class="colorSelect(vo.subjectid)" 
            @click="examinationOpen(vo.subjectid)"
        >
            <span class="subject-name-style">
                <div class="name-div">{{vo.subjectName}} </div> 
            </span>
        </div>
        <div class="chart-box">
            <div class="chart-row-box">
                <div class="chart-font-div"><span>전체 진도율 </span></div>
                <div class="chart-bar-div"><el-progress :text-inside="true" :stroke-width="26" :percentage="80"  class="chart"></el-progress></div>
            </div>
            <div class="chart-row-box"> 
                <div class="chart-font-div"><span>정답 문제 현황 </span></div>
                <div class="chart-bar-div"><el-progress :text-inside="true" :stroke-width="26" :percentage="30"  class="chart" status="success"></el-progress></div>
            </div> 
            <div class="chart-row-box"> 
                <div class="chart-font-div"><span>틀린 문제 현황</span></div>
                <div class="chart-bar-div"><el-progress :text-inside="true" :stroke-width="26" :percentage="40"  class="chart" status="exception"></el-progress></div>
            </div> 
        </div>
    </div>
</div>
<examinationPopup
:popup-val="popupVal"
:subjectExamination="subjectExamination"
@close:examination="examinationClose"
/>
</div>
</template>


<script>
import examinationPopup from './component/examinationPopup'
import testJson from '../../../assets/jsonFile/subjectExaminationTestJson1'

export default {
name: ''
, components: {
    testJson
    ,examinationPopup
}
, data() {
return {
    attachRed: false
    , popupVal : false
    , licenseInfo: []
    , subject:[]
    , subjectExamination: testJson
    , examYearCount: [
        {
        examKey : 1
        , year: '2015 년 모의고사' 
        , count: '1회차'
        }, 
        {
        examKey : 2   
        , year: '2016 년 모의고사' 
        , count: '2회차'
        }, 
        {
        examKey : 3
        , year: '2016 년 모의고사' 
        , count: '3회차'
        }, 
        {
        examKey : 4
        , year: '2017 년 모의고사' 
        ,  count: '4회차'
        }, 
        {
        examKey : 5
        , year: '2018 년 모의고사' 
        , count: '5회차'
        }, 
        {
        examKey : 6
        , year: '2019 년 모의고사' 
        , count: '6회차'
        }
    ] 
    , examYearCountTitle: '응시 회차수를 선택해주세요.' 
    }
}
, created() {
    this.licenseInfo = this.$session.get('licenseInfo') 
    this.subject = this.licenseInfo.subject
}
, methods: {
    colorSelect: function ( colorKey ) {
        return colorKey%7 === 1 ? 'bgc1' : 
               colorKey%7 === 2 ? 'bgc2' : 
               colorKey%7 === 3 ? 'bgc3' : 
               colorKey%7 === 4 ? 'bgc4' : 
               colorKey%7 === 5 ? 'bgc5' : 
               colorKey%7 === 6 ? 'bgc6' :
               colorKey%7 === 7 ? 'bgc7' : 'bgc1'
    }
    , examinationOpen(subjectid) { 
        // subjectid 로 해당 과목 문제 가지고 와서 
        // subjectExamination 에 담아
        // examinationPopup 에 보내주기.
        this.popupVal = true
    }
    , examinationClose(value) { 
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
    .selectbox-box{ 
        margin-top: 5px;
        margin-bottom: 5px; 
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1% 1% 1% 1%;
        .exam-select-box{
            width: 1000px;
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
            margin-left: 5%;
            margin-right: 10%; 
            float: left;
            cursor: pointer;
            border: 20px solid rgb(250, 250, 238);  
            .subject-name-style{ 
                color: aliceblue;
                font-size: 40px;  
                font-family: 'Kirang Haerang', cursive;
                .name-div{
                    padding-top: 20%; 
                    float: left;
                    width: 100%;
                    height: 100%; 
                }
            }
        }
        .chart-box{
            width: 38%;
            height: 350px;
            padding-top: 1%;
            margin-top: 20px;
            margin-left: 2%; 
            float: left;
            border: 20px solid rgb(255, 255, 194);
            color: aliceblue; 
            .chart-row-box{
                height: 100px; 
                width: 100%;
                float: left; 
                .chart-font-div{ 
                    float: left;
                    width: 100%;  
                    height: 30px;
                    span {
                        font-weight: bold;
                        padding-left: 3%;
                        float:left;
                    }
                } 
                .chart-bar-div{ 
                    float: left;
                    width: 100%;  
                    height: 30px;
                    .chart{
                        padding-left: 3%;
                        width: 80%;
                    }
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
