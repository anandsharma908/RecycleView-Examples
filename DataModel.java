package com.example.muneeb.recyclerviewdemo;

/**
 * Created by Muneeb on 8/16/2016.
 */

public class DataModel {

    private String name;
    private Integer contact;

    public DataModel(String _name, int _contact) {
        this.name = _name;
        this.contact = _contact;
    }

    public String getName() {
        return name;
    }
    public Integer getContact() {
        return contact;
    }

}
