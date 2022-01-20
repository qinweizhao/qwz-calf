import request from '@/utils/request'

// 查询字典数据列表
export function listData(query) {
  return request({
    url: '/system/manage/dict/item/page',
    method: 'get',
    params: query
  })
}

// 查询字典数据详细
export function getData(dictCode) {
  return request({
    url: '/system/manage/dict/item/get?id=' + dictCode,
    method: 'get'
  })
}

// 根据字典类型查询字典数据信息
export function getDicts(dictType) {
  return request({
    url: '/system/manage/dict/item/type/' + dictType,
    method: 'get'
  })
}

// 新增字典数据
export function addData(data) {
  return request({
    url: '/system/manage/dict/item/create',
    method: 'post',
    data: data
  })
}

// 修改字典数据
export function updateData(data) {
  return request({
    url: '/system/manage/dict/item/update',
    method: 'put',
    data: data
  })
}

// 删除字典数据
export function delData(dictCode) {
  return request({
    url: '/system/manage/dict/item/delete?id=' + dictCode,
    method: 'delete'
  })
}

// 导出字典数据
export function exportData(query) {
  return request({
    url: '/system/manage/dict/item/export',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}

// 查询全部字典数据列表
export function listSimpleDictDatas() {
  return request({
    url: '/system/manage/dict/item/list-simple',
    method: 'get',
  })
}
