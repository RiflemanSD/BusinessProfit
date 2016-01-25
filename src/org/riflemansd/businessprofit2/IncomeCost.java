/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit2;

/**
 *
 * @author sotir
 */
public class IncomeCost {
    private int id;
    private Category category;
    private double value;
    private String info;

    public IncomeCost(int id, Category category, String info) {
        this.id = id;
        this.category = category;
        this.value = 0;
        this.info = info;
    }
    
    public IncomeCost(int id, Category category, String info, double value) {
        this.id = id;
        this.category = category;
        this.value = 0;
        this.info = info;
        this.value = value;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
