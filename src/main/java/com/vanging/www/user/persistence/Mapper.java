package com.vanging.www.user.persistence;

import com.vanging.www.user.persistence.mapper.AuthMapper;
import com.vanging.www.user.persistence.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class Mapper
{
    public static ProfileMapper profile()
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        return sqlSession.getMapper(ProfileMapper.class);
    }

    public static AuthMapper auth()
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        return sqlSession.getMapper(AuthMapper.class);
    }
}
