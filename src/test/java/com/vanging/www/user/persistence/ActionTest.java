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
    public void isEmailExist() throws Exception
    {
        Assert.assertFalse(Action.isEmailExist("email"));
        Assert.assertFalse(Action.isEmailExist("email2"));
        Assert.assertFalse(Action.isEmailExist("email3"));
        Assert.assertTrue(Action.isEmailExist("email4"));
    }

    @Test
    public void login() throws Exception
    {
        Assert.assertEquals(Action.login("account_not_exist", "password"), "account_not_exist");
        Assert.assertEquals(Action.login("email", "password_wrong"), "password_not_match");
    }

    @Test
    public void isUsernameExist() throws Exception
    {
        Assert.assertFalse(Action.isUsernameExist(""));
    }
}