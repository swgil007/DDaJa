<template>
    <div class="main-category-div">
      <div class="category-div">
        <div><router-link to="/big-data-gisa/index"><img v-bind:src="grayMan" class="mans-img" ></router-link></div>
        <div><router-link to="/"><img v-bind:src="blueMan" class="mans-img" ></router-link></div>
        <div><router-link to="/network-admin-one/index">네1<img v-bind:src="blueMan" class="mans-img" ></router-link></div>
        <div><router-link to="/network-admin-two/index">네2<img v-bind:src="blueMan" class="mans-img" ></router-link></div>
      </div>
      <div class="category-div">
        <div><router-link to="/jeongbo-cheoli-gisa/index"><img v-bind:src="redMan" class="mans-img" ></router-link></div>
        <div><router-link to="/jeongbo-cheoli-sanup-gisa/index">산업기사<img v-bind:src="purpleMan" class="mans-img" ></router-link></div>
        <div><router-link to="/computer-utilize-one/index"><img v-bind:src="purpleMan" class="mans-img" ></router-link></div>
 <div><router-link to="/computer-utilize-two/index"><img v-bind:src="purpleMan" class="mans-img" ></router-link></div>
      </div> 
    </div>
</template>


<script>

import redMan from '@/assets/character/red_man.png'
import blueMan from '@/assets/character/blue_man.png'
import purpleMan from '@/assets/character/purple_man.png'
import grayMan from '@/assets/character/gray_man.png'

export default {
  data() {
    return {
      redMan: redMan,
      blueMan : blueMan,
      purpleMan : purpleMan,
      grayMan :grayMan
    };
  },
  components :{
    
  }
};
</script>

<style lang="scss" scoped> 

* {
  background-color: rgb(11, 8, 49);
}

.main-category-div {   
  
  .category-div {  
    padding-right: 5.8%; 
    padding-left: 5.8%;

    max-width: 100%;
    float: left; 
    height: 100%;  
     
    div { 
      width: 25%;
      height: 25%;
      float: left;
    }
  }
}
 

.mans-img{
  width: 420px;
  height: 420px;

}
</style>