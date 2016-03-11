package org.leetieniu.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component(value = "redisFactory")
public class RedisFactory {
	
	@Autowired
	@Qualifier("jedisPool")
	private JedisPool pool;
	
	public Jedis getInstance(String password) {
		
		final Jedis jedis = pool.getResource();
		jedis.auth(password);
		return jedis;
	}
}
