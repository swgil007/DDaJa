<template>
    <div>
        <el-dialog
        title="2021년 5회차 모의고사"
        :visible.sync="popupVal"
        width="60%"
        :before-close="handleClose">
            <el-card class="box-card" >
                <div slot="header" class="clearfix">
                    <el-button style="float: left; padding: 3px 0" type="text" @click="examinationNumber = examinationNumber-1"> ← Ago </el-button>
                    <span>{{examinationQuestion}}</span>
                    <el-button style="float: right; padding: 3px 0" type="text" @click="examinationNumber = examinationNumber+1"> Next → </el-button>
                </div>
                <div v-for="( exam, index ) in example" :key="exam.examinationNo" class="text item">
                    <el-checkbox v-model="checkedTest" class="check-box" size="medium"></el-checkbox>
                    <span> {{index+1}} .</span>
                    <span> {{exam}}</span>
                </div>
                </el-card>
        
        <span slot="footer" class="dialog-footer"> 
            <el-tooltip placement="top">
                <div slot="content">다른 수험자들의<br/>의견 보러가기</div>
                <el-button type="primary" @click="communityOpen()">토 론</el-button>
            </el-tooltip>
            <el-tooltip placement="top">
                <div slot="content">채점 하러 갈래요 ?</div>
            <el-button type="primary" @click="grading()">채 점</el-button>
            </el-tooltip>
        </span>
        </el-dialog>
        <community
        :popup-val="communityPopupVal"
        @close:community="communityClose"
        />
    </div>
</template>

<script> 

import community from '@/views/explore/communication'
export default {
    name: 'examinationPopup'
    , data() {
        return {
            examination : undefined
            , examinationQuestion : undefined
            , example : undefined
            , examinationNumber : 0
            , communityPopupVal : false
            , checkedTest : false
        }
    }
    , components : {
        community
    }
    , props: {
        popupVal: {}
        , subjectExamination : {}
    }
    , watch: { 
        popupVal: function (val) { 
            this.examination = this.subjectExamination
            this.examinationNumber = 1
        }
        , examinationNumber : function( val ){ 
            this.examinationChoose(val)
        }
    }
    ,methods: {
        popupClose() { 
            // 문제풀이 popup 닫는 친구.
            this.$emit('close:examination', false) 
        }
        , handleClose(done) {
            // 클릭 이벤트가 popup 벗어나면 확인창.
        this.$confirm('정말 끝내시겠습니까 ? 😡')
            .then(_ => {  
                this.popupClose();
            })
            .catch(_ => {});
        } 
        , examinationChoose(){
            // 로딩시 문제 세팅
            this.subjectExamination.forEach(element => { 
                if(element.examinationNo === this.examinationNumber ){
                    this.examination = element
                    this.examinationQuestion= element.examinationQuestion
                    this.example = element.example
                }
            }); 
        }
        , grading(){
            // 채점 결과
            alert("채점 UI 개발 중입니다. 🤭🤪😵");
        }
        , communityOpen(){
            // 토론창 열기 
            this.communityPopupVal = true
        }
        , communityClose(value){
            // 토론창 열기 
            this.communityPopupVal = value
        }
    }
    };
</script>

<style lang="scss" scoped>
.item{
    float: left;
    width: 100%;
    padding-left: 5%; 
    span {
        font-size: 18px;
        padding-top: 12px;
        font-weight: bold;
        float: left;
        padding: 15px; 
    }
    .check-box{
        size: 10px; 
        padding-top: 15px;
        padding-bottom: 10px;
        float: left;
    }
}
.clearfix{
    span {
        font-size: 22px;
        font-weight: bold;
    }
}
.box-card{
    padding-bottom: 20px;
}
</style>