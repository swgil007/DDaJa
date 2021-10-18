<template>
  <div>
    <div @click="googleLogin">구글 로그인</div>
    <div
      id="g_id_onload"
      data-client_id="71530109499-6re6j434sr87q4t8u1s1ou4n8blv6t1q.apps.googleusercontent.com"
      data-login_uri="http://localhost:9527/social/login"
      data-auto_prompt="false"
    />
    <div
      class="g_id_signin"
      data-type="standard"
      data-size="large"
      data-theme="outline"
      data-text="sign_in_with"
      data-shape="rectangular"
      data-logo_alignment="left"
    />
  </div>
</template>
<script src="https://accounts.google.com/gsi/client" async defer></script>
<script>
export default {
  data() {
    return {
      AUTHORIZE_URI: 'https://accounts.google.com/o/oauth2/v2/auth',
      REDIRECT_URI: 'http://localhost:9527/social/login',
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
    //   console.log(REQUEST_URI)
    //   this.$http.get(REQUEST_URI)
    //   .then(res => {
      //       console.log(res)
    //   })
    //   .catch(err => {
      //       console.log(err)
    //   })
      const REQUEST_URI = this.AUTHORIZE_URI + '?' + 'client_id=' + this.$googleClientID + '&redirect_uri=' + this.REDIRECT_URI + '&response_type=' + this.RESPONSE_TYPE + '&scope=' + this.SCOPE
      window.open(REQUEST_URI, 'Google Login', 'width=430,height=500,location=no,status=no,scrollbars=yes')
    }
  }
}
</script>
