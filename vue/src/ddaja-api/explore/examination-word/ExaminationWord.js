import request from '@/utils/request'

<<<<<<< HEAD
export function fetchList(query) {
  return request({
    url: '/words',
    method: 'get',
    params: query
=======
export function fetchList() {
  return request({
    url: '/words',
    method: 'get',
    params: {
    }
>>>>>>> 8c648e9c4372be86d077b18e1b33d4ea0edea249
  })
}
