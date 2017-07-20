package com.example.bptestingapp;

/**
 * Created by C0RRUP70R on 16.01.2017.
 */

public class calcFc {
    public static int countRot(double v, double d) {
        int n;
        n = (int) ((1000 * v) / (Math.PI * d));
        return n;
    }

    public static int countSpeed(double n, double d) {
        int v;
        v = (int) (Math.PI * d * n) / 1000;
        return v;
    }

    //-----------------------------------------------------------
    //------       maximalni sila, vypocet napeti          ------
    //-----------------------------------------------------------

    public static double maxForce(double mod, int tension) {
        double force;
        force = mod * tension;
        return force;
    }

    public static double maxTension(double mod, int force) {
        double tension;
        tension = force / mod;
        return tension;
    }

    //-----------------------------------------------------------
    //------       pomocne vypocty - plochy, moduly        ------
    //-----------------------------------------------------------

    public static double areaRect(double w, double h) {
        double area;
        area = w * h;
        return area;
    }

    public static double modulusRectBend(double w, double h, char axis) {
        double modulus;
        switch (axis) {
            case 'x':
                modulus = (w * Math.pow(h, 2)) / 6;
                break;
            case 'z':
                modulus = (h * Math.pow(w, 2)) / 6;
                break;
            default:
                modulus = 0;
        }
        return modulus;
    }

    public static double modulusRectTorq(double w, double h, char axis) {
        double modulus;
        switch (axis) {
            case 'x':
                modulus = w * Math.pow(h, 2) * alpha(h, w);
                break;
            case 'z':
                modulus = h * Math.pow(w, 2) * beta(h, w);
                break;
            default:
                modulus = 0;
        }
        return modulus;
    }

    public static double modulusSquareBend(double a) {
        double modulus;
        modulus = Math.pow(a, 3) / 6;
        return modulus;
    }

    public static double modulusSquareTorq(double a) {
        double modulus;
        modulus = 0.208 * Math.pow(a, 3);
        return modulus;
    }

    public static double areaCirc(double diameter) {
        double area;
        area = (Math.PI * Math.pow(diameter, 2)) / 4;
        return area;
    }

    public static double modulusCircBend(double diameter) {
        double modulus;
        modulus = 0.098 * Math.pow(diameter, 3); // (pi * d^3) / 32
        return modulus;
    }

    public static double modulusCircTorq(double diameter) {
        double modulus;
        modulus = 0.196 * Math.pow(diameter, 3); // (pi * d^3) / 16
        return modulus;
    }

    private static double alpha(double h, double w) {
        double ret;
        double tmp = h / w;
        if (tmp < 1.2) {
            ret = 0.208;
        } else if (tmp < 1.5) {
            ret = 0.219;
        } else if ((int) tmp < 2) {
            ret = 0.231;
        } else if ((int) tmp < 3) {
            ret = 0.246;
        } else if ((int) tmp < 5) {
            ret = 0.267;
        } else if ((int) tmp < 10) {
            ret = 0.291;
        } else if ((int) tmp == 10) {
            ret = 0.312;
        } else ret = 0.333;

        return ret;
    }

    private static double beta(double h, double w) {
        double ret;
        double tmp = h / w;

        return 0;
    }


}
