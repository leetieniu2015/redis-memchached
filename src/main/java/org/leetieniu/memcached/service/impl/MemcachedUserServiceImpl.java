package org.leetieniu.memcached.service.impl;

import java.util.Date;

import org.leetieniu.memcached.service.MemcachedService;
import org.leetieniu.model.User;
import org.leetieniu.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;	

@Service("memcachedUserService")
public class MemcachedUserServiceImpl implements CacheService<User>, MemcachedService {
	
	@Override
	@Cacheable(value = CACHE_MEMCAHE , key = "#id")
	public User getKey(String id) {
    	final String time = String.format("get time : %s", new Date().toString());
		System.out.println(time);
		return new User(id, "leejun", "shouaiaa02", time);
	}
    
	@Override
	@CachePut(value = CACHE_MEMCAHE, key = "#id")
	public User putKey(String id, User user) {
    	final String time = String.format("put time : %s", new Date().toString());
		System.out.println(time);
		return user;
	}
    
	@Override
	@CacheEvict(value = CACHE_MEMCAHE, key="#id")
	public void deleteKey(String id) {
    	final String time = String.format("delete time : %s", new Date().toString());
		System.out.println(time);
	}
	
	/*private static final String NAMESPACE = "MemcachedUser";
	
	 * 
     * 当执行getById查询方法时，系统首先会从缓存中获取id对应的实体 
     * 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中 
      
    @ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
	@Override
	public User getKey(@ParameterValueKeyProvider String id) {
    	final String time = String.format("get time : %s", new Date().toString());
		System.out.println(time);
		return new User(id, "leejun", "shouaiaa02", time);
	}
    
    *//** 
     * 当执行updateUser方法时，系统会更新缓存中id对应的实体 
     * 将实体内容更新成@DataUpdateContent标签所描述的实体 
     *//*  
    @UpdateSingleCache(namespace = NAMESPACE, expiration = 3600)  
	@Override
	public User putKey(@ParameterValueKeyProvider String id, @ParameterDataUpdateContent User user) {
    	final String time = String.format("put time : %s", new Date().toString());
		System.out.println(time);
		return user;
	}
    
    *//** 
     * 当执行deleteUser方法时，系统会删除缓存中id对应的实体 
     *//*  
    @InvalidateSingleCache(namespace = NAMESPACE)  
	@Override
	public void deleteKey(@ParameterValueKeyProvider String id) {
    	final String time = String.format("delete time : %s", new Date().toString());
		System.out.println(time);
	}*/
}
