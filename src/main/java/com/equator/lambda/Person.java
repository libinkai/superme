package com.equator.lambda;

/**
 * @Author: Equator
 * @Date: 2020/2/19 8:02
 **/

public class Person {
    private String name;
    private String birthday;

    public Person() {
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
