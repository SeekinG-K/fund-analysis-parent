package com.scale.invest.api.dto.web;

import lombok.Data;

@Data
public class Wechat {
    private Integer errcode;
    private String errmsg;
    private String type;
    private String media_id;
    private String created_at;
}
