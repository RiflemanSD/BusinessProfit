/* ~~ ﻿The TimeCalc is part of BusinessProfit. ~~
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
package org.riflemansd.businessprofit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** <h1>﻿TimeCalc</h1>
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
public class TimeCalc {
    private long start;
    private long end;
    private long time;
    
    public TimeCalc() {}
    
    public void start() { start = System.currentTimeMillis(); }
    public void end() { 
        end = System.currentTimeMillis(); 
        time = calc();
    }
    private long calc() {
        return end - start;
    }
    
    public long getMillis() {
        return time;
    }
    public double getSeconds() {
        return time/1000;
    }
    public double getMinutes() {
        return getSeconds()/60;
    }
    public double getHours() {
        return getMinutes()/60;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Date resultdate = new Date(this.getMillis());
        return date_format.format(resultdate);
    }
}
