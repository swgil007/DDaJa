import request from '@/utils/request'

export function fetchList(query) {
    alert('fetchList!')
    return request({
        url: '/words',
        method: 'get',
        params: query
    })
}

export function login() {
    alert('login')
    const { username } = 'admin'
    const token = tokens[username]
    return {
        code: 20000,
        data: token
    }
}

const tokens = {
    admin: {
        token: 'admin-token'
    },
    editor: {
        token: 'editor-token'
    }
}