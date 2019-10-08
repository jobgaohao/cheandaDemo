package com.cad.carlink.weixin.test.listDemo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class ListTest {


    public static void main(String[] args) {
        removeListTheSame2();
    }

    /**
     * 去掉list的重复内容(值类型)
     */
    public static void removeListTheSame(){
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(11);
        System.out.println(list);

        Set set=new HashSet();
        set.addAll(list);
        List newList=new ArrayList();
        newList.add(set);
        System.out.println(newList);

    }


    /**
     * 去掉list的重复内容（引用类型）
     * 要重写对象的 equals()，hashCode()
     */
    public static void removeListTheSame1(){
       List<People> peopleList=new ArrayList<>();
       peopleList.add(new People("张三","111111"));
       peopleList.add(new People("李四","222222"));
       peopleList.add(new People("张三","111111"));

       Set<People> setData=new HashSet<People>();
       setData.addAll(peopleList);
       System.out.println("list"+peopleList.toString());
       System.out.println("set"+setData.toString());
    }


    /**
     * 去掉list的重复内容
     */
    public static void removeListTheSame2(){
        List<Student> peopleList=new ArrayList<>();
        peopleList.add(new Student("张三","111111"));
        peopleList.add(new Student("李四","222222"));
        peopleList.add(new Student("张三","111111"));

        //根据name,age属性去重
        List<Student> unique2 = peopleList.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(o -> o.getName() + ";" + o.getPhoneNumber()))), ArrayList::new)
        );
        System.out.println("unique2"+unique2.toString());
    }
}
