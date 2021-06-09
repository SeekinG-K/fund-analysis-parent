package com.scale.invest.api.dto.socket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocketStoreInfoDTO implements Serializable {
    private static final long serialVersionUID = -4619977106106331390L;
    private String userId;
    private String ip;
    private String port;
    private Date connectTime;
}
