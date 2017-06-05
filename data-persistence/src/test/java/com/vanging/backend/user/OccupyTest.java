package com.vanging.backend.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class OccupyTest
{
    @BeforeClass
    public static void setUp()
    {
        Persistence.config("hibernate.test.cfg.xml");
    }

    @Test
    public void username() throws Exception
    {
        System.out.println(Occupy.username("username"));
    }

    @Test
    public void email() throws Exception
    {
        System.out.println(Occupy.email("278227739@qq.com"));
    }
}