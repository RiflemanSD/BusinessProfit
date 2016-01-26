/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.riflemansd.businessprofit.utils.autoupv;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RiflemanSD
 */
public class UpdateFileHeader {
    //private String filename;
    private FileManager fileManager;
    
    public UpdateFileHeader(String filename) {
        fileManager = new FileManager(filename);
        
        List<String> lines = fileManager.readAllLines();
        fileManager.delete();
        fileManager.save();
        
        for (String line : lines) {
            System.out.println(line);
            //if (line.contains("@version")) {
            //    line = " * @version 2.0.0";
            //}
            //fileManager.writeLine(line);
        }
        //fileManager.save();
        fileManager.close();
    }

    public static void main(String[] args) {
        //new UpdateFileHeader("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\FileManager2.java");
        //new UpdateFileHeader("nbproject\\myheader\\Information.txt");
        FileManager file1 = new FileManager("src\\org\\riflemansd\\businessprofit\\utils\\autoupv\\FileManager2.java");
        FileManager file2 = new FileManager("nbproject\\myheader\\Information.txt");
        
        List<String> lines1 = file1.readAllLines();
        List<String> lines2 = file2.readAllLines();
        
        file1.delete();
        file1.save();
        
        boolean stop = false;
        for (String line1 : lines1) {
            System.out.println(line1);
            if (line1.contains("package")) {
                stop = true;

                file1.writeLine("/* [!] Header of the file FileManager2 [!]\n * ");
                for (String line2 : lines2) {
                    System.out.println(line2);
                    file1.writeLine(" * " + line2);
                }
                file1.writeLine(" * \n * [!] Automatically created - " + getDate() + " [!]\n */\n");
            }
            if (stop) file1.writeLine(line1);
        }
        file1.save();
        
        file1.close();
        file2.close();
    }
    
    public static String getDate() {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date resultdate = new Date();
        
        return date_format.format(resultdate);
    }
}
