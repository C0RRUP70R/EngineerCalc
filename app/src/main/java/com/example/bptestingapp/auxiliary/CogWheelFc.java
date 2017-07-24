package com.example.bptestingapp.auxiliary;

/**
 * Created by C0RRUP70R.
 */

public class CogWheelFc {

    public static String getPitchDiameterStr(double m, int z){
        if (z >= 3) {
            double d = m * z;
            return String.format("%.2f", d) + "mm";
        } else return "-mm";
    }

    public static String getPitchStr(double m){
        double t = Math.PI * m;
        return String.format("%.2f", t) + "mm";
    }

    public static String getOutletStr(double m){
        double ca = 0.25 * m;
        return String.format("%.2f", ca) + "mm";
    }

    public static String getHeadStr(double m){
        return String.format("%.2f", m) + "mm";
    }

    public static String getFootStr(double m){
        double hf = 1.25 * m;
        return String.format("%.2f", hf) + "mm";
    }

    public static String getCogHeightStr(double m){
        double h = 2.25 * m;
        return String.format("%.2f", h) + "mm";
    }

    public static String getHeadDiameterStr(double m, int z){
        if (z >=3) {
            double da = m * (z + 2);
            return String.format("%.2f", da) + "mm";
        } else return "-mm";
    }

    public static String getFootDiameterStr(double m, int z){
        if (z >= 3) {
            double df = m * (z - 2.5);
            return String.format("%.2f", df) + "mm";
        } else return "-mm";
    }

    public static String getCogWidth(double m){
        double s = (Math.PI/2) * m;
        return String.format("%.2f", s) + "mm";
    }

    public static String getCogMarStr(double m){
        double sm = (Math.PI/2) * m;
        return String.format("%.2f", sm) + "mm";
    }

    public static double getMod(double diameter, int cogCount){
        return diameter/(cogCount + 2);
    }
}
