import request from '@/utils/request'

// 查询菜单列表
export function listMenu(query) {
  return request({
    url: '/system/manage/menu/list',
    method: 'get',
    params: query
  })
}

// 查询菜单（精简)列表
export function listSimpleMenus() {
  return request({
    url: '/system/manage/menu/list_simple',
    method: 'get'
  })
}

// 查询菜单详细
export function getMenu(id) {
  return request({
    url: '/system/manage/menu/get?id=' + id,
    method: 'get'
  })
}

// 新增菜单
export function addMenu(data) {
  return request({
    url: '/system/manage/menu/save',
    method: 'post',
    data: data
  })
}

// 修改菜单
export function updateMenu(data) {
  return request({
    url: '/system/manage/menu/update',
    method: 'put',
    data: data
  })
}

// 删除菜单
export function delMenu(id) {
  return request({
    url: '/system/manage/menu/remove?id=' + id,
    method: 'delete'
  })
}
