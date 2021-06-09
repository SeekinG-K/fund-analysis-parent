package com.scale.invest.api.model;

import java.io.Serializable;
import lombok.*;
import javax.validation.constraints.NotNull;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
/**
 * <pre>
 * @description: 实体类
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 21:49:57
 * </pre>
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestStockMain implements Serializable {


    private static final long serialVersionUID = -5502093864269520638L;
    /**
     * 字段名称：ID:PK
     * <p>
     * 数据库字段信息:id BIGINT(19)
     */
    @NotNull(message = "ID_NULL")
    @TableId
    private Long id;

    /**
     * 字段名称：股票代码
     * <p>
     * 数据库字段信息:stock_code VARCHAR(255)
     */
    private String stockCode;

    /**
     * 字段名称：股票名称
     * <p>
     * 数据库字段信息:stock_name VARCHAR(255)
     */
    private String stockName;

    /**
     * 字段名称：创建时间
     * <p>
     * 数据库字段信息:create_time TIMESTAMP(19)
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 字段名称：更新时间
     * <p>
     * 数据库字段信息:update_time TIMESTAMP(19)
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    /**
     * 字段名称：股票发行地  0-上证 1-沪深 2-深证
     * <p>
     * 数据库字段信息:stockType INT(20)
     */
    private Integer stockType;

}
