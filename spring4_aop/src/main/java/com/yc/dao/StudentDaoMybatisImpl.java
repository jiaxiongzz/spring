package com.yc.dao;

import java.util.Random;

public class StudentDaoMybatisImpl implements StudentDao{
    @Override
    public int add(String name) {
        System.out.println("mybatis添加学生：" + name);
        Random r = new Random();
        return r.nextInt();
    }

    @Override
    public String find(String name) {
        System.out.println("mybatis查找:"+name);
        return name;
    }

    @Override
    public void update(String name) {
        System.out.println("mybatis更新学生：" + name);
    }
}
