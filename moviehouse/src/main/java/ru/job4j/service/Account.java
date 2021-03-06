package ru.job4j.service;

public class Account {
    private String name;
    private int phone;

    public Account(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
