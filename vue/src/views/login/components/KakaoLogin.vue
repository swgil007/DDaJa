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
            console.log('kakao login request!')
            console.log(res)
          })
        //   axios.post(userInfoURI, socialAccessToken)
        //     .then(res => {
        //       console.log(res)
        //       if (res.status === 200) {
        //         console.log('hreer!')
        //         window.localStorage.setItem('jwt', res.data.item.jwt)
        //         window.localStorage.setItem('userID', res.data.item.id)
        //         // window.location.href="/"
        //         return
        //       } else if (res.status === 201) {
        //         window.localStorage.setItem('jwt', res.data.item.jwt)
        //         window.localStorage.setItem('userID', res.data.item.id)
        //         return
        //       }
        //       alert('로그인에 실패하였습니다 :(')
        //     })
        //     .catch(err => {
        //       console.log(err)
        //     })
        },
        fail: function(err) {
          alert('failed to login: ' + JSON.stringify(err))
        }
      })
    }
  }
}
</script>
