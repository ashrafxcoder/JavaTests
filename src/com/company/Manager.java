package com.company;

import java.io.Serializable;

/**
 * Created by Ashraf-XCODER on 3/20/2017.
 */
public class Manager implements Serializable {


    private Employee sec;



    private final static long serversionUID = 9879879L;

    private String name;
    private int age;




    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
