package com.imooc.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Description:异步任务测试类
 */
@RestController
@RequestMapping("/tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test")
    public String test1() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> task1 = asyncTask.doTask11();
        Future<Boolean> task2 = asyncTask.doTask22();
        Future<Boolean> task3 = asyncTask.doTask33();

        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            // 当所有的任务都执行完时，退出
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);
        return times;
    }
}
