package com.ahmett.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public ExcelUtil(String path, String sheetName) {
        this.path = path;
        // Check if the file exists and can be opened
        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException("Excel file could not be read at path: " + path);
        }

    }

    public String getCellData(int rowNum, int colNum) {
        Cell cell = workSheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }

    public List<Map<String, String>> getDataList() {
        List<String> columns = getColumnsNames();
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            Row row = workSheet.getRow(i);
            Map<String, String> rowMap = new HashMap<>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public int rowCount() {
        return workSheet.getLastRowNum() + 1;
    }


}
