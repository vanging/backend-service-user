package com.vanging.www.user.persistence;

public class Action
{
//    static void register(String email, String password)
//    {
//        Session session = Persistence.getSession();
//        Transaction transaction = session.getTransaction();
//        transaction.begin();
//
//        try
//        {
//            // set auth
//            Auth auth = new Auth();
//            auth.setPassword(password);
//
//            session.save(auth);
//
//            // set profile
//            Profile profile = new Profile();
//            profile.setVerified(false);
//            profile.setEmail(email);
//            profile.setUid(auth.getUid());
//
//            session.save(profile);
//
//            transaction.commit();
//        }
//        catch (Exception e)
//        {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//
//        session.close();
//    }
}
