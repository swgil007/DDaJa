import request from '@/utils/request'

export function fetchList(param) {
  return request({
    url: '/words',
    method: 'get',
    params: {
      licenseID: param.licenseID,
      page: param.page,
      size: param.size
    }
  })
}
