/* ~~ ﻿The InOutDB is part of BusinessProfit. ~~
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


/** <h1>﻿InOutDB</h1>
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
public class InOutDB {
    private SQLiteManager manager;
    
    public InOutDB() {
        manager = new SQLiteManager("Database");
        
        manager.createTable("category", "id,name", 1, "name");
        manager.createTable("cost", "id,catid,value,info,time", 1, 1, 1.0, "null", "time");
        manager.createTable("income", "id,catid,value,info,time", 1, 1, 1.0, "null", "time");
        manager.createTable("packageincome", "id,catid,value,info,paradoseis,paralabes,time", 1, 1, 1.0, "null", 1, 1, "time");
        
        //Settings
        manager.createTable("settings", "id,name,value", 1, "s", "s");
    }
    
    public void saveSetting(String name, String value) {
        manager.insert("settings", "name,value", name, value);
    }
    public void updateSetting(String name, String value) {
        System.out.println(value);
        manager.update("settings", "value = '" + value + "'", "name = '" + name + "'");
    }
    
    public String getSetting(String name) {
        String result = manager.select("settings", "value", "name = '" + name + "'", 1);
        if (result.isEmpty()) return null;
        
        //System.out.println(result.replace("\n", ""));
        
        return result.replace("\n", "").replace(" ", "");
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
        if (result.isEmpty()) return null;
        
        int id = Integer.parseInt(result.split(",")[0]);
        
        return new Category(id, catName);
    }
    public Category getCategory(int id) {
        String result = manager.select("category", "id,name", "id = " + id, 2);
        if (result.isEmpty()) return null;
        
        String name = result.split(",")[1];
        
        return new Category(id, name);
    }
    
    public void saveOut(IncomeCost cost, Date date) {
        manager.insert("cost", "catid,value,info,time", cost.getCategory().getId(), cost.getValue(), cost.getInfo(), this.dateToString(date));
    }
    public void saveOut(IncomeCost cost) {
        manager.insert("cost", "catid,value,info,time", cost.getCategory().getId(), cost.getValue(), cost.getInfo(),currentTime());
    }
    public String getOut() {
        String result = manager.select("cost", "*", "", 5);
        
        return result;
    }
    
    public void saveIn(IncomeCost in, Date date) {
        manager.insert("income", "catid,value,info,time", in.getCategory().getId(), in.getValue(), in.getInfo(), this.dateToString(date));
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
    public void savePackIn(PackagesIncome pack, Date date) {
        manager.insert("packageincome", "catid,value,info,paradoseis,paralabes,time", pack.getCategory().getId(), pack.getValue(), pack.getInfo(), pack.getParadoseis(), pack.getParalabes(), this.dateToString(date));
    }
    public String getPackIn() {
        String result = manager.select("packageincome", "*", "", 7);
        
        return result;
    }
    
    public void delete(int tableId, int rowId) {
        String table = null;
        if (tableId == 0) {
            table = "category";
        }
        else if (tableId == 1) {
            table = "cost";
        }
        else if (tableId == 2) {
            table = "income";
        }
        else if (tableId == 3) {
            table = "packageincome";
        }
        
        if (table != null) manager.delete(table, "id = " + rowId);
    }
    
    public String currentTime() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        
        return reportDate;
    }
    public String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String reportDate = df.format(date);
        
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
