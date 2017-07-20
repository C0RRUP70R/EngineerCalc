package com.example.bptestingapp.models;

/**
 * Created by C0RRUP70R on 15.07.2017.
 */

public class ToleranceField {
    private String name;
    private String range;
    private double IT5;
    private double IT6;
    private double IT7;
    private double IT8;
    private double IT9;
    private double IT10;
    private double IT11;

    public ToleranceField() {
    }

    public ToleranceField(String name, String range, double IT5, double IT6, double IT7, double IT8, double IT9, double IT10, double IT11) {
        this.name = name;
        this.range = range;
        this.IT5 = IT5;
        this.IT6 = IT6;
        this.IT7 = IT7;
        this.IT8 = IT8;
        this.IT9 = IT9;
        this.IT10 = IT10;
        this.IT11 = IT11;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public double getIT5() {
        return IT5;
    }

    public void setIT5(double IT5) {
        this.IT5 = IT5;
    }

    public double getIT6() {
        return IT6;
    }

    public void setIT6(double IT6) {
        this.IT6 = IT6;
    }

    public double getIT7() {
        return IT7;
    }

    public void setIT7(double IT7) {
        this.IT7 = IT7;
    }

    public double getIT8() {
        return IT8;
    }

    public void setIT8(double IT8) {
        this.IT8 = IT8;
    }

    public double getIT9() {
        return IT9;
    }

    public void setIT9(double IT9) {
        this.IT9 = IT9;
    }

    public double getIT10() {
        return IT10;
    }

    public void setIT10(double IT10) {
        this.IT10 = IT10;
    }

    public double getIT11() {
        return IT11;
    }

    public void setIT11(double IT11) {
        this.IT11 = IT11;
    }

    @Override
    public String toString() {
        return "ToleranceCalc{" +
                "name='" + name + '\'' +
                ", range='" + range + '\'' +
                ", IT5=" + IT5 +
                ", IT6=" + IT6 +
                ", IT7=" + IT7 +
                ", IT8=" + IT8 +
                ", IT9=" + IT9 +
                ", IT10=" + IT10 +
                ", IT11=" + IT11 +
                '}';
    }
}
