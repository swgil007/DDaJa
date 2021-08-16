import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/words',
    method: 'get',
    params: query
  })
}