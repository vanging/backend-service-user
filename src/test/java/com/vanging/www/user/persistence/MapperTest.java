package com.vanging.www.user.persistence;

import com.vanging.www.user.persistence.entity.Profile;
import com.vanging.www.user.persistence.mapper.ProfileMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MapperTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void profile() throws Exception
    {
        ProfileMapper profileMapper = Mapper.profile();
        Profile profile = new Profile();
        profile.setEmail("email3");
        profileMapper.addNewProfileFromEmail(profile);
    }

}