/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit;

import java.util.ArrayList;

/**
 *
 * @author sotir
 */
public class Costs {
    private ArrayList<Cost> costs; 
    
    public Costs() {
        this.costs = new ArrayList<>();
    }
    
    public void add(Cost cost) {
        this.costs.add(cost);
    }
    
    public void print() {
        for (Cost c: costs) {
            c.print();
        }
    }
}
