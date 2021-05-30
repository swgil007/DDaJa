<template>
<div class="main-container">
    <div class="main-title"><font class="title-font1">한문제씩 풀기</font><font font class="title-font2"> - {{ licenseInfo.licenseName }}</font></div>
    <div class="search-box">  
        <div class="select-box">
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
        <div class="choice-box">
            <el-switch
            class="switch" 
            v-model="choiceValue"
            active-color="#13ce66"
            inactive-color="#ff4949" 
            active-text="필기"
            inactive-text="실기">
            </el-switch>
        </div>
    </div>
    <div  class="subject-content-box"> 
        <div v-for="vo in subject" :key="vo.subjectid" class="subject-content">
            <div class="subject-box"
                :class="colorSelect(vo.subjectid)" 
                @click="examinationPopupStatus(true)"
            >
                <span class="subject-name-style">
                    <div class="name-div">{{vo.subjectName}} </div> 
                </span>
            </div>
            <div class="chart-box1">
                <div class="chart-box2"> 
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
    </div>
    <examinationPopup
    :popup-val="examinationPopupVal"
    :subjectExamination="subjectExamination"
    @close:examination="examinationPopupStatus"
    @open:grading="gradingPopupStatus"
    />
    <gradingPopup
    :popup-val="gradingPopupVal"
    @close:grading="gradingPopupStatus"
    />
</div>
</template>

<script>
import examinationPopup from './component/examinationPopup'
import gradingPopup from './component/gradingPopup'
import testJson from '../../../assets/jsonFile/subjectExaminationTestJson1'

export default {
    name: ''
    , components: {
        testJson
        , examinationPopup
        , gradingPopup
    }
    , data() {
        return {
            attachRed: false
            , examinationPopupVal : false
            , gradingPopupVal : false
            , choiceValue: false
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
        examinationPopupStatus (val){
            if(val){
                // 문제 풀이 창 연다
                this.examinationPopupVal = val
            }else{
                // 문제 풀이 창 닫는다
                this.examinationPopupVal = val
            }
        }
        ,gradingPopupStatus(val){
            if(val){
                // 채점 popup 을 연다
                this.examinationPopupStatus(false)
                this.gradingPopupVal = val 
            }else{
                 // 채점 popup 을 닫는다
                this.gradingPopupVal = val
            }
        }
        , colorSelect: function ( colorKey ) {
            return colorKey%7 === 1 ? 'bgc1' : 
                colorKey%7 === 2 ? 'bgc2' : 
                colorKey%7 === 3 ? 'bgc3' : 
                colorKey%7 === 4 ? 'bgc4' : 
                colorKey%7 === 5 ? 'bgc5' : 
                colorKey%7 === 6 ? 'bgc6' :
                colorKey%7 === 7 ? 'bgc7' : 'bgc1'
        }
    }
}
</script>

<style lang="scss" scoped> 
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap'); 
.main-container{
    width: 100%;
    text-align: center; 
    padding: 30px;
    overflow:auto;
    background-color: rgb(255, 255, 255);
    .main-title{
        text-align: left;  
        margin-top: 5px;
        margin-bottom: 30px; 
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1.5% 2% 1.5% 4%;
        .title-font1{
            font-size: 50px;   
            font-family: 'Do Hyeon', sans-serif;
        }
        .title-font2{
            font-size: 40px;
            padding: 0 0 0 30px; 
            font-family: 'Do Hyeon', sans-serif;
        }
    }
    
.search-box{
    width: 90%; 
    height: 80px;
    margin: 0 5% 0 5%;
    .select-box{  
        float: left;
        padding: 0 0 0 0; 
        width: 75%;
            .exam-select-box{
                float: left;
                width: 1000px;
            }
    }
    .choice-box{  
        float: right;
        padding: 1% 0 0 10%; 
        width: 25%;
        .switch{
            display: block; 
        }
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
            .subject-name-style{ 
                color: aliceblue;
                font-size: 50px;   
                font-family: 'Do Hyeon', sans-serif;
                .name-div{
                    padding-top: 20%; 
                    float: left;
                    width: 100%;
                    height: 100%; 
                }
            }
        }
        .chart-box1{
            width: 38%;
            height: 350px; 
            margin-top: 20px;
            margin-left: 2%; 
            float: left;
            border: 20px solid rgb(255, 255, 170);
            .chart-box2 {
                padding-top: 1%;
                border: 2px solid rgb(255, 255, 44);
                width: 100%;
                height: 100%;
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
                            color: rgb(0, 0, 0); 
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
}
.bgc1 { background-color: #ffd19d;}
.bgc2 { background-color: #dd9aff;}
.bgc3 { background-color: #fface0;}
.bgc4 { background-color: #ffdf6b;}
.bgc5 { background-color: #96bb7c;}
.bgc6 { background-color: #ff5200; }
</style>
