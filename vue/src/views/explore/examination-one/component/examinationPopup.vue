<template>
    <div>
        <el-dialog
        title=""
        :visible.sync="popupVal"
        width="60%"
        :before-close="handleClose">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <el-button style="float: left; padding: 3px 0" type="text" @click="examinationNumber = examinationNumber-1"> ← Ago </el-button>
                    <span>{{examinationQuestion}}</span>
                    <el-button style="float: right; padding: 3px 0" type="text" @click="examinationNumber = examinationNumber+1"> Next → </el-button>
                </div>
                <div v-for="( exam, index ) in example" :key="exam.examinationNo" class="text item">
                    <span>{{index+1}} . {{exam}}</span>
                </div>
                </el-card>
        
        <span slot="footer" class="dialog-footer"> 
            <el-button type="primary" @click="community()">토 론</el-button>
            <el-button type="primary" @click="grading()">채 점</el-button>
        </span>
        </el-dialog>
    </div>

</template>

<script>
// Object.keys(subjectExamination).length
export default {
    name: 'examinationPopup',
    data() {
        return {
            examination : undefined,
            examinationQuestion : undefined,
            example : undefined,
            examinationNumber : 0
        }
    },
    props: {
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
            this.$emit('close:examination', false) 
        }
        , handleClose(done) {
        this.$confirm('정말 끝내시겠습니까 ? 😡')
            .then(_ => {  
                this.popupClose();
            })
            .catch(_ => {});
        } 
        , examinationChoose(){
            this.subjectExamination.forEach(element => { 
                if(element.examinationNo === this.examinationNumber ){
                    this.examination = element
                    this.examinationQuestion= element.examinationQuestion
                    this.example = element.example
                }
            }); 
        }
        , community(){
            alert("커뮤니티 UI 개발 중입니다. 🤭🤪😵");
        }
        , grading(){
            alert("채점 UI 개발 중입니다. 🤭🤪😵");
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
        padding: 20px;
        font-weight: bold;
        float: left;
    }
}
.clearfix{
    span {
        font-size: 22px;
        font-weight: bold;
    }
}
</style>