/* ~~ ﻿The TimePicker is part of BusinessProfit. ~~
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
package org.riflemansd.businessprofit.panels;

import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


/** <h1>﻿TimePicker</h1>
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
public class TimePicker extends JPanel {
    JSpinner timeSpinner;
    
    public TimePicker() {
        this.setLayout(new BorderLayout());
        
        timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        
        this.add(timeSpinner, BorderLayout.CENTER);
    }
    public TimePicker(String type) {
        this.setLayout(new BorderLayout());
        
        timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, type);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        
        this.add(timeSpinner, BorderLayout.CENTER);
    }
    public TimePicker(String type, Date date) {
        this.setLayout(new BorderLayout());
        
        timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, type);
        timeSpinner.setEditor(timeEditor);
        
        if (date == null) timeSpinner.setValue(new Date());
        else timeSpinner.setValue(date);
        
        this.add(timeSpinner, BorderLayout.CENTER);
    }
    
    public Date getTimeDate() {
        return (Date)this.timeSpinner.getValue();
    }
    
    public String getTime() {
        return ((Date)this.timeSpinner.getValue()).toString();
    }
    public void setTime(Date value) {
        this.timeSpinner.setValue(value);
    }
}
