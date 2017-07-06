package com.vanging.www.user.persistence;

import com.vanging.www.user.persistence.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class Mapper
{
    public static ProfileMapper user()
    {
        SqlSession sqlSession = Persistence.getSqlSession();
        return sqlSession.getMapper(ProfileMapper.class);
    }
}
