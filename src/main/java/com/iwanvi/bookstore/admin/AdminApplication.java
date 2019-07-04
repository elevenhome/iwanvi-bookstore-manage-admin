package com.iwanvi.bookstore.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author YDF
 * @Description 免电图书资源中心
 * @Date 2019/3/11 0011 18:04
 * @Version 1.0
 **/
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.iwanvi.bookstore.admin.dao")
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
		System.out.println(" O(∩_∩)O~ 启动成功 ﾞ  \n" );
	}
}