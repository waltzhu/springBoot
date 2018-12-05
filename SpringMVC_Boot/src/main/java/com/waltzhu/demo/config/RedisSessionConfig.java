package com.waltzhu.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration  
@EnableRedisHttpSession(redisNamespace="app1",maxInactiveIntervalInSeconds= 3600)
//session�����ʱ�򣬲�ͬӦ�ö��ܹ�������Щʱ��ֻ����ͬһ��Ӧ�õļ�Ⱥ����������Ҫ���벻ͬӦ�á�����REDIS��ʱ���Ҫ�������Դ���
public class RedisSessionConfig {

}
