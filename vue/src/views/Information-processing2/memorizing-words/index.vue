<template>
  <div id="wrap">
    <div class="header"></div>
    <div class="aside"></div>
    <div class="contents"></div>
    <div class="footer"></div>
  </div>
</template>
<script>
</script>
<style lang="scss">
#wrap {
  width: 100%;
  margin: 0 auto;
}
.header {
  width: 100%;
  height: 150px;
  background: #9566cc;
}
.aside {
  float: left;
  width: 30%;
  height: 700px;
  background: #7c5772;
}
.contents {
  float: left;
  width: 70%;
  height: 700px;
  background: #0300ef;
}
.footer {
  clear: both;
  width: 100%;
  height: 150px;
  background: #00ef15;
}
</style>