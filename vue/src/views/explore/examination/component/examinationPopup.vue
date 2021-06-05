<template>
    <div>
        <el-dialog 
        :visible.sync="popupVal" 
        title=""
        :before-close="handleClose"> 
        <div class="score-div">
            <div class="score-div1">
                <span>2020년 10월 11일 3회차 모의고사</span>
            </div> 
        </div> 
        <div v-for="(quiz) in testJson" :key="quiz.examinationNo" >
            <div class="quiz-box">
                <div class="quiz">
                    <span> {{quiz.examinationNo}}. {{quiz.examinationQuestion}}  </span>  
                </div> 
                <div class="answer" v-for="(answer, index) in quiz.example" :key="answer">
                    <span> <el-checkbox v-model="answerTest" >{{index+1}} . {{answer}}</el-checkbox> </span> 
                </div>  
            </div>
        </div>
        <span slot="footer" class="dialog-footer"> 
            <el-button type="primary" @click="popupClose(false)">채 점</el-button> 
        </span>
        </el-dialog>
        <community
        :popup-val="communityPopupVal"
        @close:community="communityPopupStatus"
        />
    </div> 
</template>

<script>
import testJson from '@/assets/jsonFile/subjectExaminationTestJson1'
import community from '@/views/explore/communication'

export default {
    name: 'examinationPopup'
    , data() {
        return { 
            testJson : testJson
            , communityPopupVal : false
            , quizType : 1
            , answerTest: false
        }
    }
    , components : {
        testJson
        , community
    }
    , props: {
        popupVal: {} 
    }
    , watch: { }
    ,methods: { 
        popupClose(val) { 
            // 시험 popup 닫는다.
            this.$emit('close:examination', val) 
        }
        , handleClose(done) {
            // 클릭 이벤트가 popup 벗어나면 확인창.
        this.$confirm('정말 끝내시겠습니까 ? 😡')
            .then(_ => {  
                this.popupClose(false);
            })
            .catch(_ => {});
        } 
        , communityPopupStatus(val){
            if(val){
                // 토론창 열기 
                this.communityPopupVal = val
            }else{
                // 토론창 닫기
                this.communityPopupVal = val
            }
        }
    }
}
</script>
<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap'); 
.score-div{
    width: 100%;
    height: 30px; 
    .score-div1{ 
        width: 100%;
        float: left;
        span{
            float: left;
            font-size: 40px;
            font-family: 'Do Hyeon', sans-serif;
            color: black;
            padding: 0 0 0 5%;
        }
    }
    .score-div2{ 
        width: 100%;
        float: left;
        padding: 3% 0 0 5%;
        span{
            float: left;
            font-size: 30px;
            font-family: 'Do Hyeon', sans-serif;
            color: black;
            
        }
        .progress{
            width: 90%;
        }
    }
}
.quiz-box{  
    width: 93%;
    padding: 2%;
    height: inherit; 
    float: left;
    margin: 3% 3% 3% 3%;
    .quiz{ 
        float: left;
        width: inherit;
        padding: 2%;
        font-size: 15px;
        font-weight: bold;
        span{
            float: left;
        }
        .user-answer{
            color: blue;
            padding: 0 0 0 2%;
        }
    }
    .answer{ 
        float: left;
        width: inherit;
        padding: 2%;
        font-size: 13px;
        font-weight: bold;
        span{
            padding-left: 5%;
            float: left;
        }
        .answer-font{
            color: red;
        }
    }
    .quiz-communication{
        float: left;
        width: 100%; 
        .quiz-communication-button{
            float: right;
        }
    }
}
.quiz-type-div{
    margin: 10px 0 0 0;
    padding: 1% 0 0 5%;
    float: left;
}
</style>