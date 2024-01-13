package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;
}
