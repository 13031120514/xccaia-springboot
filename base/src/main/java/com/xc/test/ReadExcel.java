//package com.xc.test;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//
//public class ReadExcel {
//
//    public static void main(String[] args) throws Exception {
//        testXlsx();
//    }
//
//    public static void testXlsx() throws Exception {
//        File file = new File("C:\\Users\\EDZ\\Desktop\\aa\\" +
//                "8-1.供应商生产试验数据采集表-中压电缆-20200906-v2.1 - 副本" +
//                ".xlsx");
//        System.out.println(file.exists());
//
//        InputStream stream = null;
//        Workbook xssfWorkbook = null;
//        String type = "";
//        String infocode = "";
//        String paramcode = "";
//        //获取输入流
//        try {
//            stream = new FileInputStream(file);
//            xssfWorkbook = new XSSFWorkbook(stream);
//            Sheet Sheet = xssfWorkbook.getSheetAt(0);
//            int rowNum = Sheet.getLastRowNum();
//            for (int i = 0; i <= rowNum; i++) {
//                Row row = Sheet.getRow(i);
//                type = "".equals(row.getCell(1).getStringCellValue()) ? type : row.getCell(1).getStringCellValue();
//                infocode = "".equals(row.getCell(2).getStringCellValue()) ? infocode : row.getCell(2).getStringCellValue();
//                paramcode = row.getCell(4).getStringCellValue();
//                String strIndex = getCellValue((XSSFCell) row.getCell(3));
//                System.out.println(type + " " + infocode + " " + strIndex + " " + paramcode + " ");
//
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static String getCellValue(XSSFCell cell) {
//        if (cell == null) return "";
//        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
//            return cell.getStringCellValue();
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
//            return String.valueOf(cell.getBooleanCellValue());
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
//            return cell.getCellFormula();
//        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
//            return String.valueOf(cell.getNumericCellValue());
//        }
//        return "";
//
//    }
//}