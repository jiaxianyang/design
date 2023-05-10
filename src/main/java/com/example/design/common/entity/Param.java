package com.example.design.common.entity;

import lombok.Data;

import java.util.List;

@Data
public class Param {
    private String warehouseNo;
    private List<String> shipmentOrderNoList;
}
