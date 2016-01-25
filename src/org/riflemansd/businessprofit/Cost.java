/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit;

/**
 *
 * @author sotir
 */
public class Cost {
    private int id;
    private String reason;
    private double cost;

    public Cost(int id, String reason, double cost) {
        this.id = id;
        this.reason = reason;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public void print() {
        System.out.println(getReason() + " | " + getCost());
    }
}
