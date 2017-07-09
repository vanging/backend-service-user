package com.vanging.www.user.persistence;

import com.vanging.www.user.persistence.entity.Auth;
import com.vanging.www.user.persistence.entity.Profile;
import com.vanging.www.user.persistence.mapper.AuthMapper;
import com.vanging.www.user.persistence.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class Action
{
    static boolean registerByEmail(String email, String password)
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

    static boolean isEmailExist(String email)
    {
        ProfileMapper profileMapper = Mapper.getProfileMapper();
        String emailResult = profileMapper.getUidFromEmail(email);
        return emailResult != null;
    }

    static String login(String account, String password)
    {
        ProfileMapper profileMapper = Mapper.getProfileMapper();

        String uid = profileMapper.getUidFromEmail(account);
        if(uid == null)
        {

        }
        return "";
    }
}
