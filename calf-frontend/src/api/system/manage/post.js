import request from '@/utils/request'

// 查询岗位列表
export function listPost(query) {
  return request({
    url: '/system/manage/post/page',
    method: 'get',
    params: query
  })
}

// 获取岗位精简信息列表
export function listSimplePosts() {
  return request({
    url: '/system/manage/post/list-simple',
    method: 'get'
  })
}

// 查询岗位详细
export function getPost(postId) {
  return request({
    url: '/system/manage/post/get?postId=' + postId,
    method: 'get'
  })
}

// 新增岗位
export function addPost(data) {
  return request({
    url: '/system/manage/post/save',
    method: 'post',
    data: data
  })
}

// 修改岗位
export function updatePost(data) {
  return request({
    url: '/system/manage/post/update',
    method: 'put',
    data: data
  })
}

// 删除岗位
export function delPost(postId) {
  return request({
    url: '/system/manage/post/remove?postId=' + postId,
    method: 'delete'
  })
}

