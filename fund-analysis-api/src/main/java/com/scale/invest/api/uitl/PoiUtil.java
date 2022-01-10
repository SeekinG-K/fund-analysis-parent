package com.scale.invest.api.uitl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static cn.hutool.core.util.ZipUtil.getStream;
import static cn.hutool.core.util.ZipUtil.zip;

/**
 * @version 1.0
 * @author: Jason
 * <p>Copyright: Copyright (c) 2020</p>
 * @date: 2020/4/13 10:51
 * @description:
 */
public class PoiUtil {

    public static List<String> greenColor = new LinkedList<>();
    public static List<String> redColor = new LinkedList<>();

    static {
        String[] a = {"#008000",
                "#058305",
                "#0a850a",
                "#108810",
                "#158a15",
                "#1a8d1a",
                "#1f901f",
                "#249224",
                "#2a952a",
                "#2f972f",
                "#349a34",
                "#399d39",
                "#3e9f3e",
                "#44a244",
                "#49a449",
                "#4ea74e",
                "#53a953",
                "#58ac58",
                "#5eaf5e",
                "#63b163",
                "#68b468",
                "#6db66d",
                "#72b972",
                "#78bc78",
                "#7dbe7d",
                "#82c182",
                "#87c387",
                "#8dc68d",
                "#92c992",
                "#97cb97",
                "#9cce9c",
                "#a1d0a1",
                "#a7d3a7",
                "#acd6ac",
                "#b1d8b1",
                "#b6dbb6",
                "#bbddbb",
                "#c1e0c1",
                "#c6e2c6",
                "#cbe5cb",
                "#d0e8d0",
                "#d5ead5",
                "#dbeddb",
                "#e0efe0",
                "#e5f2e5",
                "#eaf5ea",
                "#eff7ef",
                "#f5faf5",
                "#fafcfa",
                "#ffffff"};
        String[] redColorArrays = {
                "#ff0000",
                "#ff0505",
                "#ff0a0a",
                "#ff1010",
                "#ff1515",
                "#ff1a1a",
                "#ff1f1f",
                "#ff2424",
                "#ff2a2a",
                "#ff2f2f",
                "#ff3434",
                "#ff3939",
                "#ff3e3e",
                "#ff4444",
                "#ff4949",
                "#ff4e4e",
                "#ff5353",
                "#ff5858",
                "#ff5e5e",
                "#ff6363",
                "#ff6868",
                "#ff6d6d",
                "#ff7272",
                "#ff7878",
                "#ff7d7d",
                "#ff8282",
                "#ff8787",
                "#ff8d8d",
                "#ff9292",
                "#ff9797",
                "#ff9c9c",
                "#ffa1a1",
                "#ffa7a7",
                "#ffacac",
                "#ffb1b1",
                "#ffb6b6",
                "#ffbbbb",
                "#ffc1c1",
                "#ffc6c6",
                "#ffcbcb",
                "#ffd0d0",
                "#ffd5d5",
                "#ffdbdb",
                "#ffe0e0",
                "#ffe5e5",
                "#ffeaea",
                "#ffefef",
                "#fff5f5",
                "#fffafa",
                "#ffffff"};
        greenColor.addAll(Arrays.asList(a));
        redColor.addAll(Arrays.asList(redColorArrays));
        Collections.reverse(redColor);
        Collections.reverse(greenColor);
    }

    public static void exportExcelWithFilePath(List<?> list, String title, String sheetName, Class<?> pojoClass, String filePath) {
        ExcelType excelType = ExcelType.HSSF;
        if (!StringUtils.isEmpty(filePath) && filePath.endsWith(".xlsx")) {
            excelType = ExcelType.XSSF;
        }
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setType(excelType);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,
                                   String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    public static byte[] exportExcel(List<ExcelExportEntity> colList, List<?> list, String title, String sheetName, String fileName, HttpServletResponse response) {
        return defaultExport(colList, list, fileName, response, new ExportParams(title, sheetName));
    }

    /**
     * 得到RBG自定义颜色
     *
     * @param redNum   红色数值
     * @param greenNum 绿色数值
     * @param blueNum  蓝色数值
     * @return
     */
    public static XSSFColor getRGBColor(int redNum, int greenNum, int blueNum) {
        return new XSSFColor(new byte[]{(byte) redNum, (byte) greenNum, (byte) blueNum}, new DefaultIndexedColorMap());
    }

    /**
     * 根据单元格的格式 获取单元格的内容
     *
     * @param cell
     * @return
     */
    private static String getXCellVal(Cell cell) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("0.0000");
        String val = "";
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    val = fmt.format(cell.getDateCellValue()); //日期型
                } else {
                    val = df.format(cell.getNumericCellValue()); //数字型
                    // 去掉多余的0，如最后一位是.则去掉
                    val = val.replaceAll("0+?$", "").replaceAll("[.]$", "");
                }
                break;
            case STRING: //文本类型
                val = cell.getStringCellValue();
                break;
            case BOOLEAN: //布尔型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK: //空白
                val = cell.getStringCellValue();
                break;
            case ERROR: //错误
                val = "";
                break;
            case FORMULA: //公式
                try {
                    val = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    val = String.valueOf(cell.getNumericCellValue());
                }
                break;
            default:
                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
        }
        return val;
    }

    private static byte[] defaultExport(List<ExcelExportEntity> colList, List<?> list, String fileName, HttpServletResponse response, ExportParams exportParams) {
        ExcelType excelType = ExcelType.HSSF;
        if (fileName != null && fileName.endsWith(".xlsx")) {
            excelType = ExcelType.XSSF;
        }

        exportParams.setStyle(ExcelExportStylerDefaultImpl.class);
        exportParams.setType(excelType);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, colList, list);
        final Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        int firstRowNum = sheet.getFirstRowNum();
        int size = lastRowNum - firstRowNum;
        for (int i = 0; i < size + 1; i++) {
            final Row row = sheet.getRow(i);
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            int cellSize = lastCellNum - firstCellNum;
            for (int j = 0; j < cellSize; j++) {
                Cell cell = row.getCell(j);
                String stringCellValue = getXCellVal(cell);
                if (j >= 2 && i != 0) {
                    XSSFCellStyle cs = (XSSFCellStyle) workbook.createCellStyle();
                    cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cs.setAlignment(HorizontalAlignment.CENTER);
                    cs.setVerticalAlignment(VerticalAlignment.CENTER);
                    cs.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    cs.setWrapText(true);
                    if (!StringUtils.isEmpty(stringCellValue)) {
                        BigDecimal bigDecimal = new BigDecimal(stringCellValue);
                        BigDecimal bigDecimal1 = bigDecimal.setScale(1, BigDecimal.ROUND_UP);
                        BigDecimal bigDecimal2 = (bigDecimal1.multiply(new BigDecimal(10))).stripTrailingZeros();
                        List<String> colorList = bigDecimal2.compareTo(BigDecimal.ZERO) < 0 ? greenColor : redColor;
                        String s = bigDecimal2.abs().toPlainString();
                        Integer integer = Integer.valueOf(s);
                        int index = integer > 50 ? 50 : integer;
                        String color = colorList.get(index - 1);
                        XSSFColor xssfColor = new XSSFColor(Color.decode(color), new DefaultIndexedColorMap());
                        cs.setFillBackgroundColor(xssfColor);
                        cs.setFillForegroundColor(xssfColor);
                        cell.setCellValue(stringCellValue + "%");
                    }
                    cell.setCellStyle(cs);
                }
            }
        }
        if (Objects.nonNull(workbook)) {
            downLoadExcel(fileName, response, workbook);
//            return sendStream(workbook);
        }
        return null;
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        ExcelType excelType = ExcelType.HSSF;
        if (fileName != null && fileName.endsWith(".xlsx")) {
            excelType = ExcelType.XSSF;
        }

        exportParams.setStyle(ExcelExportStatisticStyler.class);
        exportParams.setType(excelType);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
//        CellStyle cs = workbook.createCellStyle();
        final Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        int firstRowNum = sheet.getFirstRowNum();
        int size = lastRowNum - firstRowNum;
        for (int i = 0; i < size; i++) {
            final Row row = sheet.getRow(i);
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            int cellSize = lastCellNum - firstCellNum;
            for (int j = 0; j < cellSize; j++) {
                Cell cell = row.getCell(j);
                if (j == 2) {
                    CellStyle cs = workbook.createCellStyle();
                    cs.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
                    cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                    cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell.setCellStyle(cs);
                    cell.setCellValue("sss");
                }

            }
        }
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) {
            downLoadExcel(fileName, response, workbook);
        }
    }

    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            //设置浏览器响应头对应的Content-disposition
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/msexcel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 打压缩包
     *
     * @param in                        要打包的文件流
     * @param fileName                  要打包的文件名
     */
    public static ByteArrayOutputStream zip(InputStream in, String fileName) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ZipOutputStream zipOut = new ZipOutputStream(out)) {
            zipOut.putNextEntry(new ZipEntry(fileName));
            IOUtils.copy(in, zipOut);
        } catch (IOException e) {
            throw new RuntimeException("打包异常: " + e.getMessage());
        }
        return out;
    }

    public static byte[] sendStream(Workbook workbook) {
        // 字节缓冲区, 是内存读写流, 不同于指向硬盘的流, 字节数组是成员变量, 当数组不再使用的时候, GC会自动回收, 不用手动关闭流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
            // 打压缩包
            out = zip(new ByteArrayInputStream(out.toByteArray()), "test.xlsx");
            return out.toByteArray();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            headers.setContentDispositionFormData("attachment", URLEncoder.encode("导出文件.xlsx", "utf-8"));
//            return new ResponseEntity<>(, headers, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException("临时文件写入失败");
        }
    }

    public static void downLoadExcel(InputStream inputStream, HttpServletResponse response, String fileName) {
        try {
            ServletOutputStream out;
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/msexcel");
            out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            while ((b = inputStream.read(buffer)) != -1) {
                // 4.写到输出流(out)中
                out.write(buffer, 0, b);
            }
            inputStream.close();
            if (out != null) {
                out.flush();
                out.close();
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> List<T> importExcel(String filePath, Integer sheetNo, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isEmpty(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setStartSheetIndex(sheetNo);
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer sheetNo, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setStartSheetIndex(sheetNo);
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * method description: poi解析EXCEL为对象列表
     *
     * @param file
     * @param sheetNo
     * @param titleRows
     * @param headerRows
     * @param pojoClass
     * @return java.util.List
     * @author Jason
     * @date 2021/3/31
     */
    public static <T> List<T> importExcelByColNumber(MultipartFile file, Integer sheetNo, Integer titleRows, Integer headerRows,
                                                     Class<T> pojoClass, Map<String, Integer> cells) {
        if (file == null) {
            return null;
        }
        List<T> list = new ArrayList<>();

        Workbook wb;
        try {
            wb = WorkbookFactory.create(file.getInputStream());

            if (wb == null) {
                return null;
            }
            Sheet sheet = wb.getSheetAt(sheetNo);
            int rowCount = sheet.getLastRowNum();
            if (rowCount >= titleRows + headerRows) {
                Row row;
                for (int i = titleRows + headerRows; i <= rowCount; i++) {
                    row = sheet.getRow(i);
                    T obj = pojoClass.newInstance();
                    for (String key : cells.keySet()) {
                        String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                        Cell cell = row.getCell(cells.get(key));
                        Method method = pojoClass.getDeclaredMethod(methodName, pojoClass.getDeclaredField(key).getType());
                        method.invoke(obj, getCellValue(cell));
                    }
                    list.add(obj);
                }
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("文件解析失败：" + e.getMessage());
        } catch (NoSuchFieldException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getCellValue(Cell cell) {
        if (cell != null) {
            Object val;
            switch (cell.getCellType()) {
                case NUMERIC:
                    val = BigDecimal.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    val = cell.getStringCellValue();
                    if (Pattern.matches("^\\d{4}(-\\d{2}){2}$", cell.getStringCellValue())) {
                        val = cell.getStringCellValue().replaceAll("-", "");
                    } else if (Pattern.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$", cell.getStringCellValue().replaceAll(",", ""))) {
                        val = cell.getStringCellValue().replaceAll(",", "");
                    }
                    break;
                case BOOLEAN:
                    val = cell.getBooleanCellValue();
                    break;
                default:
                    val = cell.getStringCellValue();
            }
            return val == null ? "" : val.toString();
        }
        return null;
    }

    public static Workbook export(List<?> list, String title, String sheetName, Class<?> pojoClass,
                                  String fileName, boolean isCreateHeader) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        ExcelType excelType = ExcelType.HSSF;
        if (fileName != null && fileName.endsWith(".xlsx")) {
            excelType = ExcelType.XSSF;

        }
        exportParams.setType(excelType);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        return workbook;
    }

    public static void selectList(Workbook workbook, int firstRow, int lastRow, int firstCol, int lastCol, String[] dataArray,
                                  ExcelType excelType) {
        Sheet sheet = workbook.getSheetAt(0);
        //加载数据,将名称为hidden的
        if (excelType == ExcelType.HSSF) {
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(2, 65535, firstCol, lastCol);
            //  生成下拉框内容
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(dataArray);
            HSSFDataValidation dataValidation = new HSSFDataValidation(cellRangeAddressList, dvConstraint);
            //  对sheet页生效
            sheet.addValidationData(dataValidation);
        } else if (excelType == ExcelType.XSSF) {
            XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
            XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                    .createExplicitListConstraint(dataArray);
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, 65535, firstCol, lastCol);
            XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
            // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
            if (null != validation) {
                sheet.addValidationData(validation);
            }
        }

    }


}
