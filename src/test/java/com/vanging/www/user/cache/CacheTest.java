package com.vanging.www.user.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class CacheTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void developmentConfig() throws Exception
    {
        Cache.developmentConfig();
    }

    @Test
    public void productionConfig() throws Exception
    {
        Cache.productionConfig();
    }

    @Test
    public void getConnection() throws Exception
    {
        Jedis jedis = Cache.getConnection();
        jedis.set("test","test");
        System.out.println(jedis.get("test"));
    }

}