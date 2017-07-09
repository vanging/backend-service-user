package com.vanging.www.user.persistence.mapper;

import com.vanging.www.user.persistence.Persistence;
import com.vanging.www.user.persistence.entity.Auth;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthMapperTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addAuth() throws Exception
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);

        Auth auth = new Auth();
        auth.setUid("uid");
        auth.setPassword("password");

        authMapper.addAuth(auth);
        sqlSession.commit();
    }

    @Test
    public void getPasswordFromUid() throws Exception
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);

        Assert.assertEquals(authMapper.getPasswordFromUid("uid"),"password");
    }

}