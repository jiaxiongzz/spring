package com.yc.dao;



import org.springframework.stereotype.Repository;

import java.util.Random;
@Repository
public class StudentDaoImpl implements StudentDao{
    @Override
    public int add(String name) {

            System.out.println("jpa 添加学生："+name);
            Random r=new Random();
            return r.nextInt();

    }

    @Override
    public String find(String name) {
        System.out.println("jpa查找:"+name);
        return name;
    }

    @Override
    public void update(String name) {
        System.out.println("jpa 更新学生："+name);
    }
}
