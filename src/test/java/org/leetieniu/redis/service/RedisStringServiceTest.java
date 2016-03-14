package org.leetieniu.redis.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leetieniu.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring.xml")
public class RedisStringServiceTest {
	
	@Autowired
	@Qualifier(value = "redisStringService")
	private CacheService<String> redisStringService;
	
	@Test
	public void testGetKey() {
		System.out.println(redisStringService.getKey("leejun"));
		System.out.println(redisStringService.getKey("leejun"));
	}
	
	@Test
	public void testPutKey() {
		System.out.println(redisStringService.putKey("leejun", String.format("put time : %s", new Date().toString())));
	}
	
	@Test
	public void testDeleteKey() {
		redisStringService.deleteKey("leejun");
	}
}
