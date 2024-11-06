import request from '@/utils/request'

// 查询精品课的课程id列表
export function listFineCourse(query) {
  return request({
    url: '/FineCourse/FineCourse/list',
    method: 'get',
    params: query
  })
}

// 查询精品课的课程id详细
export function getFineCourse(fineId) {
  return request({
    url: '/FineCourse/FineCourse/' + fineId,
    method: 'get'
  })
}

// 新增精品课的课程id
export function addFineCourse(data) {
  return request({
    url: '/FineCourse/FineCourse',
    method: 'post',
    data: data
  })
}

// 修改精品课的课程id
export function updateFineCourse(data) {
  return request({
    url: '/FineCourse/FineCourse',
    method: 'put',
    data: data
  })
}

// 删除精品课的课程id
export function delFineCourse(fineId) {
  return request({
    url: '/FineCourse/FineCourse/' + fineId,
    method: 'delete'
  })
}
