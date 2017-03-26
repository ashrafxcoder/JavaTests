package com.company;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;

/**
 * Created by Ashraf-XCODER on 3/20/2017.
 */
public class Person implements Serializable, ObjectInputValidation {

    private final static long serversionUID = 9879879L;

    private String name;
    private int age;



    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.registerValidation(this, 0);
        in.defaultReadObject();
    }



    public Person(String name, int age) {
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

    @Override
    public void validateObject() throws InvalidObjectException {
        if (age < 20 || age > 60){
            throw new InvalidObjectException("age must be between 20 and 60");
        }
    }
}
