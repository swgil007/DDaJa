<template>
  <div class="examination-popup">
    <el-dialog
      title=""
      width="60%"
      :visible.sync="popupVal"
      :before-close="handleClose"
    >
      <el-card
        class="card1"
        title=""
        width="60%"
        :visible.sync="popupVal"
        :before-close="handleClose"
      >
        <div slot="header" class="div1">
          <el-button
            v-if="questionIndex != 0"
            style="float: left; padding: 3px 0"
            type="text"
            @click="setWordQuestion(-1)"
          > ← Ago </el-button>

          <span class="span1"> {{ wordTitle }} </span>

          <el-button
            v-if="questionListSize != questionIndex"
            style="float: right; padding: 3px 0"
            type="text"
            @click="setWordQuestion(1)"
          > Next → </el-button>
        </div>
        <div class="div2">
          <span class="span1">
            {{ question.content }}
          </span>
        </div>
        <div class="div3">
          <div class="div3-1">
            <span>정답</span>
          </div>
          <div v-if="testCheck" class="div3-2">
            <el-input
              v-model="input"
              placeholder="Please input"
              class="input1"
            />
          </div>
          <div v-else class="div3-3">
            <!-- 정답 -->
            <span v-if="testAnswerCheck" class="span1">DATA BASE</span>
            <!-- 오답 -->
            <span v-else class="span1 span2">DATA BASE</span>
          </div>
        </div>
        <div class="dialog-footer">
          <div
            v-if="testCheck"
            class="btn1"
          >
            <el-button
              type="primary"
              @click="testCheck = false"
            >확 인
            </el-button>
          </div>
        </div>
      </el-card>
    </el-dialog>
  </div>
</template>

<script>

import community from '@/views/explore/communication'
import { fetchWordQuestion } from '@/ddaja-api/explore/examination-word/ExaminationWord'

export default {
  name: 'ExaminationPopup',

  components: {
    community
  },

  props: {
    popupVal: {},
    wordID: {}
  },

  data() {
    return {
      input: '',
      testCheck: true,
      testAnswerCheck: false,
      wordQuestionInfo: {},
      wordTitle: '',
      questionList: [],
      questionListSize: 0,
      questionIndex: 0,
      questionSeqList: [],
      question: {
        id: 0,
        lid: 0,
        answer: '',
        content: '',
        createDate: '',
        modifieDate: ''
      }
    }
  },

  watch: {
    popupVal(val) {
      if (val) {
        this.fetchWordQuestion()
      } else {
        this.wordQuestionInfo = {}
      }
    }
  },

  methods: {
    popupClose() {
      this.question = { id: 0,
        lid: 0,
        answer: '',
        content: '',
        createDate: '',
        modifieDate: ''
      }
      this.wordTitle = ''
      this.$emit('close:examination', false)
    },

    setWordQuestion(index) {
      var questionIndex = this.questionIndex + index
      this.questionIndex = questionIndex
      this.question = this.questionList[questionIndex]
    },

    fetchWordQuestion() {
      fetchWordQuestion(this.wordID).then(response => {
        var questionList = []

        response.items.forEach(x => {
          questionList.push(x.item)
        })

        if (questionList.length === 0) {
          alert('Zero Question')
          this.popupClose()
          return
        }

        this.questionIndex = 0
        this.questionListSize = questionList.length - 1
        this.questionList = questionList
        this.wordTitle = response.items[0].item.wordDTO.title
        this.setWordQuestion(0)
      })
    },

    handleClose() {
      this.$confirm('END ?').then(_ => {
        this.popupClose()
      }).catch(_ => {})
    }
  }
}
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
