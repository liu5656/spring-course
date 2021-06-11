package org.example.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
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
@Value("erwa street")
    private String address;
    @Value("erwa university")
    private String name;
}
