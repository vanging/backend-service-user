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

    @Test
    public void emailExist() throws Exception
    {
        Assert.assertFalse(Action.isEmailExist("email"));
        Assert.assertFalse(Action.isEmailExist("email2"));
        Assert.assertFalse(Action.isEmailExist("email3"));
        Assert.assertTrue(Action.isEmailExist("email4"));
    }
}