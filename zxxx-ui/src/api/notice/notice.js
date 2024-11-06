import request from '@/utils/request'

// 查询course列表
export function listNotice(query) {
    return request({
        url: '/userNotice',
        method: 'get',
        params: query
    })
}