package com.luckymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.luckymall.dao"})
public class MyBatisConfig {
}
