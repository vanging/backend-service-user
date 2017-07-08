package com.vanging.www.user.persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void registerByEmail() throws Exception
    {
        Boolean result = Action.registerByEmail("email4", "password4");
        Assert.assertTrue(result);
        result = Action.registerByEmail("email4", "password4");
        Assert.assertFalse(result);
    }
}