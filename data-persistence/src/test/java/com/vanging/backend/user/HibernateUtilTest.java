package com.vanging.backend.user;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateUtilTest
{
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init()
    {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Test
    public void testHibernate()
    {
        Assert.assertNotNull(sessionFactory);
    }

    @AfterClass
    public static void clean()
    {
        sessionFactory.close();
    }
}
