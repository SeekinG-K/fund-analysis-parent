//package com.scale.invest.api;
//
//import lombok.Getter;
//
//import java.math.BigDecimal;
//import java.util.stream.Stream;
//
///*
// * @description o3执行状态枚举
// * @author bo.yan
// * @date 16:33 2021-11-30
// */
//public enum O3ExecuteStatusEnum {
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    GREEN_01_(new BigDecimal("0.1"),)
//    NOT_EXECUTE("0", "未执行"),
//    EXECUTED("1", "已执行"),
//    BACK("2", "执行回溯");
//
//    @Getter
//    private final String code;
//    @Getter
//    private final String name;
//
//    O3ExecuteStatusEnum(String code, String name) {
//        this.code = code;
//        this.name = name;
//    }
//
//    public static O3ExecuteStatusEnum getO3ExecuteStatusEnumByCode(String code) {
//        return Stream.of(values())
//                .filter(e -> e.code.equals(code))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("无法识别的O3执行状态枚举值"));
//    }
//
//
//}
