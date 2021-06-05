<template>
    <div>
        <el-dialog
        title=""
        :visible.sync="popupVal"
        width="60%"
        :before-close="handleClose">
            <el-card class="box-card" 
            title=""
            :visible.sync="popupVal"
            width="60%"
            :before-close="handleClose">
                <div slot="header" class="clearfix">
                    <el-button style="float: left; padding: 3px 0" type="text" @click="testCheck = true"> ← Ago </el-button>
                    <span> 데이터 베이스 요약 정리 암기하기 </span>
                    <el-button style="float: right; padding: 3px 0" type="text" @click="testCheck = true"> Next → </el-button>
                </div>
                <div class="text item">
                    <span>
                        ◼◼◼ ◼◼◼ 란 일반적으로 컴퓨터 시스템에 전자 방식으로 저장된 
                        구조화된 정보 또는 데이터의 체계적인 집합을 의미합니다. 
                        ◼◼◼ ◼◼◼ 는 보통 ◼◼◼ ◼◼◼ 관리 시스템(DBMS)에 의해 제어됩니다.
                    </span>
                </div>
                <div class="answer-input-box">
                    <div class="answer-title-box">
                        <span>정답</span>
                    </div>
                    <div v-if="testCheck">
                        <el-input placeholder="Please input" v-model="input" class="answer-input"></el-input>
                    </div>
                    <div v-else class="answer-box">
                        <!-- 정답 -->
                        <span v-if="testAnswerCheck">DATA BASE</span>
                        <!-- 오답 -->
                        <span v-else class="red">DATA BASE</span>
                    </div>                    
                </div>                
                <div  class="dialog-footer">
                    <div v-if="testCheck" class="btn1"><el-button type="primary" @click="testCheck = false">확 인</el-button></div>
                </div>
            </el-card> 
        </el-dialog> 
    </div>
</template>

<script> 

import community from '@/views/explore/communication'
export default {
    name: 'examinationPopup'
    , data() {
        return {
            input: ''
            , testCheck : true
            , testAnswerCheck : false
        }
    }
    , components : {
        community
    }
    , props: {
        popupVal: {} 
    }
    , watch: {  
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
    }
};
</script>

<style lang="scss" scoped>
.item{
    float: left;
    width: 100%;
    span {
        font-size: 18px;
        padding-top: 12px;
        font-weight: bold;
        float: left;
        padding: 3% 3% 3% 3%; 
        text-align: left;
        line-height: 2em;
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
    .dialog-footer{
        float: left;
        width: 100%;
        div{ 
            float: right; 
        }
        .btn1{
            padding-left: 2%; 
        }
    }
}
.answer-input-box{ 
    .answer-input{
        padding: 2%; 
    }
    .answer-title-box{
        float: left; 
        width: 100%;
        span{
            float: left;
            padding: 0 0 0 3%;
            font-size: 18px;
            text-align: left;
            font-weight: bold;
        }
    }
    .answer-box{
        float: left; 
        width: 100%;
        span{
            float: left;
            padding: 2% 0 2% 3%;
            font-size: 18px;
            text-align: left;
            font-weight: bold; 
        }
        .red{
            color: red;
        }
    }
}
</style>