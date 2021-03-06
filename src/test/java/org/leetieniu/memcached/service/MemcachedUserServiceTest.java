package org.leetieniu.memcached.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leetieniu.model.User;
import org.leetieniu.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.code.ssm.spring.SSMCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring.xml")
public class MemcachedUserServiceTest {

	@Autowired
	@Qualifier(value = "memcachedUserService")
	private CacheService<User> memcachedUserService;
	
	@Test
	public void testGetKey() {
		System.out.println(memcachedUserService.getKey("1"));
		System.out.println(memcachedUserService.getKey("1"));
	}
	
	@Test
	public void testPutKey() {
		final User user = new User("1", "leetieniu", "shouaiaa02", String.format("put time : %s", new Date().toString()));
		
		System.out.println(memcachedUserService.putKey("1", user));
	}
	
	@Test
	public void testDeleteKey() {
		memcachedUserService.deleteKey("1");
	}
	
	@Autowired
	private SSMCache cache;
	
	@Test
	public void load() {
		System.out.println(cache.getCache());
	}
}
