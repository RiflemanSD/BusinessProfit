/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit2.db;

import org.riflemansd.businessprofit2.Category;
import org.riflemansd.businessprofit2.IncomeCost;
import org.riflemansd.businessprofit2.PackagesIncome;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sotir
 */
public class InOutDB {
    private SQLiteManager manager;
    
    public InOutDB() {
        manager = new SQLiteManager("Database");
        
        manager.createTable("category", "id,name", 1, "name");
        manager.createTable("cost", "id,catid,value,info,time", 1, 1, 1.0, "null", "time");
        manager.createTable("income", "id,catid,value,info,time", 1, 1, 1.0, "null", "time");
        manager.createTable("packageincome", "id,catid,value,info,paradoseis,paralabes,time", 1, 1, 1.0, "null", 1, 1, "time");
        
    }
    
    public void saveCategory(Category cat) {
        manager.insert("category", "name", cat.getName());
    }
    public void saveCategory(String cat) {
        manager.insert("category", "name", cat);
    }
    public String getCategorys() {
        String result = manager.select("category", "*", "", 2);
        
        return result;
    }
    public Category getCategory(String catName) {
        String result = manager.select("category", "id,name", "name = '" + catName + "'", 2);
        
        int id = Integer.parseInt(result.split(",")[0]);
        
        return new Category(id, catName);
    }
    public Category getCategory(int id) {
        String result = manager.select("category", "id,name", "id = " + id, 2);
        
        String name = result.split(",")[1];
        
        return new Category(id, name);
    }
    
    
    public void saveOut(IncomeCost cost) {
        manager.insert("cost", "catid,value,info,time", cost.getCategory().getId(), cost.getValue(), cost.getInfo(),currentTime());
    }
    public String getOut() {
        String result = manager.select("cost", "*", "", 5);
        
        return result;
    }
    
    public void saveIn(IncomeCost in) {
        manager.insert("income", "catid,value,info,time", in.getCategory().getId(), in.getValue(), in.getInfo(),currentTime());
    }
    public String getIn() {
        String result = manager.select("income", "*", "", 5);
        
        return result;
    }
    
    public void savePackIn(PackagesIncome pack) {
        manager.insert("packageincome", "catid,value,info,paradoseis,paralabes,time", pack.getCategory().getId(), pack.getValue(), pack.getInfo(), pack.getParadoseis(), pack.getParalabes(),currentTime());
    }
    
    public String getPackIn() {
        String result = manager.select("packageincome", "*", "", 7);
        
        return result;
    }
    
    public String currentTime() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        
        return reportDate;
    }
    
    public Date getDate(String sdate) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return format.parse(sdate);
        } catch (ParseException ex) {
            Logger.getLogger(InOutDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Date();
    }
    
    public void close() {
        this.manager.close();
    }
}
