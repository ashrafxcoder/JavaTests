package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectInput objectInput;
        ObjectOutput objectOutput;

        Employee sec = new Employee("ashraf", 25);
        Manager m = new Manager("shafiq", 22);
        //m.setSecretory(sec);

        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        ous.writeObject(sec);
        ous.writeObject(m);
//
//        //ous.writeObject(sec);
//        //ous.writeObject(m);
//        Person p1 = new Person("shafiq", 12);
//        ous.writeObject(p1);
//        ous.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
        Person person = (Person) ois.readObject();
        System.out.println(person.getName() + " " + person.getAge());


    }

}
