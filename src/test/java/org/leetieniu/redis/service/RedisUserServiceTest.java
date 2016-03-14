package org.leetieniu.redis.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leetieniu.model.User;
import org.leetieniu.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring.xml")
public class RedisUserServiceTest {
	
	@Autowired
	@Qualifier(value = "redisUserService")
	private CacheService<User> redisUserService;
	
	@Test
	public void testGetKey() {
		System.out.println(redisUserService.getKey("leejun"));
		System.out.println(redisUserService.getKey("leejun"));
	}
	
	@Test
	public void testPutKey() {
		final User user = new User("1", "leetieniu", "shouaiaa02", String.format("put time : %s", new Date().toString()));
		
		System.out.println(redisUserService.putKey("1", user));
	}
	
	@Test
	public void testDeleteKey() {
		redisUserService.deleteKey("leejun");
	}
}
