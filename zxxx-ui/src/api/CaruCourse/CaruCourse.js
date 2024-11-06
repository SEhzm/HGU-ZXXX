import request from '@/utils/request'

// 查询首页轮播图展示的课程id列表
export function listCaruCourse(query) {
  return request({
    url: '/CaruCourse/CaruCourse/list',
    method: 'get',
    params: query
  })
}

// 查询首页轮播图展示的课程id详细
export function getCaruCourse(caruId) {
  return request({
    url: '/CaruCourse/CaruCourse/' + caruId,
    method: 'get'
  })
}

// 新增首页轮播图展示的课程id
export function addCaruCourse(data) {
  return request({
    url: '/CaruCourse/CaruCourse',
    method: 'post',
    data: data
  })
}

// 修改首页轮播图展示的课程id
export function updateCaruCourse(data) {
  return request({
    url: '/CaruCourse/CaruCourse',
    method: 'put',
    data: data
  })
}

// 删除首页轮播图展示的课程id
export function delCaruCourse(caruId) {
  return request({
    url: '/CaruCourse/CaruCourse/' + caruId,
    method: 'delete'
  })
}
