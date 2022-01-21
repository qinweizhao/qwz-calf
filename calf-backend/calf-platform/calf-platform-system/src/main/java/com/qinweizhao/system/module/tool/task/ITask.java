package com.qinweizhao.system.module.tool.task;

/**
 * @author qinweizhao
 * @since 2022/1/21
 */
public interface ITask {

    /**
     * 执行定时任务接口
     *
     * @param params   参数，多参数使用JSON数据
     */
    void run(String params);
}
