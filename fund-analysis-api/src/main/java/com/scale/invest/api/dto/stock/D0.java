package com.scale.invest.api.dto.stock;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class D0 implements Serializable {
    private static final long serialVersionUID = -1559203915055949275L;

    private Integer total;
    private List<D1> diff;
}
