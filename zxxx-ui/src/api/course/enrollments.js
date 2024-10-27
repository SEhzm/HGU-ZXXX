import request from '@/utils/request'

// 查询course_enrollments列表
export function listEnrollments(query) {
  return request({
    url: '/course/enrollments/list',
    method: 'get',
    params: query
  })
}
// 查询我的选课记录列表
export function myListEnrollments(query) {
  return request({
    url: '/course/enrollments/myList',
    method: 'get',
    params: query
  })
}

// 查询course_enrollments详细
export function getEnrollments(enrollmentId) {
  return request({
    url: '/course/enrollments/' + enrollmentId,
    method: 'get'
  })
}

// 新增course_enrollments
export function addEnrollments(data) {
  return request({
    url: '/course/enrollments',
    method: 'post',
    data: data
  })
}

// 修改course_enrollments
export function updateEnrollments(data) {
  return request({
    url: '/course/enrollments',
    method: 'put',
    data: data
  })
}

// 删除course_enrollments
export function delEnrollments(enrollmentId) {
  return request({
    url: '/course/enrollments/' + enrollmentId,
    method: 'delete'
  })
}
