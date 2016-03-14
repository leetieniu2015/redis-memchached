package org.leetieniu.memcached.service.impl;

import java.util.Date;

import org.leetieniu.memcached.service.MemcachedService;
import org.leetieniu.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "memcachedStringService")
public class MemcachedStringServiceImpl implements CacheService<String>, MemcachedService {
	
	@Override
	@Cacheable(value = CACHE_MEMCAHE , key = "#key")
	public String getKey(String key) {
		final String time = new Date().toString();
		
		System.out.println(time);
		return String.format("get time : %s", time) ;
	}

	@Override
	@CachePut(value = CACHE_MEMCAHE, key = "#key")
	public String putKey(String key, String value) {
		return value;
	}

	@Override
	@CacheEvict(value = CACHE_MEMCAHE, key="#key")
	public void deleteKey(String key) {
		System.out.println(String.format("delete time : %s", new Date().toString()));
	}
}
