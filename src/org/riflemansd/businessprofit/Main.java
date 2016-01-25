/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit;

import org.riflemansd.businessprofit2.Category;
import org.riflemansd.businessprofit2.IncomeCost;
import org.riflemansd.businessprofit2.PackagesIncome;
import org.riflemansd.businessprofit2.db.InOutDB;

/**
 * Economic profit - Καθαρό Κέρδος
 * 
 * outflow - Εκροές (Έξοδα)
 * income - Εισροές (Έσοδα)
 * 
 * Profit - Κέρδος
 * Costs - Έξοδα
 * 
 * @author sotir
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
        
        db.saveCategory(cat1);
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
        db.saveIn(income32);
        
        db.saveOut(pack);
        
        System.out.println(db.getIn());
        System.out.println(db.getOut());
        System.out.println(db.getPackIn());
    }
    
}
