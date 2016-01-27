/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.riflemansd.businessprofit.main;

import org.riflemansd.businessprofit2.db.InOutDB;

/**
 * Η Κεντρική Class του project BusinessProfit
 * 1.Αρχικοποιήση δεδομένων
 * 2.Άνοιγμα κεντρικού παραθύρου
 * 3.Έλεγχος του προγραμμάτος
 * 4.Έλεγχος της βάσης
 * 
 * @author RiflemanSD
 */
public class BusinessProfit {
    private InOutDB database;
    
    public BusinessProfit() {
        database = new InOutDB();
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
    }
}
