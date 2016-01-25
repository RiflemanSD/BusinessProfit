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
