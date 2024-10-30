import request from '@/utils/request'

// 查询course列表
export function listCourse(query) {
  return request({
    url: '/course/course/list',
    method: 'get',
    params: query
  })
}

// 查询course详细
export function getCourse(courseId) {
  return request({
    url: '/course/course/' + courseId,
    method: 'get'
  })
}
// 查询首页轮播图，推荐，精品课的课程号
export function getHomeCourse() {
  return request({
    url: '/course/course/getHomeCourse',
    method: 'get'
  })
}

// 新增course
export function addCourse(data) {
  return request({
    url: '/course/course',
    method: 'post',
    data: data
  })
}

// 修改course
export function updateCourse(data) {
  return request({
    url: '/course/course',
    method: 'put',
    data: data
  })
}

// 删除course
export function delCourse(courseId) {
  return request({
    url: '/course/course/' + courseId,
    method: 'delete'
  })
}
// 选择course
export function selectCourse(courseId) {
  return request({
    url: '/course/enrollments/selectCourse/' + courseId,
    method: 'get'
  })
}

// 新增course_chapters章节
export function addChapters(data) {
  return request({
    url: '/course/chapters',
    method: 'post',
    data: data
  })
}
