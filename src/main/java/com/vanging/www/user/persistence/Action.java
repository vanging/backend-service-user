package com.vanging.www.user.persistence;

import com.vanging.www.user.cache.Action.LoginSession;
import com.vanging.www.user.persistence.entity.Auth;
import com.vanging.www.user.persistence.entity.Profile;
import com.vanging.www.user.persistence.mapper.AuthMapper;
import com.vanging.www.user.persistence.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class Action
{
    public static boolean registerByEmail(String email, String password)
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);

        Profile profile = new Profile();
        profile.setEmail(email);
        Auth auth = new Auth();
        auth.setPassword(password);

        try
        {
            profileMapper.addNewProfileFromEmail(profile);
            System.out.println(profile.getUid());
            auth.setUid(profile.getUid());
            authMapper.addAuth(auth);
            sqlSession.commit();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            sqlSession.rollback();
            return false;
        }
    }

    public static boolean isEmailExist(String email)
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);

        String emailResult = profileMapper.getUidFromEmail(email);

        sqlSession.close();
        return emailResult != null;
    }

    public static boolean isUsernameExist(String username)
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);

        String usernameResult = profileMapper.getUidFromUsername(username);

        sqlSession.close();
        return usernameResult != null;
    }

    public static String login(String account, String password)
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);

        String uid = profileMapper.getUidFromEmail(account);
        if(uid == null)
        {
            uid = profileMapper.getUidFromUsername(account);
            if(uid == null)
            {
                return "account_not_exist";
            }
        }
        if(authMapper.getPasswordFromUid(uid).equals(password))
        {
            return LoginSession.getSessionFromUid(uid);
        }
        else
        {
            return "password_not_match";
        }
    }
}
