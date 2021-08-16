import request from '@/utils/request'

export function fetchList(query) {
  alert('fetchList ? ' + query)
  console.log('====================')
  return request({
    url: '/words',
    method: 'get',
    params: query
  })
}
