package com.example.bptestingapp.auxiliary;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bptestingapp.calcFc;
import com.example.bptestingapp.database.SQLiteDatabaseHandler;
import com.example.bptestingapp.models.Tolerance;

/**
 * Created by C0RRUP70R on 24.02.2017.
 */

public class auxFc {

    public static double getArea(String type, String area, String sideA, String sideB) {
        double ret = 0;
        switch (type) {
            case "tah":
                ret = calcArea(area, sideA, sideB);
                break;
            case "tlak":
                ret = calcArea(area, sideA, sideB);
                break;
            case "ohyb":
                ret = calcBendModulus(area, sideA, sideB);
                break;
            case "smyk":
                break;
        }
        return ret;
    }

    private static double calcArea(String area, String sideA, String sideB) {
        switch (area) {
            case "kruh":
                double r = Double.parseDouble(sideA);
                return calcFc.areaCirc(r);
            case "obdélník":
                double a = Double.parseDouble(sideA);
                double b = Double.parseDouble(sideB);
                return calcFc.areaRect(a, b);
            case "čtverec":
                a = Double.parseDouble(sideA);
                return calcFc.areaRect(a, a);
        }
        return 0;
    }

    private static double calcBendModulus(String area, String sideA, String sideB) {
        switch (area) {
            case "kruh":
                double r = Double.parseDouble(sideA);
                return calcFc.modulusCircBend(r);
            case "obdélník":
                double a = Double.parseDouble(sideA);
                double b = Double.parseDouble(sideB);
                char axis = 'x';
                if (a < b) axis = 'z';
                return calcFc.modulusRectBend(a, b, axis);
            case "čtverec":
                a = Double.parseDouble(sideA);
                return calcFc.modulusSquareBend(a);
        }
        return 0;
    }

    public static int getTension(String material, String tensDirection, String tensType, Context context) {
        String param = "";
        switch (tensType) {
            case "statický":
                param = "static_";
                break;
            case "míjivý":
                param = "passive_";
                break;
            case "střídavý":
                param = "alternate_";
                break;
        }
        switch (tensDirection) {
            case "tah":
                param += "thrust";
                break;
            case "tlak":
                param += "pressure";
                break;
            case "ohyb":
                param += "bend";
                break;
            case "smyk":
                param += "cut";
                break;
        }
        SQLiteDatabaseHandler db = new SQLiteDatabaseHandler(context);
        return db.getMaterialProperty(material, param);

    }

    public static String getRangeEP(String value) {
        double val = Double.parseDouble(value);
        String range;
        if (val < 50.0) {
            range = getRangeEP50(val);
        } else {
            range = getRangeEP500(val);
        }
        return range;
    }

    public static String getRangeRS(String value){
        return "";
    }

    private static String getRangeEP50(double val) {
        if (val > 30.0) {
            return "30-50";
        }
        if (val > 18.0) {
            return "18-30";
        }
        if (val > 10.0) {
            return "10-18";
        }
        if (val > 6.0) {
            return "6-10";
        }
        if (val > 3.0) {
            return "3-6";
        }
        if (val >= 1.0) {
            return "1-3";
        }
        return "";
    }

    private static String getRangeEP500(double val) {
        if (val > 400.0) {
            return "400-500";
        }
        if (val > 315.0){
            return "315-400";
        }
        if (val > 250.0){
            return "250-315";
        }
        if (val > 180.0){
            return "180-250";
        }
        if (val > 120.0){
            return "120-180";
        }
        if (val > 80.0){
            return "80-120";
        }
        if (val > 50.0){
            return "50-80";
        }
        return "";
    }


    public static Tolerance getTolerance(String table, String range,  String itRange, String it, Context context){
        SQLiteDatabaseHandler db = new SQLiteDatabaseHandler(context);
        double ES;
        double EI;
        if (table.equals(table.toUpperCase())){
            ES = db.getFieldTolerance(table, range, it);
            EI = ES - db.getFieldTolerance("IT", itRange, it);
        } else {
            EI = -db.getFieldTolerance(table.toUpperCase(), range, it);
            ES = EI + db.getFieldTolerance("IT", itRange, it);
        }
        return new Tolerance(ES, EI);

    }
}
