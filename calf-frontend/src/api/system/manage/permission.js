import request from '@/utils/request'

// 查询角色拥有的菜单数组
export function listRoleMenus(roleId) {
  return request({
    url: '/system/manage/role/list_role_menus?roleId=' + roleId,
    method: 'get'
  })
}

// 赋予角色菜单
export function updateByolePermission(data) {
  return request({
    url: '/system/manage/role/update_role_permission',
    method: 'put',
    data: data
  })
}

// 查询用户拥有的角色数组
export function listUserRoles(userId) {
  return request({
    url: '/system/manage/user/list-user-roles?userId=' + userId,
    method: 'get'
  })
}

// 赋予用户角色
export function assignUserRole(data) {
  return request({
    url: '/system/manage/user/update-user-role',
    method: 'post',
    data: data
  })
}
