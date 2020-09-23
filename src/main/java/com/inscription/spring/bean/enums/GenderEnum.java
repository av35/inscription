package com.inscription.spring.bean.enums;

public enum GenderEnum {
    Male ("M"),
    Female ("F");

    private String name = "";

    GenderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
