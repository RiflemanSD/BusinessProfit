/* ~~ ﻿The PackagesIncome is part of BusinessProfit. ~~
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
package org.riflemansd.businessprofit2;

/** <h1>﻿PackagesIncome</h1>
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
public class PackagesIncome extends IncomeCost {
    private int paradoseis;
    private int paralabes;
    
    private double moneyPerParadosi;
    private double moneyPerParalabi;
    private double moneyFromDiff;

    public PackagesIncome(int id, Category category, String info, int par, int pal) {
        super(id, category, info);
        
        this.moneyPerParadosi = 0.4;
        this.moneyPerParalabi = 1.5;
        this.moneyFromDiff = 0.5;
        
        this.paradoseis = par;
        this.paralabes = pal;
        
        calc();
    }
    
    private void calc() {
        double v = 0;
        
        v = paradoseis*moneyPerParadosi + paralabes*moneyPerParalabi;
        
        v += (paradoseis - paralabes)*moneyFromDiff;
        
        setValue(v);
    }

    public int getParadoseis() {
        return paradoseis;
    }

    public void setParadoseis(int paradoseis) {
        this.paradoseis = paradoseis;
    }

    public int getParalabes() {
        return paralabes;
    }

    public void setParalabes(int paralabes) {
        this.paralabes = paralabes;
    }

    public double getMoneyPerParadosi() {
        return moneyPerParadosi;
    }

    public void setMoneyPerParadosi(double moneyPerParadosi) {
        this.moneyPerParadosi = moneyPerParadosi;
    }

    public double getMoneyPerParalabi() {
        return moneyPerParalabi;
    }

    public void setMoneyPerParalabi(double moneyPerParalabi) {
        this.moneyPerParalabi = moneyPerParalabi;
    }

    public double getMoneyFromDiff() {
        return moneyFromDiff;
    }

    public void setMoneyFromDiff(double moneyFromDiff) {
        this.moneyFromDiff = moneyFromDiff;
    }
    
    
}
