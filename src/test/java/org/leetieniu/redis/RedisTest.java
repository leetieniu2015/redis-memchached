package org.leetieniu.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring.xml")
public class RedisTest {

	@Autowired
	private Jedis jedis;

	@Test
	public void testSet() {
		System.out.println(jedis.set("mykey", "Redis tutorial"));
		System.out.println(jedis.get("mykey"));
	}

	@Test
	public void testLpush() {
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		jedis.lpush("tutorial-list", "Memcached");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}
	}

	@Test
	public void testKeys() {
		// 获取数据并输出
		Set<String> set = jedis.keys("*");
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}
}
