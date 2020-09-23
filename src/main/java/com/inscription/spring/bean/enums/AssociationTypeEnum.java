package com.inscription.spring.bean.enums;

public enum AssociationTypeEnum {
    SPORT ("Sport"),
    MUSIC ("Music");

    private String name = "";

    AssociationTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
