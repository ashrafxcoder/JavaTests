package com.general;

/**
 * Created by Ashraf-XCODER on 5/11/2017.
 */


//Not thread safe
public class Singleton {

    private Singleton() {}

    private static Singleton instance;


    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }




}
