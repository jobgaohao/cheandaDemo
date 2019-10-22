package com.cad.carlink.weixin.test.myStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 为什么要使用Stream
 * 1.函数式编程带来的好处尤为明显。这种代码更多地表达了业务逻辑的意图，而不是它的实现机制。易读的代码也易于维护、更可靠、更不容易出错。
 * 2.高端
 */
public class Test {

    public static void main(String[] args) {
        getUserNameList();
        //filterSexAndAge();
        //fiterSex();
    }

    /**
     * 过滤所有的男性
     * 遍历数据并检查其中的元素时使用。
     filter接受一个函数作为参数，该函数用Lambda表达式表示
     */
    public static void fiterSex(){
        List<PersonModel> data=Data.getList();
        //old
        List<PersonModel> temp=new ArrayList<>();
        for (PersonModel person:data) {
           if("男".equals(person.getSex())){
               temp.add(person);
           }
        }
        System.out.println(temp.toString());

        //new
        List<PersonModel> collect=data
                .stream()
                .filter(personModel -> "男".equals(personModel.getSex()))
                .collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    /**
     * 过滤所有的男性并且小于20岁
     */
    public static void filterSexAndAge(){
        List<PersonModel> data=Data.getList();

        //old
        List<PersonModel> temp=new ArrayList<>();
        for (PersonModel person:data) {
            if(person.getAge()<20&&"男".equals(person.getSex())){
                temp.add(person);
            }
        }
        System.out.println(temp.toString());

        //new1
        List<PersonModel> collect=data
                .stream()
                .filter(person->{
                    if("男".equals(person.getSex())&&person.getAge()<20){
                        return  true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        System.out.println(collect.toString());

        //new2
        List<PersonModel> collect1=data
                .stream()
                .filter(personModel -> ("男".equals(personModel.getSex())&&personModel.getAge()<20))
                .collect(Collectors.toList());
        System.out.println(collect1.toString());
    }

    /**
     * 获取所有的用户名字
     */
    public static void getUserNameList(){
        List<PersonModel> data=Data.getList();
        //old
        List<String> list =new ArrayList<>();
        for (PersonModel person:data) {
            list.add(person.getName());
        }
        System.out.println(list);

        //new1
        List<String> collect=data.stream().map(personModel -> personModel.getName()).collect(Collectors.toList());
        System.out.println(collect);

        //new2
        List<String> collect1=data.stream().map(PersonModel::getName).collect(Collectors.toList());
        System.out.println(collect1);

        //new3
        List<String> collect2=data.stream().map(personModel -> {
            System.out.println(personModel.getName());
            return personModel.getName();
        }).collect(Collectors.toList());

        List<String> collect3 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(Collectors.toList());
        System.out.println(collect3);
    }
}
