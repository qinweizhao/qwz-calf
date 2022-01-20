import request from '@/utils/request'

// 查询定时任务调度列表
export function listJob(query) {
  return request({
    url: '/system/tool/job/page',
    method: 'get',
    params: query
  })
}

// 查询定时任务调度详细
export function getJob(jobId) {
  return request({
    url: '/system/tool/job/get?jobId=' + jobId,
    method: 'get'
  })
}

// 新增定时任务调度
export function addJob(data) {
  return request({
    url: '/system/tool/job/save',
    method: 'post',
    data: data
  })
}

// 修改定时任务调度
export function updateJob(data) {
  return request({
    url: '/system/tool/job/update',
    method: 'put',
    data: data
  })
}

// 删除定时任务调度
export function delJob(jobId) {
  return request({
    url: '/system/tool/job/remove?jobId=' + jobId,
    method: 'delete'
  })
}


// 任务状态修改
export function updateJobStatus(jobId, status) {
  return request({
    url: '/system/tool/job/update-status',
    method: 'put',
    headers:{
      'Content-type': 'application/x-www-form-urlencoded'
    },
    data: 'jobId=' + jobId + "&status=" + status,
  })
}

// 定时任务立即执行一次
export function runJob(jobId) {
  return request({
    url: '/system/tool/job/trigger?jobId=' + jobId,
    method: 'put'
  })
}

// 获得定时任务的下 n 次执行时间
export function getJobNextTimes(jobId) {
  return request({
    url: '/system/tool/job/get_next_times?jobId=' + jobId,
    method: 'get'
  })
}
            