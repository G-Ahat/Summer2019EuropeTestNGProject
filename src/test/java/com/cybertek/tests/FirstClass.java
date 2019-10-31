package com.cybertek.tests;

import com.github.javafaker.Faker;

import java.time.Clock;

public class FirstClass {
    public static void main(String[] args){
        System.out.println("Hello World");


        Faker faker= new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.address().country());
    }



}
