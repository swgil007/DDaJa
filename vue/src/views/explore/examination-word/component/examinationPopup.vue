<template>
    <div class="examination-popup">
        <el-dialog
        title=""
        :visible.sync="popupVal"
        width="60%"
        :before-close="handleClose">
            <el-card 
                class="card1" 
                title=""
                :visible.sync="popupVal"
                width="60%"
                :before-close="handleClose">
                <div slot="header" class="div1">
                    <el-button style="float: left; padding: 3px 0" type="text" @click="testCheck = true"> ← Ago </el-button>
                    <span class="span1"> 데이터 베이스 요약 정리 암기하기 </span>
                    <el-button style="float: right; padding: 3px 0" type="text" @click="testCheck = true"> Next → </el-button>
                </div>
                <div class="div2">
                    <span class="span1">
                        ◼◼◼ ◼◼◼ 란 일반적으로 컴퓨터 시스템에 전자 방식으로 저장된 
                        구조화된 정보 또는 데이터의 체계적인 집합을 의미합니다. 
                        ◼◼◼ ◼◼◼ 는 보통 ◼◼◼ ◼◼◼ 관리 시스템(DBMS)에 의해 제어됩니다.
                    </span>
                </div>
                <div class="div3">
                    <div class="div3-1">
                        <span>정답</span>
                    </div>
                    <div class="div3-2" v-if="testCheck">
                        <el-input placeholder="Please input" v-model="input" class="input1"></el-input>
                    </div>
                    <div v-else class="div3-3">
                        <!-- 정답 -->
                        <span class="span1" v-if="testAnswerCheck">DATA BASE</span>
                        <!-- 오답 -->
                        <span class="span1 span2" v-else >DATA BASE</span>
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
.examination-popup{
    .card1{
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
    .div1{
        .span1 {
            font-size: 22px;
            font-weight: bold;
        }
    } 
    .div2{
        float: left;
        width: 100%;
        .span1 {
            font-size: 18px;
            padding-top: 12px;
            font-weight: bold;
            float: left;
            padding: 3% 3% 3% 3%; 
            text-align: left;
            line-height: 2em;
        } 
    }
    .div3{  
        .div3-1{
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
        .div3-2{
            .input1{
                padding: 2%; 
            }
        }
        .div3-3{
            float: left; 
            width: 100%;
            .span1, .span2{
                float: left;
                padding: 2% 0 2% 3%;
                font-size: 18px;
                text-align: left;
                font-weight: bold; 
            }
            .span2{
                color: red;
            }
        }
    }    
}
</style>