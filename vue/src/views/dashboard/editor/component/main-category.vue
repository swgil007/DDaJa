<template>
  <div class="main-category-div">
    <div class="category-div">
      <div>
        <router-link to="/jeongbo-cheoli-sanup-gisa/index">
          <img
            :src="LOGO_JCSG"
            class="mans-img"
            @mouseenter="LOGO_JCSG = JCSG_H"
            @mouseleave="LOGO_JCSG = JCSG"
          >
        </router-link>
      </div>
      <div>
        <router-link to="/jeongbo-cheoli-gisa/index">
          <img
            :src="LOGO_JCG"
            class="mans-img"
            @mouseenter="LOGO_JCG = JCG_H"
            @mouseleave="LOGO_JCG = JCG"
          >
          >
        </router-link>
      </div>
      <div>
        <router-link to="/computer-utilize-one/index">
          <img
            :src="LOGO_CUO"
            class="mans-img"
            @mouseenter="LOGO_CUO = CUO_H"
            @mouseleave="LOGO_CUO = CUO"
          >
        </router-link>
      </div>
      <div>
        <router-link to="/computer-utilize-two/index">
          <img
            :src="LOGO_CUT"
            class="mans-img"
            @mouseenter="LOGO_CUT = CUT_H"
            @mouseleave="LOGO_CUT = CUT"
          >
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>

import CUO from '@/assets/mascot/computer-utilize-one.png'
import CUT from '@/assets/mascot/computer-utilize-two.png'
import JCG from '@/assets/mascot/jeongbo-cheoli-gisa.png'
import JCSG from '@/assets/mascot/jeongbo-cheoli-sanup-gisa.png'

import CUO_H from '@/assets/mascot/computer-utilize-one-hover.png'
import CUT_H from '@/assets/mascot/computer-utilize-two-hover.png'
import JCG_H from '@/assets/mascot/jeongbo-cheoli-gisa-hover.png'
import JCSG_H from '@/assets/mascot/jeongbo-cheoli-sanup-gisa-hover.png'

export default {
  components: {

  },
  data() {
    return {
      LOGO_CUO: CUO,
      LOGO_CUT: CUT,
      LOGO_JCG: JCG,
      LOGO_JCSG: JCSG,
      CUO_H: CUO_H,
      CUT_H: CUT_H,
      JCG_H: JCG_H,
      JCSG_H: JCSG_H,
      CUO: CUO,
      CUT: CUT,
      JCG: JCG,
      JCSG: JCSG
    }
  }
}
</script>

<style lang="scss" scoped>

* {
  background-color: rgb(11, 8, 49);
}

.main-category-div {
  padding: 300px 0 500px 0;
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
