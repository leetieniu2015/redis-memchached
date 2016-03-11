package org.leetieniu.redis.service;

/**
 * @className RedisService
 * @description redis服务接口  
 * @author leejun
 * @date 2016年3月11日 下午2:18:11
 * @version v1.0
 * @param <T>
 */
public interface RedisService <T> {
	
	/**
	 * @title getKey
	 * @description 查询, 如果缓存中不存在则添加到缓存
	 * @date 2016年3月11日 下午2:18:23
	 * @param key
	 * @return 查询结果
	 */
	public T getKey(String key);
	
	/**
	 * @title putKey
	 * @description 修改, 修改缓存中的数据
	 * @date 2016年3月11日 下午2:18:32
	 * @param key
	 * @param value
	 * @return
	 */
	public T putKey(String key, T value);
	
	/**
	 * @title deleteKey
	 * @description 删除, 会从现有的缓存汇中删除数据  
	 * @date 2016年3月11日 下午2:23:58
	 * @param key
	 */
	public void deleteKey(String key);
}
