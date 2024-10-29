import request from '@/utils/request'

// 查询course_chapters列表
export function listChapters(query) {
  return request({
    url: '/course/chapters/list',
    method: 'get',
    params: query
  })
}

// 查询course_chapters详细
export function getChapters(chapterId) {
  return request({
    url: '/course/chapters/' + chapterId,
    method: 'get'
  })
}
// 查询course_chapters详细
export function getChaptersInfoByChapterId(chapterId) {
  return request({
    url: '/course/chapters/getChaptersInfoByChapterId/' + chapterId,
    method: 'get'
  })
}

// 新增course_chapters
export function addChapters(data) {
  return request({
    url: '/course/chapters',
    method: 'post',
    data: data
  })
}

// 修改course_chapters
export function updateChapters(data) {
  return request({
    url: '/course/chapters',
    method: 'put',
    data: data
  })
}

// 删除course_chapters
export function delChapters(chapterId) {
  return request({
    url: '/course/chapters/' + chapterId,
    method: 'delete'
  })
}
