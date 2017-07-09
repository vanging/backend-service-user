package com.vanging.www.user.persistence.mapper;

import com.vanging.www.user.persistence.Persistence;
import com.vanging.www.user.persistence.entity.Profile;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileMapperTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addNewProfileFromEmail() throws Exception
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);

        Profile profile = new Profile();
        profile.setEmail("电子邮件地址");

        profileMapper.addNewProfileFromEmail(profile);
        sqlSession.commit();
    }

    @Test
    public void getUidFromEmail() throws Exception
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
        String uid = profileMapper.getUidFromEmail("电子邮件地址");
        System.out.println(uid);
    }

    @Test
    public void getUidFromUsername() throws Exception
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
        String uid = profileMapper.getUidFromUsername("username");
        System.out.println(uid);
    }
}