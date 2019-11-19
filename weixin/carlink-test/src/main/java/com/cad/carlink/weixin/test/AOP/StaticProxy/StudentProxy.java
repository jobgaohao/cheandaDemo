package com.cad.carlink.weixin.test.AOP.StaticProxy;

public class StudentProxy implements Person {

    Student student;

    public  StudentProxy(Person stu){
        if(stu.getClass()==Student.class){
            this.student=(Student)stu;
        }
    }

    @Override
    public void giveTask() {
        student.giveTask();
    }
}
