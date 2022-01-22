package com.qinweizhao.system.module.tool.task;

import org.springframework.stereotype.Component;

/**
 * @author qinweizhao
 * @since 2022/1/21
 */
@Component("test")
public class JobTest implements ITask {


    /**
     * 执行定时任务接口
     *
     * @param params 参数，多参数使用JSON数据
     */
    @Override
    public void run(String params) {
        System.out.println("执行、、、、、、");
        System.out.println(params);
    }
}
