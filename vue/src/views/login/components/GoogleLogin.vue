<template>
  <div>
    <div @click="googleLogin">구글 로그인</div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      AUTHORIZE_URI: 'https://accounts.google.com/o/oauth2/v2/auth',
      REDIRECT_URI: 'localhost:9527/social/login',
      RESPONSE_TYPE: 'token',
      SCOPE: 'https://www.googleapis.com/auth/contacts.readonly'
    }
  },
  methods: {
    googleLogin() {
      // const queryStr = qs.stringify({
      //   client_id: CLIENT_ID,
      //   redirect_uri: window.location.href,
      //   response_type: "token",
      //   scope: "https://www.googleapis.com/auth/contacts.readonly",
    //   // });
    //   const REQUEST_URI = this.AUTHORIZE_URI + "?" + "client_id=" + this.$googleClientID
    //   console.log(REQUEST_URI)
    //   this.$http.get(REQUEST_URI)
    //   .then(res => {
    //       console.log(res)
    //   })
    //   .catch(err => {
    //       console.log(err)
    //   })
      window.open('https://accounts.google.com/o/oauth2/v2/auth', 'window_name', 'width=430,height=500,location=no,status=no,scrollbars=yes')
    }
  }
}
</script>
