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
            <span> <i class="el-icon-edit"></i> 의견을 함께해주세요</span>
        </div>
        <div class="communication-reply">
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
    </el-drawer>
</div>
</template>

<script>
export default {
    name: 'community'
    , data() {
        return { 
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
    .communication-reply{
        width: 93%; 
        height: inherit; 
        padding: 2% 0 2% 0;
        float: left;
        margin: 0% 3% 3% 3%;
        border: 1px solid rgb(226, 226, 226); 
        textarea{
            width: inherit;
            outline: none;
            border: 1px solid rgb(179, 29, 29);  
        }
    }
} 


</style>
