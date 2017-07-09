package com.vanging.www.user.cache.Action;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void setSessionInfo() throws Exception
    {
        for(int i = 0; i < 100 ; i ++)
        {
            Assert.assertTrue(Session.setSessionInfo(Integer.toString(i) + "test", "session" + i));
        }
    }

    @Test
    public void getSessionInfo() throws Exception
    {
        for(int i = 0; i < 100 ; i ++)
        {
            Assert.assertEquals(Session.getSessionInfo(Integer.toString(i) + "test"), "session" + i);
        }
    }

    @Test
    public void getUidFromSession() throws Exception
    {
    }

}