package com.ws.all;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching// 启用缓存
@SpringBootApplication
@MapperScan(basePackages = {"com.ws.all.bean.mapper","com.ws.all.service"})// mybatis扫描包
public class AllApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllApplication.class, args);
	}
}
