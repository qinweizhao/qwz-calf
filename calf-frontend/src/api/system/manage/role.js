import request from '@/utils/request'

// 查询角色列表
export function listRole(query) {
  return request({
    url: '/system/manage/role/page',
    method: 'get',
    params: query
  })
}

// 查询角色（精简)列表
export function listSimpleRoles() {
  return request({
    url: '/system/manage/role/list_simple',
    method: 'get'
  })
}

// 查询角色详细
export function getRole(roleId) {
  return request({
    url: '/system/manage/role/get?roleId=' + roleId,
    method: 'get'
  })
}

// 新增角色
export function addRole(data) {
  return request({
    url: '/system/manage/role/save',
    method: 'post',
    data: data
  })
}

// 修改角色
export function updateRole(data) {
  return request({
    url: '/system/manage/role/update',
    method: 'put',
    data: data
  })
}

// 角色状态修改
export function changeRoleStatus(id, status) {
  const data = {
    id,
    status
  }
  return request({
    url: '/system/manage/role/update-status',
    method: 'put',
    data: data
  })
}

// 删除角色
export function delRole(roleId) {
  return request({
    url: '/system/manage/role/remove?roleId=' + roleId,
    method: 'delete'
  })
}
