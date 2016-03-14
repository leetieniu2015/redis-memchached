package org.leetieniu.redis.service.impl;

import java.util.Date;

import org.leetieniu.model.User;
import org.leetieniu.redis.service.RedisService;
import org.leetieniu.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "redisUserService")
public class RedisUserServiceImpl implements CacheService<User>, RedisService {
	
	@Override
	@Cacheable(value = CACHE_REDISCAHE , key = "'user_' + #id")
	public User getKey(String id) {
    	final String time = String.format("get time : %s", new Date().toString());
		System.out.println(time);
		return new User(id, "leejun", "shouaiaa02", time);
	}
    
	@Override
	@CachePut(value = CACHE_REDISCAHE, key = "'user_' + #id")
	public User putKey(String id, User user) {
    	final String time = String.format("put time : %s", new Date().toString());
		System.out.println(time);
		return user;
	}
    
	@Override
	@CacheEvict(value = CACHE_REDISCAHE, key="'user_' + #id")
	public void deleteKey(String id) {
    	final String time = String.format("delete time : %s", new Date().toString());
		System.out.println(time);
	}
}
