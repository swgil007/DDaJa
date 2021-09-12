import request from '@/utils/request'

export function licenseList(param) {
  return request({
    url: '/licenses',
    method: 'get',
    params: {}
  })
}

export function wordList(param) {
  return request({
    url: '/words',
    method: 'get',
    params: {
      licenseID: param.licenseID,
      name: param.name || '',
      page: param.page || 0,
      size: param.size || 0
    }
  })
}

export function wordListTotalCount(param) {
  return request({
    url: '/words/total-count',
    method: 'get',
    params: {
      licenseID: param.licenseID,
      name: param.name || '',
      page: param.page || 0,
      size: param.size || 0
    }
  })
}

export function wordQuestionList(param) {
  return request({
    url: '/word-questions',
    method: 'get',
    params: {
      wordID: param.wordID,
      page: param.page || 0,
      size: param.size || 0
    }
  })
}

export function wordQuestionUpdate(param) {
  return request({
    url: '/word-questions',
    method: 'patch',
    params: {
      qID: param.id,
      answer: param.answer || '',
      content: param.content || ''
    }
  })
}

export function wordQuestionInsert(param) {
  return request({
    url: '/word-questions',
    method: 'put',
    params: {
      answer: param.answer || '',
      content: param.content || ''
    }
  })
}

export function wordQuestionDelete(param) {
  return request({
    url: '/word-questions',
    method: 'delete',
    params: {
      qID: param.id
    }
  })
}
