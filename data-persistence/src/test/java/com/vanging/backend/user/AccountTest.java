package com.vanging.backend.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;

import static org.junit.Assert.*;

public class AccountTest
{

    @BeforeClass
    public static void setUp() throws Exception
    {
        Persistence.config("hibernate.test.cfg.xml");
    }

    @AfterClass
    public static void tearDown() throws Exception
    {

    }

    @Test
    public void register() throws Exception
    {
        Account.register("278227739@qq.com", "123456");
    }

}