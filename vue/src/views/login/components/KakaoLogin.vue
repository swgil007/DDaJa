<template>
  <div>
    <img id="kakao-login-btn" src="@/images/social/kakao_login.png" @click="kakaoLogin">
  </div>
</template>

<script>
import { socialLogin } from '@/api/social/user'
export default {
  methods: {
    kakaoLogin() {
      this.$kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        success: function(authObj) {
          console.log(JSON.stringify(authObj))
          const socialAccessToken = {
            accessToken: authObj.access_token,
            refreshToken: authObj.refresh_token,
            tokenType: 'KAKAO',
            expireTime: authObj.expires_in,
            refreshExpireTime: authObj.refresh_token_expires_in
          }
          socialLogin(socialAccessToken).then(res => {
            console.log(res)
            window.localStorage.setItem('jwt', res.item.jwt)
            window.localStorage.setItem('userID', res.item.id)
            window.location.href = '/'
          })
        },
        fail: function(err) {
          alert('failed to login: ' + JSON.stringify(err))
        }
      })
    }
  }
}
</script>
