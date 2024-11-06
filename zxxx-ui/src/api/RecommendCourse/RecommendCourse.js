import request from '@/utils/request'

// 查询首页推荐课的课程id列表
export function listRecommendCourse(query) {
  return request({
    url: '/RecommendCourse/RecommendCourse/list',
    method: 'get',
    params: query
  })
}

// 查询首页推荐课的课程id详细
export function getRecommendCourse(recommendId) {
  return request({
    url: '/RecommendCourse/RecommendCourse/' + recommendId,
    method: 'get'
  })
}

// 新增首页推荐课的课程id
export function addRecommendCourse(data) {
  return request({
    url: '/RecommendCourse/RecommendCourse',
    method: 'post',
    data: data
  })
}

// 修改首页推荐课的课程id
export function updateRecommendCourse(data) {
  return request({
    url: '/RecommendCourse/RecommendCourse',
    method: 'put',
    data: data
  })
}

// 删除首页推荐课的课程id
export function delRecommendCourse(recommendId) {
  return request({
    url: '/RecommendCourse/RecommendCourse/' + recommendId,
    method: 'delete'
  })
}
