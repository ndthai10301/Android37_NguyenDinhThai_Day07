package com.example.btvnday07;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String note;

    public User(String name,String note) {
        this.name = name;
        this.note=note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
