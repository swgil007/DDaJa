<template>
    <div class="main-container">
        <div class="main-title"><h1>내트워크 2급 전용 페이지 </h1></div>
        <div class="main-board">
            <div class="board-box">
                <div class="box"><router-link to="/network-admin-two/examination-one">한문제씩 탐험해보기</router-link></div>
                <div class="box"><router-link to="/network-admin-two/examination-word">단어 암기</router-link></div>
                <div class="box"><router-link to="/network-admin-two/examination">모의 고사</router-link></div>
            </div>
            <div class="board-box">
                <div class="box"><router-link to="/network-admin-two/acceptance-review">합격 후기</router-link></div>
                <div class="box"><router-link to="/network-admin-two/license-information">자격증 정보</router-link></div>
                <div class="box"><router-link to="/network-admin-two/examination-again">틀린문제 재 탐험</router-link></div>
            </div>
            <div class="board-box">
                <div class="box"><router-link to="/network-admin-two/score-status">내 점수</router-link></div>
                <div class="box"><router-link to="/network-admin-two/communication">같이 탐사 할래요</router-link></div>
                <div class="box"><router-link to="/">Main</router-link></div>
            </div>
        </div>
    </div>


</template>

<script>
export default {

}
</script>

<style>

.main-container{
    width: 100%;
}
.main-title{
    border: 1px solid red;
}
.main-board{
    border: 1px solid brown;
    margin-left: 8%;
    margin-right: 8%;
}
.board-box{
    border: 1px solid green;
    width: 100%;
    float: left;
    
}
.box {
    border: 1px solid yellow;
    width: 33%;
    height: 200px;
    float: left;
    padding-left: 5%;
    padding-top: 5%;
}
</style>