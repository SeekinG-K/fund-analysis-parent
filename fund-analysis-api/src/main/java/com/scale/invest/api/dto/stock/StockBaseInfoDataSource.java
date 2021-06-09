package com.scale.invest.api.dto.stock;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StockBaseInfoDataSource implements Serializable {
    private static final long serialVersionUID = -1682779186808873425L;
    private BigDecimal rc;
    private BigDecimal rt;
    private BigDecimal svr;
    private BigDecimal lt;
    private BigDecimal full;
    private D0 data;
}

