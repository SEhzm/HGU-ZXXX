import request from '@/utils/request'
// 查询course列表
export function listNotice() {
    return request({
        url: '/userNotice',
        method: 'get'
    })
}