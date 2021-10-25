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
    <a
      href="https://accounts.google.com/o/oauth2/v2/auth?&response_type=token&login_hint
=AJDLj6JUa8yxXrhHdWRHIV0S13cAv4jm67m2ihty1sMzCLHV_mQrufkn5QDktg8ymG6a0cZzSfbxm02cAf2XY9lSHhOMkt7STw&client_id=71530109499-6re6j434sr87q4t8u1s1ou4n8blv6t1q.apps.googleusercontent.com&origin=http://localhost:9527&scope=openid profile email&ss_domain=http://localhost:9527&include_granted_scopes=true&redirect_uri=http://localhost/users/social"
    >로그인</a>
  </div>
</template>
<script>
import googleLogin from 'vue-google-login'
import { socialLogin } from '@/api/social/user'
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

      // This only gets the user information: id, name, imageUrl and email
      console.log(googleUser.getBasicProfile())
      console.log(googleUser.getBasicProfile().uT)
      socialLogin(googleUser.ya).then(res => {
        console.log(res)
      })
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
