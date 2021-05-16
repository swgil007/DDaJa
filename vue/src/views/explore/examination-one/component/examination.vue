<template>
    <div>
        <el-dialog
        title="한문제씩 풀기"
        :visible.sync="popupVal"
        width="30%"
        :before-close="handleClose">
        <span>{{subjectExamination}}</span>
        <span slot="footer" class="dialog-footer">
            <el-button @click="popupClose()">닫 기</el-button>
            <el-button type="primary" @click="popupClose()">Confirm</el-button>
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
        };
    },
    props: {
        popupVal: {}
        , subjectExamination : {}
    }
    , methods: {
        popupClose() { 

            this.$emit('close:examination', false) 
        }
        , handleClose(done) {
        this.$confirm('정말 끝내시겠습니까 ?')
            .then(_ => { 
                this.popupClose();
            })
            .catch(_ => {});
        } 
    }
    };
</script>