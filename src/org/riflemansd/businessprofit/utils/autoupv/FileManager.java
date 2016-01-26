/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.riflemansd.businessprofit.utils.autoupv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * last update 25-1-15
 * @version 1.0.0
 * @author rifleman
 */
public class FileManager {
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public FileManager(File file) {
        this.file = file;
        init();
    }
    public FileManager(String file) {
        this.file = new File(file);
        init();
    }
    
    private void init() {
        createFile();
        initReader();
        initWriter(true);
    }
    
    private void createFile() {
        if (!this.file.exists()) {
            File p = this.file.getParentFile();
            if (p != null) {
                if (!p.exists()) {
                    p.mkdirs();
                }
            }
            
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void initReader() {
        try {
            this.reader = new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initWriter(boolean reWrite) {
        try {
            this.writer = new BufferedWriter(new FileWriter(this.file, reWrite));
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        initWriter(false);
        try {
            
            this.writer.write("");
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        initWriter(true);
    }
    
    public List<String> readAllLines() {
        List<String> list = new ArrayList<String>();
        
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public void writeLine(String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void save() {
        try {
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
    This method called at constractor, use it only if u use close()
    */
    public void open() {
        init();
    }
    
    public void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

