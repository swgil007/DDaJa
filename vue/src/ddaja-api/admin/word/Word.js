import request from '@/utils/request'

export function licenseList(param) {
  return request({
    url: '/licenses'
    , method: 'get'
    , params: {}
  })
}

export function wordList(param) {
  return request({
    url : '/words'
    , method : 'get'
    , params : {
      licenseID : param.licenseID
      , name    : param.name || ''
      , page    : param.page || 0
      , size    : param.size || 0
    }
  })
}

export function wordInsert(param) {
  return request({
    url : '/words'
    , method : 'post'
    , params : {
      lID      : param.lID
      , title  : param.title || ''
    }
  })
}

export function wordUpdate(param) {
  return request({
    url : '/words/' + param.id 
    , method : 'put'
    , params : {
      lID      : param.lID
      , title  : param.title || ''
    }
  })
}

export function wordDelete(param) {
  return request({
    url : '/words/' + param.id
    , method : 'delete'
    , params : {}
  })
}

export function wordListTotalCount(param) {
  return request({
    url : '/words/total-count'
    , method : 'get'
    , params : {
      licenseID : param.licenseID
      , name    : param.name || ''
      , page    : param.page || 0
      , size    : param.size || 0
    }
  })
}

export function wordQuestionList(param) {
  return request({
    url: '/word-questions'
    , method: 'get'
    , params: {
      wordID: param.wID
      , page: param.page || 0
      , size: param.size || 0
    }
  })
}

export function wordQuestionInsert(param) {
  return request({
    url : '/word-questions'
    , method : 'post'
    , async: true
    , params : {
      wID       : param.wID
      , lID     : param.lID
      , answer  : param.answer   || ''
      , content : param.content || ''

    }
  })
}

export function noticeRegister(data){
  return request({
      url: '/api/notices',
      method: 'post',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
      },
      data : frm
  })
}


export function wordQuestionUpdate(param) {
  return request({
    url : '/word-questions/' + param.id
    , method : 'put'
    , params : {
      wID       : param.wID
      , lID     : param.lID
      , answer  : param.answer   || ''
      , content : param.content  || ''
    }
  })
}

export function wordQuestionDelete(param) {
  return request({
    url : '/word-questions/' + param.id
    , method : 'delete'
    , params : {}
    , dataType : 'json'
  })
}
