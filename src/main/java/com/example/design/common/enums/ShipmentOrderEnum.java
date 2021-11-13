package com.example.design.common.enums;

public enum ShipmentOrderEnum {


    /**
     * 单据详情id
     */
    ID(1, "id");

    private int code;
    private String desc;

    ShipmentOrderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
