package com.vanging.backend.user;

import com.sun.istack.internal.Nullable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

class Persistence
{
    private static SessionFactory sessionFactory = null;
    private static Configuration configuration = null;
    private static StandardServiceRegistry standardServiceRegistry = null;
    private static MetadataSources metadataSource = null;
    private static Metadata metadata = null;

    static
    {
        config("hibernate.cfg.xml");
    }

    static void config(String config_file_path)
    {

        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure(config_file_path)
                .build();
        try
        {
            metadataSource = new MetadataSources(standardServiceRegistry);
            metadata = metadataSource.buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
        }
        catch(Exception e)
        {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            throw new RuntimeException(e);
        }
    }

    static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    static Session getSession()
    {
        return sessionFactory.openSession();
    }
}
