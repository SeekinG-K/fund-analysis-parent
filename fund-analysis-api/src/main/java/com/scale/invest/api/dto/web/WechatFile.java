package com.scale.invest.api.dto.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatFile {
    private String msgtype;
    private WechatMedia file;
}
