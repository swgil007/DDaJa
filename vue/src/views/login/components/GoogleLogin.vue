<template>
  <div>
    <!-- <div @click="googleLogin">구글 로그인</div> -->
    <googleLogin
      :params="params"
      :on-success="onSuccess"
      :render-params="renderParams"
    >
      Login
    </googleLogin>
  </div>
</template>
<script>
import googleLogin from 'vue-google-login'
export default {
  components: {
    googleLogin
  },
  data() {
    return {
      AUTHORIZE_URI: 'https://accounts.google.com/o/oauth2/v2/auth',
      REDIRECT_URI: 'http://localhost:9527/social/login',
      RESPONSE_TYPE: 'token',
      SCOPE: 'https://www.googleapis.com/auth/contacts.readonly',
      params: {
        client_id: this.$googleClientID
      },
      renderParams: {
        width: 250,
        height: 50,
        longtitle: true
      }
    }
  },
  methods: {
    onSuccess(googleUser) {
      console.log(googleUser)

      console.log(googleUser.ya)
      // This only gets the user information: id, name, imageUrl and email
      console.log(googleUser.getBasicProfile())
    },
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
