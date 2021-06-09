package com.scale.invest.api.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Type;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestMessageTemplate<T> implements Serializable {
    private static final long serialVersionUID = 2357175713924346776L;
    private T messageInfo;
    private Class<T> dataType;
}
