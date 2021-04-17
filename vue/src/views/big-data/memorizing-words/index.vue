<template>
  <div id="wrap">
     
    <div class="aside">
      <div class="test" v-for="i in 10" :key="i" >
         <div v-if="i > level">
            <el-button type="danger" plain style="width:310px; height:50px;"> LEVEL {{i}} </el-button>
          </div> 
          <div class="state-div" v-if="i == level">
            <el-button type="primary" icon="el-icon-lightning" style="width:70px; height:90px"></el-button>
            <el-button type="success" icon="el-icon-heavy-rain" style="width:70px; height:90px"></el-button>
            <el-button type="warning" icon="el-icon-sunrise-1"  style="width:70px; height:90px"></el-button>
            <el-button type="danger"  icon="el-icon-sunny"  style="width:70px; height:90px"></el-button>
          </div> 
         <div v-if="i < level">
            <el-button type="primary" plain style="width:310px; height:50px"> LEVEL {{i}} </el-button>
          </div> 
      </div>
    </div>
    <div class="contents">
        <div class="graff-div">
           <div>
              <h1> 8 번 도전하셨습니다 </h1>
           </div>
           <div> 단어 학습 <el-progress :text-inside="true" :stroke-width="26" :percentage="quize0_percentage" :color="graffColor.Color1"  style="width:800px;" ></el-progress></div>
           <div> 객관식 <el-progress :text-inside="true" :stroke-width="26" :percentage="quize1_percentage" :color="graffColor.Color2" style="width:800px;"></el-progress></div>
           <div> 주관식<el-progress :text-inside="true" :stroke-width="26" :percentage="quize2_percentage"  :color="graffColor.Color3" style="width:800px;"></el-progress></div>
           <div> 틀린문제 다시풀기 <el-progress :text-inside="true" :stroke-width="26" :percentage="quize3_percentage"  :color="graffColor.Color4" style="width:800px;"></el-progress></div>
        </div>
        <div></div>
    </div>
  </div>
</template>

 <script>
export default {
  data() {
    return {
       level : 6,
       quize0_percentage : 100,
       quize1_percentage : 50,
       quize2_percentage : 60,
       quize3_percentage : 80,

        
       graffColor: {
           Color1 :'#409eff',
           Color2 :'#42d885',
           Color3 :'#ffc833',
           Color4 :'#ff6d6d'
       },
       
    };
  },
};
</script>
<style lang="scss">
#wrap {
  width: 100%;
  margin: 0 auto;
}
 
.aside {
  float: left;
  width: 30%;
  height: 100%;
  background: #f3ffdd;
   margin-top: 1%;
  padding-top: 2%;
  padding-left: 5%;
}
.contents {
  float: left;
  width: 68%;
  height: 720px;
  background: #fcfcfc;
  border: 3px solid rgb(207, 207, 207);
  margin: 1%;
  margin-top: 1%;
  padding: 2%;
}
 
.test {
  margin: 20px;

}
.state-div{
    height: 90px;
}
 
.graff-div div{

     padding: 6px;
}
</style>
