import request from '@/utils/request'

export function test() {
<<<<<<< HEAD
  console.log('test api start')

  var result = request({
    url: '/licenses',
		 method: 'get',
    params: { }
  })
  console.log(result)

  console.log('test api end ')
=======
  var result = request({
    url: '/licenses',
    method: 'get',
    params: { }
  })

>>>>>>> 8c648e9c4372be86d077b18e1b33d4ea0edea249
  return result
}
