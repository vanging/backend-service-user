package com.vanging.www.user.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void email() throws Exception
    {
        Assert.assertTrue(Validator.email("a@b.cc"));
        Assert.assertTrue(Validator.email("a@0.cc"));
        Assert.assertTrue(Validator.email("a.b@b.cc"));
        Assert.assertTrue(Validator.email("aaa@b.cc"));
        Assert.assertTrue(Validator.email("aaaaa.bbbb@b.cc"));
        Assert.assertTrue(Validator.email("a.bbb@b.cc"));
        Assert.assertTrue(Validator.email("aaaa.b@b.cc"));
        Assert.assertTrue(Validator.email("aa-aa.b@b.cc"));
        Assert.assertTrue(Validator.email("aa_aa.b@b.cc"));
        Assert.assertTrue(Validator.email("aaaa.b-b@bbb.cc"));
        Assert.assertFalse(Validator.email("abc"));
        Assert.assertFalse(Validator.email("ab.c"));
        Assert.assertFalse(Validator.email("a@bc"));
        Assert.assertFalse(Validator.email("-a@bc"));
        Assert.assertFalse(Validator.email("-a@b.c"));
        Assert.assertFalse(Validator.email("-a.b.c"));
        Assert.assertFalse(Validator.email("-a.@b.c"));
        Assert.assertFalse(Validator.email("-a-@b.c"));
        Assert.assertFalse(Validator.email("-a.-@b.c"));
        Assert.assertFalse(Validator.email("-a-.@b.c"));
        Assert.assertFalse(Validator.email("a__b@b.c"));
        Assert.assertFalse(Validator.email("a--b@b.c"));
    }

}