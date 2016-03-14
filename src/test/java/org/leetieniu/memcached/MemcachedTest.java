package org.leetieniu.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedTest {

	@Test
	public void test() {
		
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("182.61.3.249:11211"));
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = builder.build();
			memcachedClient.set("hello", 0, "Hello,xmemcached");
			String value = memcachedClient.get("hello");
			System.out.println("hello=" + value);
			memcachedClient.delete("hello");
			value = memcachedClient.get("hello");
			System.out.println("hello=" + value);
		} catch (IOException e) {
			System.err.println("MemcachedClient operation fail");
			e.printStackTrace();
		} catch (MemcachedException e) {
			System.err.println("MemcachedClient operation fail");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("MemcachedClient operation timeout");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// ignore
		} finally {
			try {
				memcachedClient.shutdown();
			} catch (IOException e) {
				System.err.println("Shutdown MemcachedClient fail");
				e.printStackTrace();
			}
		}
	}
}