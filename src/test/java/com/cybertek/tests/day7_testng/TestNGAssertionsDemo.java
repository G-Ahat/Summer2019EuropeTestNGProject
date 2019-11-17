package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("first Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assetion");
        Assert.assertEquals("title","titlE");

        System.out.println("after second assertion");
    }
    @Test
    public void test2(){
        //verify that title starts with C
        String actualTitle="Cybertek";
        String expectedTitleBegin="C";

        System.out.println("first assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitleBegin),"verrify title starts with C");

        //Task//verify that email includes @ sign
        Assert.assertTrue("yasin@mail".contains("@"),"Verify @ in the email");
    }

    @Test
    public void test3(){
        Assert.assertNotEquals("one","two");
    }
    @Test
    public void test4(){
        Assert.assertFalse(1<0);
    }


}
