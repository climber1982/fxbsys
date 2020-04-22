package com.fxb.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class ExportExcel {
    /**
     * 数据导入Excel
     * @param sheetName
     * @param titles
     * @param listData
     */
    public static HSSFWorkbook exportData(String sheetName, Map<String, Object> titles, List<Map<String, Object>> listData) throws IOException {
//      ====创建工作簿====
        HSSFWorkbook wb = new HSSFWorkbook();
//      ====创建工作表====
        HSSFSheet sheet = wb.createSheet(sheetName);
//      ====合并单元格====
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0 , 8));
//      ====创建单元格样式和单元格====
        HSSFCellStyle cellStyle = wb.createCellStyle();
//      ====设置内容居中====
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        int rowNum = 0; //行序号，从第0行开始
        int colNum = 0; //列序号，从第0行开始
//      ====创建工作表的行====
        HSSFRow row = sheet.createRow(rowNum);
//      ====创建单元格====
        HSSFCell cell = null;
//      ====给第一行的单元格设置titles的值====
        for (String key : titles.keySet()) {
//          ====创建一个单元格====
            cell = row.createCell(colNum);
//          ====给单元格赋值====
            cell.setCellValue(titles.get(key).toString());
//          ====设置单元格风格====
            cell.setCellStyle(cellStyle);
//          ====设置行高====
            row.setHeightInPoints(20);
//          ====换到下一个单元格（同一行的下一列）====
            colNum++;
        }

//      ====换行====
        rowNum++;
//      ====列重置为0====
        colNum = 0;

//      ====写数据，从标题的下一行开始====
        for (int i = 0; i < listData.size(); i++) {
            Map<String, Object> data = listData.get(i);
            row = sheet.createRow(rowNum);
            for (String key : titles.keySet()) {
                cell = row.createCell(colNum);
                Object value = data.get(key);
                if (value != null) {
                    cell.setCellValue(value.toString());
                } else {
                    cell.setCellValue("");
                }
//                sheet.setColumnWidth(colNum, value.toString().length() * 516);
                sheet.autoSizeColumn(colNum, true);
                cell.setCellStyle(cellStyle);
                row.setHeightInPoints(20);
                colNum++;
            }
            rowNum++;
            colNum = 0;
        }

        return wb;
    }

    /**
     * 下载Excel
     * @param response
     * @param fileName
     */
    public static void down(HttpServletResponse response, String fileName, HSSFWorkbook wb) throws IOException {
//      ===将生成的Excel以流输出====
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
//      ====将Excel的数据写入字节流中====
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);
        byte[] content = os.toByteArray();
//      ====读取流信息====
        InputStream is = new ByteArrayInputStream(content);
//      ====设置response参数，可以打开下载页面====
        response.reset();   //清空response
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + URLEncoder.encode(fileName + ".xls","utf-8"));
//      ====从response中获得字节输出流====
        ServletOutputStream out = response.getOutputStream();
//        wb.write(response.getOutputStream());

        bis = new BufferedInputStream(is);
        bos = new BufferedOutputStream(out);
//      ====创建数组长度为2048的字节数组，作为缓冲区====
        byte[] buff = new byte[2048];
        int bytesRead;

//      ====read方法：从bis输入流中将buff.length个字节数据读入buff数组中，返回读入缓冲区的字节总数，到末尾返回-1====
        while ((-1 != (bytesRead = bis.read(buff, 0, buff.length)))) {
            bos.write(buff, 0, bytesRead);
        }
        bis.close();
        bos.close();
    }

    }

