package org.example.service.service;

import org.springframework.stereotype.Component;

public class School {
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String address;
    private String name;
}
