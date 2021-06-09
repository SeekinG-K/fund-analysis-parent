/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2019 XunceTech Company                                   */
/* 深圳迅策科技有限公司版权所有                                                                                                                            */
/*                                                                        */
/* PROPRIETARY RIGHTS of XunceTech Company are involved in the            */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是深圳迅策科技有限公司的资产，任何人士阅读和                                                                    */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。                                                  */
/*                                                                        */
/**************************************************************************/
package com.scale.invest.api.model.env;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: Bean信息
 * @copyright: Copyright (c) 2019 迅策科技
 * @author: chasel
 * @version: 1.0
 * @date: 2019年7月24日
 * @time: 上午11:01:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeanInfo implements Serializable {

    private static final long serialVersionUID = 8496049375326969409L;

    /**
     * Bean对应的Class
     */
    private Class<?> beanClass;

    /**
     * Service对应的Class
     */
    private Class<?> serviceClass;
}
