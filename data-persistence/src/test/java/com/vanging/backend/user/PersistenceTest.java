package com.vanging.backend.user;

import com.vanging.backend.user.models.Auth;
import com.vanging.backend.user.models.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;

public class PersistenceTest
{
    private static SessionFactory sessionFactory;
    private static Session session;

    @Before
    public static void setUp() throws Exception
    {
        Persistence.config("hibernate.test.cfg.xml");
        sessionFactory = Persistence.getSessionFactory();
        session = Persistence.getSession();
    }

    @Test
    public void testHibernate() throws Exception
    {
        Assert.assertNotNull(sessionFactory);
        Assert.assertNotNull(session);
    }

    @After
    public void tearDown() throws Exception
    {
        session.clear();
        sessionFactory.close();
    }
}
