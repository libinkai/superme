package com.equator.lambda;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/19 8:01
 **/

public class FinnalTest {
    public static void main(String[] args) {
        // 内部类不可修改外部变量
        final String birthday = "1998-07-07";
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("leo","1988-07-07"));
        personList.add(new Person("equator","2008-07-07"));
        personList.add(new Person("libinkai","2018-07-07"));
        personList.forEach(person -> {
            System.out.println(person.getName());
        });
    }
}
