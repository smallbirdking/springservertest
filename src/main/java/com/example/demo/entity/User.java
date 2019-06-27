package com.example.demo.entity;


import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User  implements Serializable {

    @Id
    private String  id;

    private String name;

    private String prename;

    public User(String id, String name, String prename) {
        this.id = id;
        this.name = name;
        this.prename = prename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }
}
