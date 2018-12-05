package com.waltzhu.demo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	 @Autowired
	    private RedisTemplate redisTemplate;
	 
	 

@Autowired(required = false)
public void setRedisTemplate(RedisTemplate redisTemplate) {
    RedisSerializer stringSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setValueSerializer(stringSerializer);
    redisTemplate.setHashKeySerializer(stringSerializer);
    redisTemplate.setHashValueSerializer(stringSerializer);
    this.redisTemplate = redisTemplate;
} 
	    /**
	     * д�뻺��
	     * @param key
	     * @param value
	     * @return
	     */
	    public boolean set(String key, Object value) {
	        boolean result = false;
	        try {
	            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	            operations.set(key, value);
	            result = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    /**
	     * д�뻺������ʱЧʱ��
	     * @param key
	     * @param value
	     * @return
	     */
	    public boolean set(  String key, Object value, Long expireTime) {
	        boolean result = false;
	        try {
	            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	            operations.set(key, value);
	            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	            result = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    /**
	     * ����ɾ����Ӧ��value
	     * @param keys
	     */
	    public void remove(final String... keys) {
	        for (String key : keys) {
	            remove(key);
	        }
	    }

	    /**
	     * ����ɾ��key
	     * @param pattern
	     */
	    public void removePattern(final String pattern) {
	        Set<Serializable> keys = redisTemplate.keys(pattern);
	        if (keys.size() > 0)
	            redisTemplate.delete(keys);
	    }
	    /**
	     * ɾ����Ӧ��value
	     * @param key
	     */
	    public void remove(final String key) {
	        if (exists(key)) {
	            redisTemplate.delete(key);
	        }
	    }
	    /**
	     * �жϻ������Ƿ��ж�Ӧ��value
	     * @param key
	     * @return
	     */
	    public boolean exists(final String key) {
	        return redisTemplate.hasKey(key);
	    }
	    /**
	     * ��ȡ����
	     * @param key
	     * @return
	     */
	    public Object get(final String key) {
	        Object result = null;
	        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	        result = operations.get(key);
	        return result;
	    }
	    /**
	     * ��ϣ ���
	     * @param key
	     * @param hashKey
	     * @param value
	     */
	    public void hmSet(String key, Object hashKey, Object value){
	        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
	        hash.put(key,hashKey,value);
	    }

	    /**
	     * ��ϣ��ȡ����
	     * @param key
	     * @param hashKey
	     * @return
	     */
	    public Object hmGet(String key, Object hashKey){
	        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
	        return hash.get(key,hashKey);
	    }

	    /**
	     * �б����
	     * @param k
	     * @param v
	     */
	    public void lPush(String k,Object v){
	        ListOperations<String, Object> list = redisTemplate.opsForList();
	        list.rightPush(k,v);
	    }

	    /**
	     * �б��ȡ
	     * @param k
	     * @param l
	     * @param l1
	     * @return
	     */
	    public List<Object> lRange(String k, long l, long l1){
	        ListOperations<String, Object> list = redisTemplate.opsForList();
	        return list.range(k,l,l1);
	    }

	    /**
	     * �������
	     * @param key
	     * @param value
	     */
	    public void add(String key,Object value){
	        SetOperations<String, Object> set = redisTemplate.opsForSet();
	        set.add(key,value);
	    }

	    /**
	     * ���ϻ�ȡ
	     * @param key
	     * @return
	     */
	    public Set<Object> setMembers(String key){
	        SetOperations<String, Object> set = redisTemplate.opsForSet();
	        return set.members(key);
	    }

	    /**
	     * ���򼯺����
	     * @param key
	     * @param value
	     * @param scoure
	     */
	    public void zAdd(String key,Object value,double scoure){
	        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
	        zset.add(key,value,scoure);
	    }

	    /**
	     * ���򼯺ϻ�ȡ
	     * @param key
	     * @param scoure
	     * @param scoure1
	     * @return
	     */
	    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
	        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
	        return zset.rangeByScore(key, scoure, scoure1);
	    } 
}
