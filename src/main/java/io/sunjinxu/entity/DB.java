package io.sunjinxu.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DB {
    private static LinkedHashMap<String, Book> linkedHashMap = new LinkedHashMap();

    private static List<User> userList = new ArrayList<>();

    static {
        linkedHashMap.put("1", new Book("1", "JavaWeb", "SUN"));
        linkedHashMap.put("2", new Book("2", "Java", "JIN"));
        linkedHashMap.put("3", new Book("3", "Oracle", "Xu"));
        linkedHashMap.put("4", new Book("4", "MySQL", "Jesse"));
    }

    static {
        userList.add(new User("SunJinxu", "123456"));
    }

    public static LinkedHashMap<String, Book> getAll() {
        return linkedHashMap;
    }

    public static List<User> getUserList() {
        return userList;
    }
}
