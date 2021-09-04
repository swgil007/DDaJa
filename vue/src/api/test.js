import request from '@/utils/request'

export function test() {
  var result = request({
    url: '/licenses',
		 method: 'get',
    params: { }
  })

  return result
}
