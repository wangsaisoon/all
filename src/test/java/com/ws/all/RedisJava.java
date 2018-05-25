package com.ws.all;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/17 12:19
 * @Description: 连接到 redis 服务
 */
public class RedisJava {

    public static void main(String[] args) {
        // 先启动本地redis服务
//        testString();
//        testList();
        testKeys();




    }

    /** Redis Java Keys 实例 */
    public static void testKeys() {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println(jedis.ping());

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        keys.forEach(e -> System.out.println(e));

        System.out.println("***********************");

        Iterator<String> it = keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }

    /** Redis Java List(列表) 实例 */
    public static void testList() {
        // 连接本地的redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());

        // 存储数据到列表中
        jedis.lpush("name1", "小白");
        jedis.lpush("name1", "小黑");
        jedis.lpush("name1", "小白");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("name1", 0, 100);
        list.forEach(e -> System.out.println(e));
    }

    /** Redis Java String(字符串) 实例 */
    public static void testString() {
        // 连接本地的redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());

        // 设置redis字符串数据
        jedis.set("myBook", "english1");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("myBook"));
    }
}
