/* ~~ ﻿The MyExcelDocument is part of BusinessProfit. ~~
 * 
 * The BusinessProfit's classes and any part of the code 
 * cannot be copied/distributed without 
 * the permission of Sotiris Doudis
 * 
 * Github - RiflemanSD - https://github.com/RiflemanSD
 * 
 * Copyright © 2016 Sotiris Doudis | All rights reserved
 * 
 * License for BusinessProfit project - in GREEK language
 * 
 * Οποιοσδήποτε μπορεί να χρησιμοποιήσει το πρόγραμμα για προσωπική του χρήση. 
 * Αλλά απαγoρεύεται η πώληση ή διακίνηση του προγράμματος σε τρίτους.
 * 
 * Aπαγορεύεται η αντιγραφή ή διακίνηση οποιοδήποτε μέρος του κώδικα χωρίς 
 * την άδεια του δημιουργού. 
 * Σε περίπτωση που θέλετε να χρεισημοποιήσετε κάποια κλάση ή μέρος του κώδικα.
 * Πρέπει να συμπεριλάβεται στο header της κλάσης τον δημιουργό και link στην
 * αυθεντική κλάση (στο github).
 * 
 * ~~ ﻿Information about BusinessProfit project - in GREEK language ~~
 *  
 * Το BusinessProfit είναι ένα project για την αποθήκευση και επεξεργασία
 * των εσόδων/εξόδων μίας επιχείρησης με σκοπό να μπορεί ο επιχειρηματίας να καθορήσει 
 * το καθαρό κέρδος της επιχείρησης. Καθώς και να κρατάει κάποια σημαντικά
 * στατιστικά στοιχεία για τον όγκο της εργασίας κτλ..
 *  
 * Το project δημιουργήθηκε από τον Σωτήρη Δούδη. Φοιτητή πληροφορικής του Α.Π.Θ
 * για προσωπική χρήση. Αλλά και για όποιον άλλον πιθανόν το χρειαστεί.
 * 
 * Το project προγραμματίστηκε σε Java (https://www.java.com/en/download/).
 * Με χρήση του NetBeans IDE (https://netbeans.org/)
 * Για να το τρέξετε πρέπει να έχετε εγκαταστήσει την java.
 *  
 * Ο καθένας μπορεί δωρεάν να χρησιμοποιήσει το project αυτό. Αλλά δεν επιτρέπεται
 * η αντιγραφή/διακήνηση του κώδικα, χωρίς την άδεια του Δημιουργού (Δείτε την License).
 * 
 * Github - https://github.com/RiflemanSD/BusinessProfit
 * 
 * 
 * Copyright © 2016 Sotiris Doudis | All rights reserved
 */
package org.riflemansd.businessprofit.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/** <h1>﻿MyExcelDocument</h1>
 * 
 * <p></p>
 * 
 * <p>Last Update: 01/02/2016</p>
 * <p>Author: <a href=https://github.com/RiflemanSD>RiflemanSD</a></p>
 * 
 * <p>Copyright © 2016 Sotiris Doudis | All rights reserved</p>
 * 
 * @version 1.0.7
 * @author RiflemanSD
 */
public class MyExcelDocument {
    private FileInputStream infile;
    private FileOutputStream outfile;
    private org.apache.poi.ss.usermodel.Workbook workbook;
    private File file;
    
    public MyExcelDocument(String fileName) {
        file = new File(fileName);
        //createFile();
        if (!file.exists()) this.createNewXLSX(fileName);
        
        try {
            infile = new FileInputStream(file);
            //outfile = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            workbook = WorkbookFactory.create(infile);
        } catch (IOException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    // XSSFWorkbook, File
  OPCPackage pkg = OPCPackage.open(new File("file.xlsx"));
  XSSFWorkbook wb = new XSSFWorkbook(pkg);
  ....
  pkg.close();
    
    Workbook wb = WorkbookFactory.create(new File("MyExcel.xls"));
    */
    public void createNewXLSX(String fileName) {
        Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(fileName);
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save() {
        try {
            outfile = new FileOutputStream(file);
            workbook.write(outfile);
            outfile.flush();
            outfile.close();
        } catch (IOException ex) {
            Logger.getLogger(MyExcelDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void autoFillColumhWidth(int nsheet, int ncolumn) {
        Sheet sheet = workbook.getSheetAt(nsheet);
        sheet.autoSizeColumn(ncolumn);
    }
    
    /**
    row.createCell(1).setCellValue(1.2);
    row.createCell(2).setCellValue(
         createHelper.createRichTextString("This is a string"));
    row.createCell(3).setCellValue(true);
    */
    public Cell getCell(int nsheet, int nrow, int ncolumn) {
        Sheet sheet;
        if (workbook.getNumberOfSheets() == 0) {
            sheet = workbook.createSheet();
        }
        else {
            sheet = workbook.getSheetAt(nsheet);
            if (sheet == null) sheet = workbook.createSheet();
        }
        
        Row row = sheet.getRow(nrow);
        if (row == null) row = sheet.createRow(nrow);
        
        Cell cell = row.getCell(ncolumn);
        if (cell == null) cell = row.createCell(ncolumn);
        
        return cell;
    }
    
    /*
    Sheet sheet = wb.getSheetAt(0);
    for (Row row : sheet) {
      for (Cell cell : row) {
        // Do something here
      }
    }
    
    
    */
    public String getString(int nsheet, int nrow, int ncolumn) {
        String value = "";
        
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        value = cell.getRichStringCellValue().getString();
        
        return value;
    }
    public double getDouble(int nsheet, int nrow, int ncolumn) {
        double value = 0;
        
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        value = cell.getNumericCellValue();
        
        return value;
    }

    public void setString(int nsheet, int nrow, int ncolumn, String value) {
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        cell.setCellValue(value);
    }
    public void setDouble(int nsheet, int nrow, int ncolumn, double number) {
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        cell.setCellValue(number);
    }
    
    public Date getDate(int nsheet, int nrow, int ncolumn) {
        Date value;
        
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        value = cell.getDateCellValue();
        
        return value;
    }

    public void setDate(int nsheet, int nrow, int ncolumn, Date value) {
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        CellStyle style = workbook.createCellStyle();
        CreationHelper helper = workbook.getCreationHelper();
        style.setDataFormat(helper.createDataFormat().getFormat("dd/mm/yyy"));
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    public void setHeader(int nsheet, int nrow, int ncolumn, String value) {
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short)12);
        style.setFont(font);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
    
    public void setFormula(int nsheet, int nrow, int ncolumn, String value) {
        org.apache.poi.ss.usermodel.Cell cell = getCell(nsheet, nrow, ncolumn);
        CellStyle style = workbook.createCellStyle();
        
    }
}
