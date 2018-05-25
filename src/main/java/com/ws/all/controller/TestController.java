package com.ws.all.controller;

import com.ws.all.service.RedisLock;
import com.ws.all.service.StudentManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test")
public class TestController {

   private static final int TIMEOUT = 10 * 1000;// 超时时间

//    @Autowired
//    private StudentManage studentManage;

    @Autowired
    private RedisLock redisLock;

    private String studentNumber = "1001";

    // 总库存
    private static Integer sum = 100000;

    // 下单成功的人数
    private static Integer personCount = 0;

    @GetMapping(value = "/test")
    public String test() {
        if (sum > 0) {
            // 加锁
            long time = System.currentTimeMillis() + TIMEOUT;
            // 判断加锁是否成功
            if (!redisLock.lock(studentNumber, String.valueOf(time))) {
                System.out.println("人太多了，等会再试试~");
                return "挤死了";
            }

            sum --;
            personCount ++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("限量100000份，还剩：" + sum + "份，下单成功：" + personCount + "人");

            // 解锁
            redisLock.unlock(studentNumber, String.valueOf(time));

            return "success";
        }
        System.out.println("活动结束！");
        return null;
    }
//    @GetMapping(value = "/test2")
    public synchronized String test2() {
        if (sum > 0) {
            sum --;
            personCount ++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("限量100000份，还剩：" + sum + "份，下单成功：" + personCount + "人");
            return "success";
        }
        System.out.println("活动结束！");
        return null;
    }
}
