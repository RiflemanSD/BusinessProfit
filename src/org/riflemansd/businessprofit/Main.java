/* ~~ ﻿The Main is part of BusinessProfit. ~~
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
package org.riflemansd.businessprofit;

import org.riflemansd.businessprofit2.Category;
import org.riflemansd.businessprofit2.IncomeCost;
import org.riflemansd.businessprofit2.PackagesIncome;
import org.riflemansd.businessprofit2.db.InOutDB;


/** <h1>﻿Main</h1>
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Category cat1 = new Category(0, "demata");
        Category cat2 = new Category(1, "papoutsia");
        Category cat3 = new Category(2, "logiariasmoi");
        Category cat4 = new Category(3, "kleidia");
        Category cat5 = new Category(4, "alla");
        
        
        IncomeCost cost20 = new IncomeCost(0, cat2, "Μπογιά", 20);
        IncomeCost cost21 = new IncomeCost(1, cat2, "Τακούνια", 32);
        
        
        IncomeCost cost5 = new IncomeCost(2, cat5, "Δεή", 350);
        IncomeCost cost4 = new IncomeCost(3, cat4, "Αγορά Κλειδιών", 45);
        
        IncomeCost cost01 = new IncomeCost(4, cat1, "Βενζίνη", 10);
        IncomeCost cost02 = new IncomeCost(5, cat1, "Βενζίνη", 10);
        IncomeCost cost03 = new IncomeCost(6, cat1, "Βενζίνη", 20);
        IncomeCost cost04 = new IncomeCost(7, cat1, "Βενζίνη", 10);
        
        IncomeCost income11 = new IncomeCost(0, cat2, "Παπούτσια", 22);
        IncomeCost income12 = new IncomeCost(0, cat2, "Παπούτσια", 13.5);
        
        IncomeCost income31 = new IncomeCost(0, cat4, "Κλειδιά", 4.5);
        IncomeCost income32 = new IncomeCost(0, cat4, "Κλειδαριές", 23.5);
        
        PackagesIncome pack = new PackagesIncome(0, cat1, "", 100, 20);
        
        System.out.println(pack.getValue());
        
        
        
        InOutDB db = new InOutDB();
        
        /*db.saveCategory(cat1);
        db.saveCategory(cat2);
        db.saveCategory(cat3);
        db.saveCategory(cat4);
        db.saveCategory(cat5);
        
        db.saveOut(cost20);
        db.saveOut(cost21);
        db.saveOut(cost4);
        db.saveOut(cost5);
        db.saveOut(cost01);
        db.saveOut(cost02);
        db.saveOut(cost03);
        db.saveOut(cost04);
        
        db.saveIn(income11);
        db.saveIn(income12);
        db.saveIn(income31);
        db.saveIn(income32);*/
        
        //db.savePackIn(pack);
        
        System.out.println("Categorys");
        System.out.println(db.getCategorys());
        System.out.println("In");
        System.out.println(db.getIn());
        System.out.println("Out");
        System.out.println(db.getOut());
        System.out.println("Pack");
        System.out.println(db.getPackIn());
    }
    
}
