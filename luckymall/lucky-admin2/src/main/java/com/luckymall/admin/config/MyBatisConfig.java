package com.luckymall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.luckymall.admin.dao"})
public class MyBatisConfig {
}
