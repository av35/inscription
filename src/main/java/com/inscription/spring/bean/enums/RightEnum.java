package com.inscription.spring.bean.enums;

public enum RightEnum {
    USER ("User"),
    STUDENT("Student"),
    COACH("Coach"),
    ADMINISTRATOR ("Administrator");

    private String value = "";

    RightEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return name();
    }
}
