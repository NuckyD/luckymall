package com.luckymall.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.luckymall.user.dao"})
public class MyBatisConfig {
}
