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
 * @time: 21:49:48
 * </pre>
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestFundDataSource implements Serializable {


    private static final long serialVersionUID = 339327787232064317L;

    /**
     * 字段名称：ID:PK
     * <p>
     * 数据库字段信息:id BIGINT(19)
     */
    @NotNull
    @TableId
    private Long id;

    /**
     * 字段名称：数据源url
     * <p>
     * 数据库字段信息:data_source_url VARCHAR(255)
     */
    private String dataSourceUrl;

    /**
     * 字段名称：数据源描述
     * <p>
     * 数据库字段信息:description TEXT(65535)
     */
    private String description;

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
