import request from '@/utils/request'

export function adminLogin(body) {
  return request({
    url: '/admin/login',
    method: 'post',
    data: body
  })
}
