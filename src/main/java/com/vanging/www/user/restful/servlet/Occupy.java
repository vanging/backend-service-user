package com.vanging.www.user.restful.servlet;

import com.vanging.backend.user.models.Auth;
import com.vanging.backend.user.models.Profile;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Occupy
{
    static boolean username(String username)
    {
        return check("Auth", "username", username);
    }

    static boolean email(String email)
    {
        return check("Profile", "email", email);
    }

    // must import the model class to use shorthand of model class
    private static boolean check(String model, String attribute, String value)
    {
        boolean used = false;
        Session session = Persistence.getSession();

        String hql = "select " + attribute + " from " + model + " as model_name where model_name." + attribute + " = :value";
        Query query = session.createQuery(hql);
        query.setParameter("value", value);

        if(query.list().iterator().hasNext())
        {
            used = true;
        }

        session.close();

        return used;
    }
}