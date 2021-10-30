import request from '@/utils/request'

export function socialLogin(body) {
  return request({
    url: '/users/social',
    method: 'post',
    data: body
  })
}
