package com.waltzhu.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration  
@EnableRedisHttpSession(redisNamespace="app1",maxInactiveIntervalInSeconds= 3600)
//session共享的时候，不同应用都能共享。但有些时候，只想在同一个应用的集群下做共享。需要隔离不同应用。保存REDIS的时候就要做差异性处理
public class RedisSessionConfig {

}
