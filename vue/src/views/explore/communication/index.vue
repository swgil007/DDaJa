<template>
<div class="main-container">
    <el-drawer title="I am the title"
            :visible.sync="popupVal"
            :with-header="false"
            :before-close="handleClose">
        <div class="communication-title">
            <span>토론</span>
        </div>
        <div class="communication-quiz">
            <div class="quiz"><span>1. SQL 쿼리에서 DATA 를 가지고 올 때 사용하는 명령문은 ?</span></div>
            <div class="answer"><span>1. SELECT</span></div>
            <div class="answer"><span>2. SELECT</span></div>
            <div class="answer"><span>3. SELECT</span></div>
            <div class="answer"><span>4. SELECT</span></div>
        </div>
        <div class="communication-reply-title">
            <span> 의견을 함께해주세요 <i class="el-icon-edit"></i> </span> 
        </div> 
        <div class="communication-reply-insert">
            <el-input
            type="textarea"
            :autosize="{ minRows: 3, maxRows: 3}"
            placeholder="Please input"
            v-model="reply">
            </el-input>
            <el-button class="save-btn">저장</el-button>
        </div>
        <div class="communication-replys">
            <!-- forEach 돌리세요.-->
            <div v-for="item in items" :key="item.key" class="reply-box"> 
                <div class="reply-box1">
                    <div class="img-div">
                        <i class="el-icon-s-custom"></i>
                    </div>
                    <div><span>{{item.name}} ( {{item.date}} )</span></div>
                    <div>
                        <span style="float:left; padding-left:10px;" class="pointer"> 👍 200 </span>
                        <span style="float:right; padding-right:10px;" class="pointer">👎 100 </span>
                    </div>
                    <div></div>
                </div>
                <div class="reply-box2"> 
                    <div class="reply"><span>저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~~~ 이기 때문이죠. 안그렇습니까 ? 제 생각에는 그렇다고 셍각합니다. SELECT 나 DELETE 나 UPDATE 나 내가 오또케 알아요</span></div>
                    <div class="reply-delete-btn pointer"><i class="el-icon-delete"></i></div>
                </div>
            </div>
        <!-- forEach 돌리세요.--> 
        </div>
    </el-drawer>
</div>
</template>

<script>
export default {
    name: 'community'
    , data() {
        return { 
            reply : ""
            ,    items: [
                    { 
                    name: 'Binsoo'
                    , date: '20200102' 
                    }
                    ,{
                    name: 'Yubin'
                    , date: '20200213' 
                    }
                    ,{
                    name: 'Enji'
                    , date: '20200521' 
                    }
                    ,{
                    name: 'Boeun'
                    , date: '20200631' 
                    }
                ]
        }
    }
    , props: {
        popupVal: false
    }
    ,methods: {
        popupClose() {  
            this.$emit('close:community', false) 
        }
        , handleClose(){
            this.popupClose()
        }
    }
}
</script>

<style lang="scss" scoped>

@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');
.main-container{
    width: 100%; 
    .communication-title{
        float: left;
        margin: 3% 3% 0px 3%;
        border: 3px solid rgb(175, 175, 175);
        border-radius: 40px 80px / 80px 40px;
        background-color: rgb(236, 231, 231);
        width: 93%;
        height: 70px; 
        padding-top: 8px;
        span{
            font-size: 30px; 
            padding: 15px; 
            font-size: 50px;
            font-family: "Kirang Haerang", cursive;
        }
    }
    .communication-quiz{  
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
        }
    }
    .communication-reply-title{
        width: 93%;
        padding: 2%;
        height: inherit; 
        float: left;
        margin: 3% 3% 0% 3%; 
        border: 1px solid rgb(226, 226, 226); 
        span{
            font-weight: bold;
            font-size: 15px;
        }
    }
    .communication-reply-insert{
        width: 93%; 
        height: inherit; 
        padding: 2% 2% 2% 2%;
        float: left;
        margin: 0% 3% 3% 3%;
        border: 1px solid rgb(226, 226, 226); 
        textarea{ 
            width: inherit;
            outline: none; 
            height: 50px;
            border: 1px solid rgb(179, 29, 29);  
        }
        .save-btn{
            margin:12px 0 0 0; 
            float:right;
        }
    }
    .communication-replys{
        width: 93%; 
        height:400px;
        padding: 3% 3% 3% 3%;
        float: left;
        margin: 0% 0 3% 3%;
        overflow:scroll;
        .reply-box{
            margin : 0 0 3px 0;
            border: 1px solid rgb(226, 226, 226);
            overflow:hidden;
            height:auto;
            float: left;
            .reply-box1{ 
                width: 28%;
                float: left;
                div{
                    width: 100%; 
                    float: left;
                    padding: 5% 0 0 5%; 
                }
                .img-div{
                    height: 100px;
                    width: 135px;
                    padding: 0 15px 0 15px;
                    border: 1px solid rgb(162, 199, 255);
                }
                span{
                    float: left;
                    font-size: 13px;
                    font-weight: bold;
                }
            }
            .reply-box2{ 
                width: 70%;
                float: left;
                padding: 3%;
                span {
                    float: left;
                    font-size: 14px;
                    font-weight: bold;
                }
                .reply-delete-btn{
                    padding: 7% 0 0 0;
                    float: right; 
                }
            }
        }
    }
    .pointer{
        cursor:pointer;
    }
}  
</style>
