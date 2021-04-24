<template>
    <div class="successful-status-container">
       <div class="successful-status-title-box"><span>합격자 현황</span></div>
       <div class="successful-status-btn-box">
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
         <div><el-button class="successful-status-btn" type="danger">Danger</el-button></div>
       </div>
       <div>
        <div class="chart-container">
            <chart height="100%" width="100%" />
        </div>
       </div>
     </div>
</template>


<script>
// vue Chart 알아보고 수정할 것 이거 못 써
import Chart from '@/components/Charts/MixChart' 


export default {
  name: 'MixChart',
  components: { Chart }
}
</script>


<style lang="scss" scoped> 

.chart-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  //max-width: 80%;
  float: left;  
  height: calc(100vh - 84px);
}

.successful-status-container{
  max-width: 80%;
  float: left;
  margin-left: 17%; 
  height: 100%;

  width: 63%;
  padding: 3% 0 3% 0;
  border: 3px solid blue;

  .successful-status-btn-box{
    border: 3px solid purple;
    height: 100%;

    div {
      float: left;
      height: 100%; 
      padding: 0.33%;

      .successful-status-btn{
         
        width:  124px;
      }
    }
  }
}
</style>