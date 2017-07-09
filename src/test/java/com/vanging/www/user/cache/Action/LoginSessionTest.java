package com.vanging.www.user.cache.Action;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginSessionTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getSessionFromUidAndGetUidFromSession() throws Exception
    {
        for(int i = 0; i < 10 ; i ++)
        {
            String session = LoginSession.getSessionFromUid("uid-" + i);
            String uid = LoginSession.getUidFromSession(session);
            System.out.println(session);
            System.out.println(uid);
            Assert.assertEquals(uid, "uid-" + i);
        }
    }

}