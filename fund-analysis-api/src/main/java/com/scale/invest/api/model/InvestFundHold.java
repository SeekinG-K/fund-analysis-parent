package com.scale.invest.api.model;

import java.io.Serializable;

import lombok.*;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <pre>
 * @description: 实体类
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 21:49:53
 * </pre>
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestFundHold implements Serializable {

    private static final long serialVersionUID = -3535582739351688746L;
    /**
     * 字段名称：ID:PK
     * <p>
     * 数据库字段信息:id BIGINT(19)
     */
    @NotNull(message = "ID_NULL")
    @TableId
    private Long id;

    /**
     * 字段名称：基金ID
     * <p>
     * 数据库字段信息:fund_id BIGINT(19)
     */
    private Long fundId;

    /**
     * 字段名称：证券代码
     * <p>
     * 数据库字段信息:stock_code VARCHAR(255)
     */
    private String stockCode;

    /**
     * 字段名称：持仓市值
     * <p>
     * 数据库字段信息:market_value DECIMAL(20,4)
     */
    private Double marketValue;

    /**
     * 字段名称：持仓市值占比
     * <p>
     * 数据库字段信息:market_value_ratio DECIMAL(20,4)
     */
    private Double marketValueRatio;

    /**
     * 字段名称：证券数量
     * <p>
     * 数据库字段信息:quantity DECIMAL(20,4)
     */
    private Double quantity;

    /**
     * 字段名称：证券类型 0-股票 1-债券 2-基金
     * <p>
     * 数据库字段信息:type_class INT(10)
     */
    private Long typeClass;

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
