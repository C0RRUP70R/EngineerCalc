package com.example.bptestingapp.models;

/**
 * Created by C0RRUP70R on 19.07.2017.
 */

public class Tolerance {
    private double ES;
    private double EI;

    public Tolerance(double ES, double EI) {
        this.ES = ES;
        this.EI = EI;
    }

    public double getES() {
        return ES;
    }

    public void setES(double ES) {
        this.ES = ES;
    }

    public double getEI() {
        return EI;
    }

    public void setEI(double EI) {
        this.EI = EI;
    }
}
