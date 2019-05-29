package com.winnienjeri.firebasedatabaseapp;


public class Item {
    String name,email,phone,key;

    public Item(String name, String email, String phone, String key) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.key = key;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getKey() {
        return key;
    }
}
