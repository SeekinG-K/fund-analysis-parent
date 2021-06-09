package com.scale.invest.api.dto.stock;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class D1 implements Serializable {

    private static final long serialVersionUID = 8738398931883550772L;

    /**
     * 股票代码
     */
    private String f12;
    /**
     * 股票名称
     */
    private String f14;

}
