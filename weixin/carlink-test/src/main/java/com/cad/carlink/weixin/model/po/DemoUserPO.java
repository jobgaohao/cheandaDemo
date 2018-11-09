package com.cad.carlink.weixin.model.po;

import com.cad.carlink.common.base.BasePojo;
import com.cad.carlink.common.enums.EGendar;

import java.math.BigDecimal;

public class DemoUserPO extends BasePojo {
    /**
     * 主键
     *
     * @mbggenerated Thu Aug 24 17:29:07 CST 2017
     */
    private String id;

    /**
     * 姓名
     *
     * @mbggenerated Thu Aug 24 17:29:07 CST 2017
     */
    private String name;

    /**
     * 年龄
     *
     * @mbggenerated Thu Aug 24 17:29:07 CST 2017
     */
    private Integer age;

    /**
     * 性别
     *
     * @mbggenerated Thu Aug 24 17:29:07 CST 2017
     */
    private EGendar gendar;

    /**
     * 薪资
     *
     * @mbggenerated Thu Aug 24 17:29:07 CST 2017
     */
    private BigDecimal salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EGendar getGendar() {
        return gendar;
    }

    public void setGendar(EGendar gendar) {
        this.gendar = gendar;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}