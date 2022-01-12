import request from '@/utils/request'

// 查询角色拥有的菜单数组
export function listRoleMenus(roleId) {
  return request({
    url: '/system/manage/role/list_role_menus?roleId=' + roleId,
    method: 'get'
  })
}

// 赋予角色菜单
export function assignRoleMenu(data) {
  return request({
    url: '/system/permission/assign-role-menu',
    method: 'post',
    data: data
  })
}

// 查询用户拥有的角色数组
export function listUserRoles(userId) {
  return request({
    url: '/system/manage/user/list_user_roles?userId=' + userId,
    method: 'get'
  })
}

// 赋予用户角色
export function assignUserRole(data) {
  return request({
    url: '/system/manage/user/update_user_role',
    method: 'post',
    data: data
  })
}

// 赋予角色数据权限
export function assignRoleDataScope(data) {
  return request({
    url: '/system/permission/assign-role-data-scope',
    method: 'post',
    data: data
  })
}
