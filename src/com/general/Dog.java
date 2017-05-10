package com.general;

/**
 * Created by Ashraf-XCODER on 5/10/2017.
 */
public class Dog extends Animal implements Barkable {

    @Override
    public void bark(String sound) {
        System.out.println(sound);
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("RUN RUN!!!");
    }
}
