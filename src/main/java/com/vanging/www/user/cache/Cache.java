package com.vanging.www.user.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Cache
{
    private static JedisPoolConfig jedisPoolConfig;
    private static JedisPool jedisPool;

    private static int timeout = 2000;
    private static int port = 6379;
    private static String password = "Mm123456";
    private static String hostInternal = "redis.internal.vanging.com";
    private static String hostExternal = "redis.external.vanging.com";

    static
    {
        jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(1000);

        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestOnCreate(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(10000);

        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPoolConfig.setBlockWhenExhausted(true);
        developmentConfig();
    }

    public static void developmentConfig()
    {
        jedisPool = new JedisPool(jedisPoolConfig, hostExternal, port, timeout, password);
    }

    public static void productionConfig()
    {
        jedisPool = new JedisPool(jedisPoolConfig, hostInternal, port, timeout, password);
    }

    public static Jedis getConnection()
    {
        return jedisPool.getResource();
    }
}
