package com.imooc.tasks;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:定时任务
 */
@Component
//开启定时任务
@EnableScheduling
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
//    @Scheduled(cron = "1-20 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间："+dateFormat.format(new Date()));
    }
}
