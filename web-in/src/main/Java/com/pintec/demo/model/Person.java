package com.pintec.demo.model;


public class Person {
    private int id;
    private String name;
    private boolean sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, sex: %s", id, name, sex ? "男" : "女");
    }
}
