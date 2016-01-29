/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.riflemansd.businessprofit.excel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author RiflemanSD
 */
public class ExcelExamplePOI {
    

    public static void main(String[] args) throws Throwable {
        SXSSFWorkbook wb = new SXSSFWorkbook(1000); // keep 100 rows in memory, exceeding rows will be flushed to disk
        
        if (wb.getNumberOfSheets() == 0) {
            wb.createSheet("MySheet");
        }
        Sheet sh = wb.getSheetAt(0);
        Row  row = sh.createRow(3);
        
        for (int i = 0; i < 10; i++) {
            Cell cell = row.createCell(i);
            //String address = new CellReference(cell).formatAsString();
            cell.setCellValue("Καλημέρα " + i);
            //row.setHeightInPoints(50);
            //sh.setColumnWidth(5, 1200); //4, 33 pixels
            wb.getSheetAt(0).autoSizeColumn(i);
        }
        
        FileOutputStream out = new FileOutputStream("test.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
        
        Desktop.getDesktop().open(new File("test.xlsx"));
    }
}
