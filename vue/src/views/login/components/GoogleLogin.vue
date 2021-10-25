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
      const socialAccessToken = {
        accessToken: googleUser.Zb.access_token,
        tokenType: 'GOOGLE'
      }
      socialLogin(socialAccessToken).then(res => {
        console.log(res)
      })
    }
  }
}
</script>
