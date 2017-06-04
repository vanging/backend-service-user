package com.vanging.backend.user;

import com.vanging.backend.user.models.Auth;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersistenceTest
{
    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeClass
    public static void init()
    {
        Persistence.config("hibernate.test.cfg.xml");
        sessionFactory = Persistence.getSessionFactory();
        session = Persistence.getSession();
    }

    @Test
    public void testHibernate()
    {
        Assert.assertNotNull(sessionFactory);
        Assert.assertNotNull(session);

        Transaction transaction = session.getTransaction();
        transaction.begin();

        Auth auth = new Auth();
        auth.setUid(0);
        auth.setPassword("密码");
        session.save(auth);

        transaction.commit();
    }

    @AfterClass
    public static void clean()
    {
        session.clear();
        sessionFactory.close();
    }
}
