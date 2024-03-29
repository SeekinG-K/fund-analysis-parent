package com.scale.invest.api.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * @description: 实体类
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 17:22:49
 * </pre>
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestFundMain implements Serializable {

    private static final long serialVersionUID = -4823743813047258648L;
    /**
     * 字段名称：ID:PK
     * <p>
     * 数据库字段信息:id BIGINT(19)
     */
    @NotNull(message = "ID_NULL")
    @TableId
    private Long id;

    /**
     * 字段名称：基金代码
     * <p>
     * 数据库字段信息:fund_code VARCHAR(255)
     */
    @NotNull(message = "FUND_CODE_NULL")
    private String fundCode;

    /**
     * 字段名称：基金名称
     * <p>
     * 数据库字段信息:fund_name VARCHAR(255)
     */
    @NotNull(message = "FUND_NAME_NULL")
    private String fundName;

    /**
     * 字段名称：基金经理
     * <p>
     * 数据库字段信息:manager_name VARCHAR(255)
     */
    private String managerName;

    /**
     * 字段名称：创建时间
     * <p>
     * 数据库字段信息:create_time TIMESTAMP(19)
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    /**
     * 字段名称：更新时间
     * <p>
     * 数据库字段信息:update_time TIMESTAMP(19)
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

}
