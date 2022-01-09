package com.scale.invest.api.uitl;

/**
 * @author Nicklaus
 * @description ExcelExportStatisticStyler
 * @create 2021-10-15 15:24
 * @version-1.0
 */

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelExportStatisticStyler extends ExcelExportStylerDefaultImpl {

    private CellStyle numberCellStyle;

    public ExcelExportStatisticStyler(Workbook workbook) {
        super(workbook);
        createNumberCellStyler();
    }

    private void createNumberCellStyler() {
        numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setAlignment(HorizontalAlignment.CENTER);
        numberCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 这边传的参数格式会影响你导出的数据类型
        // "0.00"是自定义类型可以与数字类型直接进行计算，并不是直接导出数字类型
        // "#,##0.00" 是货币类型 其他参数到源码查看
//        numberCellStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("0.00"));
        numberCellStyle.setWrapText(true);
    }


}

