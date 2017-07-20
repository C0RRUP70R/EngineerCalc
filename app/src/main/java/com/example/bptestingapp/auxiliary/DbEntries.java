package com.example.bptestingapp.auxiliary;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by C0RRUP70R on 15.07.2017.
 */

public class DbEntries {

    public static void crateDbEntries(SQLiteDatabase db) {
        createTables(db);
        fillETable(db);
        fillFTable(db);
        fillGTable(db);
        fillHTable(db);
        fillJsTable(db);
        fillJTable(db);
        fillKTable(db);
        fillMTable(db);
        fillNTable(db);
        fillPTable(db);
        fillRTable(db);
        fillSTable(db);
        fillItTable(db);
    }

    private static ContentValues createEntry(String range,
                                             double IT5, double IT6, double IT7, double IT8, double IT9, double IT10, double IT11) {
        ContentValues values = new ContentValues();
        values.put("range", range);
        values.put("IT5", IT5);
        values.put("IT6", IT6);
        values.put("IT7", IT7);
        values.put("IT8", IT8);
        values.put("IT9", IT9);
        values.put("IT10", IT10);
        values.put("IT11", IT11);
        return values;
    }

    private static ContentValues createEntry(String range, double IT5, double IT6, double IT7, double IT8, double IT9, double IT10) {
        ContentValues values = new ContentValues();
        values.put("range", range);
        values.put("IT5", IT5);
        values.put("IT6", IT6);
        values.put("IT7", IT7);
        values.put("IT8", IT8);
        values.put("IT9", IT9);
        values.put("IT10", IT10);
        return values;
    }

    private static ContentValues createEntry(String range, double IT5, double IT6, double IT7, double IT8, double IT9) {
        ContentValues values = new ContentValues();
        values.put("range", range);
        values.put("IT5", IT5);
        values.put("IT6", IT6);
        values.put("IT7", IT7);
        values.put("IT8", IT8);
        values.put("IT9", IT9);
        return values;
    }

    private static ContentValues createEntry(String range, double IT5, double IT6, double IT7, double IT8) {
        ContentValues values = new ContentValues();
        values.put("range", range);
        values.put("IT5", IT5);
        values.put("IT6", IT6);
        values.put("IT7", IT7);
        values.put("IT8", IT8);
        return values;
    }

    private static ContentValues createEntry(String range, double IT6, double IT7) {
        ContentValues values = new ContentValues();
        values.put("range", range);
        values.put("IT6", IT6);
        values.put("IT7", IT7);
        return values;
    }

    private static ContentValues createEntry(String range, double IT5, double IT6, double IT7, String type) {
        ContentValues values = new ContentValues();
        switch (type) {
            case "5-7":
                values.put("range", range);
                values.put("IT5", IT5);
                values.put("IT6", IT6);
                values.put("IT7", IT7);
                break;
            case "6-8":
                values.put("range", range);
                values.put("IT6", IT5);
                values.put("IT7", IT6);
                values.put("IT8", IT7);
                break;
        }
        return values;
    }


    private static void createTables(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE E (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL, IT10 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE F  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE G  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE H  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL, IT10 REAL, IT11 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE JS  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL, IT10 REAL, IT11 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE J  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT6 REAL, IT7 REAL, IT8 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE K  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE M  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE N  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL, IT10 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE P  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE R  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT6 REAL, IT7 REAL, IT8 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE S  (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT6 REAL, IT7 REAL)";
        db.execSQL(CREATION_TABLE);
        CREATION_TABLE = "CREATE TABLE IT (id INTEGER PRIMARY KEY AUTOINCREMENT, range TEXT, " +
                "IT5 REAL, IT6 REAL, IT7 REAL, IT8 REAL, IT9 REAL, IT10 REAL, IT11 REAL)";
        db.execSQL(CREATION_TABLE);
    }

    private static void fillETable(SQLiteDatabase db) {
        ContentValues values;
        values = createEntry("1-3", 0.018, 0.02, 0.024, 0.028, 0.039, 0.054);
        db.insert("E", null, values);
        values = createEntry("3-6", 0.025, 0.028, 0.032, 0.038, 0.05, 0.068);
        db.insert("E", null, values);
        values = createEntry("6-10", 0.031, 0.034, 0.040, 0.047, 0.061, 0.083);
        db.insert("E", null, values);
        values = createEntry("10-18", 0.040, 0.043, 0.05, 0.059, 0.075, 0.102);
        db.insert("E", null, values);
        values = createEntry("18-30", 0.049, 0.053, 0.061, 0.073, 0.092, 0.124);
        db.insert("E", null, values);
        values = createEntry("30-50", 0.061, 0.066, 0.075, 0.089, 0.112, 0.150);
        db.insert("E", null, values);
        values = createEntry("50-80", 0.073, 0.079, 0.090, 0.106, 0.134, 0.180);
        db.insert("E", null, values);
        values = createEntry("80-120", 0.087, 0.094, 0.107, 0.125, 0.159, 0.212);
        db.insert("E", null, values);
        values = createEntry("120-180", 0.103, 0.110, 0.125, 0.148, 0.185, 0.245);
        db.insert("E", null, values);
        values = createEntry("180-250", 0.120, 0.129, 0.146, 0.172, 0.215, 0.285);
        db.insert("E", null, values);
        values = createEntry("250-315", 0.133, 0.142, 0.162, 0.191, 0.240, 0.320);
        db.insert("E", null, values);
        values = createEntry("315-400", 0.15, 0.161, 0.182, 0.214, 0.265, 0.355);
        db.insert("E", null, values);
        values = createEntry("400-500", 0.162, 0.175, 0.198, 0.232, 0.29, 0.385);
        db.insert("E", null, values);
    }

    private static void fillFTable(SQLiteDatabase db) {
        ContentValues values;
        values = createEntry("1-3", 0.01, 0.012, 0.016, 0.020, 0.031);
        db.insert("F", null, values);
        values = createEntry("3-6", 0.015, 0.018, 0.022, 0.028, 0.040);
        db.insert("F", null, values);
        values = createEntry("6-10", 0.019, 0.022, 0.028, 0.035, 0.049);
        db.insert("F", null, values);
        values = createEntry("10-18", 0.024, 0.027, 0.034, 0.043, 0.059);
        db.insert("F", null, values);
        values = createEntry("18-30", 0.029, 0.033, 0.041, 0.053, 0.072);
        db.insert("F", null, values);
        values = createEntry("30-50", 0.036, 0.041, 0.050, 0.064, 0.087);
        db.insert("F", null, values);
        values = createEntry("50-80", 0.043, 0.049, 0.060, 0.076, 0.104);
        db.insert("F", null, values);
        values = createEntry("80-120", 0.051, 0.058, 0.071, 0.090, 0.123);
        db.insert("F", null, values);
        values = createEntry("120-180", 0.061, 0.068, 0.083, 0.106, 0.143);
        db.insert("F", null, values);
        values = createEntry("180-250", 0.070, 0.079, 0.096, 0.122, 0.165);
        db.insert("F", null, values);
        values = createEntry("250-315", 0.079, 0.088, 0.108, 0.137, 0.186);
        db.insert("F", null, values);
        values = createEntry("315-400", 0.087, 0.098, 0.119, 0.151, 0.202);
        db.insert("F", null, values);
        values = createEntry("400-500", 0.095, 0.108, 0.131, 0.165, 0.223);
        db.insert("F", null, values);
    }

    private static void fillGTable(SQLiteDatabase db) {
        ContentValues values;
        values = createEntry("1-3", 0.006, 0.008, 0.012, "5-7");
        db.insert("G", null, values);
        values = createEntry("3-6", 0.009, 0.012, 0.016, "5-7");
        db.insert("G", null, values);
        values = createEntry("6-10", 0.011, 0.014, 0.020, "5-7");
        db.insert("G", null, values);
        values = createEntry("10-18", 0.014, 0.017, 0.024, "5-7");
        db.insert("G", null, values);
        values = createEntry("18-30", 0.016, 0.020, 0.028, "5-7");
        db.insert("G", null, values);
        values = createEntry("30-50", 0.020, 0.025, 0.034, "5-7");
        db.insert("G", null, values);
        values = createEntry("50-80", 0.023, 0.029, 0.040, "5-7");
        db.insert("G", null, values);
        values = createEntry("80-120", 0.027, 0.034, 0.047, "5-7");
        db.insert("G", null, values);
        values = createEntry("120-180", 0.032, 0.039, 0.054, "5-7");
        db.insert("G", null, values);
        values = createEntry("180-250", 0.035, 0.044, 0.061, "5-7");
        db.insert("G", null, values);
        values = createEntry("250-315", 0.040, 0.049, 0.069, "5-7");
        db.insert("G", null, values);
        values = createEntry("315-400", 0.043, 0.054, 0.075, "5-7");
        db.insert("G", null, values);
        values = createEntry("400-500", 0.047, 0.06, 0.083, "5-7");
        db.insert("G", null, values);
    }

    private static void fillHTable(SQLiteDatabase db) {
        ContentValues values;
        values = createEntry("1-3", 0.004, 0.006, 0.01, 0.014, 0.025, 0.04, 0.06);
        db.insert("H", null, values);
        values = createEntry("3-6", 0.005, 0.008, 0.012, 0.018, 0.03, 0.048, 0.075);
        db.insert("H", null, values);
        values = createEntry("6-10", 0.006, 0.009, 0.015, 0.022, 0.036, 0.058, 0.09);
        db.insert("H", null, values);
        values = createEntry("10-18", 0.008, 0.011, 0.018, 0.027, 0.043, 0.07, 0.11);
        db.insert("H", null, values);
        values = createEntry("18-30", 0.009, 0.013, 0.021, 0.033, 0.052, 0.084, 0.13);
        db.insert("H", null, values);
        values = createEntry("30-50", 0.011, 0.016, 0.025, 0.039, 0.062, 0.1, 0.16);
        db.insert("H", null, values);
        values = createEntry("50-80", 0.013, 0.019, 0.03, 0.046, 0.074, 0.12, 0.19);
        db.insert("H", null, values);
        values = createEntry("80-120", 0.015, 0.022, 0.035, 0.054, 0.087, 0.14, 0.22);
        db.insert("H", null, values);
        values = createEntry("120-180", 0.018, 0.025, 0.04, 0.063, 0.1, 0.16, 0.25);
        db.insert("H", null, values);
        values = createEntry("180-250", 0.02, 0.029, 0.046, 0.072, 0.115, 0.185, 0.29);
        db.insert("H", null, values);
        values = createEntry("250-315", 0.023, 0.032, 0.052, 0.081, 0.13, 0.21, 0.32);
        db.insert("H", null, values);
        values = createEntry("315-400", 0.025, 0.036, 0.057, 0.089, 0.14, 0.23, 0.36);
        db.insert("H", null, values);
        values = createEntry("400-500", 0.027, 0.04, 0.063, 0.097, 0.155, 0.25, 0.4);
        db.insert("H", null, values);
    }

    private static void fillJsTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", 0.002, 0.003, 0.005, 0.007, 0.0125, 0.02, 0.03);
        db.insert("JS", null, values);
        values = createEntry("3-6", 0.0025, 0.004, 0.006, 0.009, 0.015, 0.024, 0.0375);
        db.insert("JS", null, values);
        values = createEntry("6-10", 0.003, 0.0045, 0.0075, 0.011, 0.018, 0.029, 0.045);
        db.insert("JS", null, values);
        values = createEntry("10-18", 0.004, 0.0055, 0.009, 0.013, 0.0215, 0.035, 0.055);
        db.insert("JS", null, values);
        values = createEntry("18-30", 0.0045, 0.0065, 0.0105, 0.0165, 0.026, 0.042, 0.065);
        db.insert("JS", null, values);
        values = createEntry("30-50", 0.0055, 0.008, 0.0125, 0.0195, 0.031, 0.05, 0.08);
        db.insert("JS", null, values);
        values = createEntry("50-80", 0.0065, 0.0095, 0.015, 0.023, 0.037, 0.06, 0.095);
        db.insert("JS", null, values);
        values = createEntry("80-120", 0.0075, 0.011, 0.0175, 0.027, 0.0435, 0.07, 0.110);
        db.insert("JS", null, values);
        values = createEntry("120-180", 0.009, 0.0125, 0.02, 0.0315, 0.05, 0.08, 0.125);
        db.insert("JS", null, values);
        values = createEntry("180-250", 0.01, 0.0145, 0.023, 0.036, 0.0575, 0.0925, 0.145);
        db.insert("JS", null, values);
        values = createEntry("250-315", 0.0115, 0.016, 0.026, 0.0405, 0.065, 0.105, 0.160);
        db.insert("JS", null, values);
        values = createEntry("315-400", 0.0125, 0.018, 0.0285, 0.0445, 0.07, 0.115, 0.180);
        db.insert("JS", null, values);
        values = createEntry("400-500", 0.0135, 0.02, 0.0315, 0.0485, 0.0775, 0.125, 0.2);
        db.insert("JS", null, values);
    }

    private static  void fillJTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", 0.002, 0.004, 0.006, "6-8");
        db.insert("J", null, values);
        values = createEntry("3-6", 0.005, 0.006, 0.01, "6-8");
        db.insert("J", null, values);
        values = createEntry("6-10", 0.005, 0.008, 0.012, "6-8");
        db.insert("J", null, values);
        values = createEntry("10-18", 0.006, 0.01, 0.015, "6-8");
        db.insert("J", null, values);
        values = createEntry("18-30", 0.008, 0.012, 0.02, "6-8");
        db.insert("J", null, values);
        values = createEntry("30-50", 0.01, 0.014, 0.024, "6-8");
        db.insert("J", null, values);
        values = createEntry("50-80", 0.013, 0.018, 0.028, "6-8");
        db.insert("J", null, values);
        values = createEntry("80-120", 0.016, 0.022, 0.034, "6-8");
        db.insert("J", null, values);
        values = createEntry("120-180", 0.018, 0.026, 0.041, "6-8");
        db.insert("J", null, values);
        values = createEntry("180-250", 0.022, 0.03, 0.047, "6-8");
        db.insert("J", null, values);
        values = createEntry("250-315", 0.025, 0.036, 0.055, "6-8");
        db.insert("J", null, values);
        values = createEntry("315-400", 0.029, 0.039, 0.06, "6-8");
        db.insert("J", null, values);
        values = createEntry("400-500", 0.033, 0.043, 0.066, "6-8");
        db.insert("J", null, values);
    }

    private static void fillKTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", 0.0, 0.0, 0.0, 0.0);
        db.insert("K", null, values);
        values = createEntry("3-6", 0.0, 0.002, 0.003, 0.005);
        db.insert("K", null, values);
        values = createEntry("6-10", 0.001, 0.002, 0.005, 0.006);
        db.insert("K", null, values);
        values = createEntry("10-18", 0.002, 0.002, 0.006, 0.008);
        db.insert("K", null, values);
        values = createEntry("18-30", 0.001, 0.002, 0.006, 0.01);
        db.insert("K", null, values);
        values = createEntry("30-50", 0.002, 0.003, 0.007, 0.012);
        db.insert("K", null, values);
        values = createEntry("50-80", 0.003, 0.004, 0.009, 0.014);
        db.insert("K", null, values);
        values = createEntry("80-120", 0.002, 0.004, 0.01, 0.016);
        db.insert("K", null, values);
        values = createEntry("120-180", 0.003, 0.004, 0.012, 0.02);
        db.insert("K", null, values);
        values = createEntry("180-250", 0.002, 0.005, 0.013, 0.022);
        db.insert("K", null, values);
        values = createEntry("250-315", 0.003, 0.005, 0.016, 0.025);
        db.insert("K", null, values);
        values = createEntry("315-400", 0.003, 0.007, 0.017, 0.028);
        db.insert("K", null, values);
        values = createEntry("400-500", 0.002, 0.008, 0.018, 0.029);
        db.insert("K", null, values);
    }

    private static void fillMTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", -0.002, -0.002, -0.002, -0.002);
        db.insert("M", null, values);
        values = createEntry("3-6", -0.003, -0.001, 0.0, 0.002);
        db.insert("M", null, values);
        values = createEntry("6-10", -0.004, -0.003, 0.0, 0.001);
        db.insert("M", null, values);
        values = createEntry("10-18", -0.004, -0.004, 0.0, 0.002);
        db.insert("M", null, values);
        values = createEntry("18-30", -0.005, -0.004, 0.0, 0.004);
        db.insert("M", null, values);
        values = createEntry("30-50", -0.005, -0.004, 0.0, 0.005);
        db.insert("M", null, values);
        values = createEntry("50-80", -0.006, -0.005, 0.0, 0.005);
        db.insert("M", null, values);
        values = createEntry("80-120", -0.008, -0.006, 0.0, 0.006);
        db.insert("M", null, values);
        values = createEntry("120-180", -0.009, -0.008, 0.0, 0.008);
        db.insert("M", null, values);
        values = createEntry("180-250", -0.011, -0.008, 0.0, 0.009);
        db.insert("M", null, values);
        values = createEntry("250-315", -0.013, -0.009, 0.0, 0.009);
        db.insert("M", null, values);
        values = createEntry("315-400", -0.014, -0.01, 0.0, 0.011);
        db.insert("M", null, values);
        values = createEntry("400-500", -0.016, -0.01, 0.0, 0.011);
        db.insert("M", null, values);
    }

    private static void fillNTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", -0.004, -0.004, -0.004, -0.004, -0.004, -0.004);
        db.insert("N", null, values);
        values = createEntry("3-6", -0.007, -0.005, -0.004, -0.002, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("6-10", -0.008, -0.007, -0.004, -0.003, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("10-18", -0.009, -0.009, -0.005, -0.003, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("18-30", -0.012, -0.011, -0.007, -0.003, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("30-50", -0.013, -0.012, -0.008, -0.003, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("50-80", -0.015, -0.014, -0.009, -0.004, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("80-120", -0.018, -0.016, -0.01, -0.004, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("120-180", -0.021, -0.02, -0.012, -0.004, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("180-250", -0.025, -0.022, -0.014, -0.005, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("250-315", -0.027, -0.025, -0.014, -0.005, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("315-400", -0.03, -0.026, -0.016, -0.005, 0.0, 0.0);
        db.insert("N", null, values);
        values = createEntry("400-500", -0.033, -0.027, -0.017, -0.006, 0.0, 0.0);
        db.insert("N", null, values);
    }

    private static void fillPTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", -0.006, -0.006, -0.006, -0.006, -0.006);
        db.insert("P", null, values);
        values = createEntry("3-6", -0.011, -0.009, -0.008, -0.012, -0.012);
        db.insert("P", null, values);
        values = createEntry("6-10", -0.013, -0.012, -0.009, -0.015, -0.015);
        db.insert("P", null, values);
        values = createEntry("10-18", -0.015, -0.015, -0.011, -0.018, -0.018);
        db.insert("P", null, values);
        values = createEntry("18-30", -0.019, -0.018, -0.014, -0.022, -0.022);
        db.insert("P", null, values);
        values = createEntry("30-50", -0.022, -0.021, -0.017, -0.026, -0.026);
        db.insert("P", null, values);
        values = createEntry("50-80", -0.027, -0.026, -0.021, -0.032, -0.032);
        db.insert("P", null, values);
        values = createEntry("80-120", -0.032, -0.03, -0.024, -0.037, -0.037);
        db.insert("P", null, values);
        values = createEntry("120-180", -0.037, -0.036, -0.028, -0.043, -0.043);
        db.insert("P", null, values);
        values = createEntry("180-250", -0.044, -0.041, -0.033, -0.05, -0.05);
        db.insert("P", null, values);
        values = createEntry("250-315", -0.049, -0.047, -0.036, -0.056, -0.056);
        db.insert("P", null, values);
        values = createEntry("315-400", -0.056, -0.051, -0.041, -0.062, -0.062);
        db.insert("P", null, values);
        values = createEntry("400-500", -0.061, -0.055, -0.045, -0.068, -0.068);
        db.insert("P", null, values);
    }

    private static void fillRTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", -0.01, -0.01, -0.01, "6-8");
        db.insert("R", null, values);
        values = createEntry("3-6", -0.012, -0.011, -0.015, "6-8");
        db.insert("R", null, values);
        values = createEntry("6-10", -0.016, -0.013, -0.019, "6-8");
        db.insert("R", null, values);
        values = createEntry("10-18", -0.02, -0.016, -0.023, "6-8");
        db.insert("R", null, values);
        values = createEntry("18-30", -0.024, -0.02, -0.028, "6-8");
        db.insert("R", null, values);
        values = createEntry("30-50", -0.029, -0.025, -0.034, "6-8");
        db.insert("R", null, values);
        values = createEntry("50-65", -0.035, -0.03, -0.041, "6-8");
        db.insert("R", null, values);
        values = createEntry("65-80", -0.037, -0.032, -0.043, "6-8");
        db.insert("R", null, values);
        values = createEntry("80-100", -0.044, -0.038, -0.051, "6-8");
        db.insert("R", null, values);
        values = createEntry("100-120", -0.047, -0.041, -0.054, "6-8");
        db.insert("R", null, values);
        values = createEntry("120-140", -0.056, -0.048, -0.063, "6-8");
        db.insert("R", null, values);
        values = createEntry("140-160", -0.058, -0.05, -0.065, "6-8");
        db.insert("R", null, values);
        values = createEntry("160-180", -0.061, -0.053, -0.068, "6-8");
        db.insert("R", null, values);
        values = createEntry("180-200", -0.068, -0.06, -0.077, "6-8");
        db.insert("R", null, values);
        values = createEntry("200-225", -0.071, -0.063, -0.08, "6-8");
        db.insert("R", null, values);
        values = createEntry("225-250", -0.075, -0.067, -0.084, "6-8");
        db.insert("R", null, values);
        values = createEntry("250-280", -0.085, -0.074, -0.094, "6-8");
        db.insert("R", null, values);
        values = createEntry("280-315", -0.089, -0.078, -0.098, "6-8");
        db.insert("R", null, values);
        values = createEntry("315-355", -0.097, -0.087, -0.108, "6-8");
        db.insert("R", null, values);
        values = createEntry("355-400", -0.103, -0.093, -0.114, "6-8");
        db.insert("R", null, values);
        values = createEntry("400-450", -0.113, -0.103, -0.126, "6-8");
        db.insert("R", null, values);
        values = createEntry("450-500", -0.119, -0.109, -0.132, "6-8");
        db.insert("R", null, values);
    }

    private static void fillSTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", -0.014, -0.014);
        db.insert("S", null, values);
        values = createEntry("3-6", -0.016, -0.015);
        db.insert("S", null, values);
        values = createEntry("6-10", -0.02, -0.017);
        db.insert("S", null, values);
        values = createEntry("10-18", -0.025, -0.021);
        db.insert("S", null, values);
        values = createEntry("18-30", -0.031,  -0.027);
        db.insert("S", null, values);
        values = createEntry("30-50", -0.038, -0.034);
        db.insert("S", null, values);
        values = createEntry("50-65", -0.047, -0.042);
        db.insert("S", null, values);
        values = createEntry("65-80", -0.053, -0.048);
        db.insert("S", null, values);
        values = createEntry("80-100", -0.064, -0.058);
        db.insert("S", null, values);
        values = createEntry("100-120", -0.072, -0.066);
        db.insert("S", null, values);
        values = createEntry("120-140", -0.085, -0.077);
        db.insert("S", null, values);
        values = createEntry("140-160", -0.093, -0.085);
        db.insert("S", null, values);
        values = createEntry("160-180", -0.101, -0.093);
        db.insert("S", null, values);
        values = createEntry("180-200", -0.113, -0.105);
        db.insert("S", null, values);
        values = createEntry("200-225", -0.121, -0.113);
        db.insert("S", null, values);
        values = createEntry("225-250", -0.131, -0.123);
        db.insert("S", null, values);
        values = createEntry("250-280", -0.149, -0.138);
        db.insert("S", null, values);
        values = createEntry("280-315", -0.161, -0.15);
        db.insert("S", null, values);
        values = createEntry("315-355", -0.179, -0.169);
        db.insert("S", null, values);
        values = createEntry("355-400", -0.197, -0.187);
        db.insert("S", null, values);
        values = createEntry("400-450", -0.219, -0.209);
        db.insert("S", null, values);
        values = createEntry("450-500", -0.239, -0.229);
        db.insert("S", null, values);
    }

    private static void fillItTable(SQLiteDatabase db){
        ContentValues values;
        values = createEntry("1-3", 0.004, 0.006, 0.01, 0.014, 0.025, 0.04, 0.06);
        db.insert("IT", null, values);
        values = createEntry("3-6", 0.005, 0.008, 0.012, 0.018, 0.03, 0.048, 0.075);
        db.insert("IT", null, values);
        values = createEntry("6-10", 0.006, 0.009, 0.015, 0.022, 0.036, 0.058, 0.09);
        db.insert("IT", null, values);
        values = createEntry("10-18", 0.008, 0.011, 0.018, 0.027, 0.043, 0.07, 0.11);
        db.insert("IT", null, values);
        values = createEntry("18-30", 0.009, 0.013, 0.021, 0.033, 0.052, 0.084, 0.13);
        db.insert("IT", null, values);
        values = createEntry("30-50", 0.011, 0.016, 0.025, 0.039, 0.062, 0.1, 0.16);
        db.insert("IT", null, values);
        values = createEntry("50-80", 0.013, 0.019, 0.03, 0.046, 0.074, 0.12, 0.19);
        db.insert("IT", null, values);
        values = createEntry("80-120", 0.015, 0.022, 0.035, 0.054, 0.087, 0.14, 0.22);
        db.insert("IT", null, values);
        values = createEntry("120-180", 0.018, 0.025, 0.04, 0.063, 0.1, 0.16, 0.25);
        db.insert("IT", null, values);
        values = createEntry("180-250", 0.02, 0.029, 0.046, 0.072, 0.115, 0.185, 0.29);
        db.insert("IT", null, values);
        values = createEntry("250-315", 0.023, 0.032, 0.052, 0.081, 0.13, 0.21, 0.32);
        db.insert("IT", null, values);
        values = createEntry("315-400", 0.025, 0.036, 0.057, 0.089, 0.14, 0.23, 0.36);
        db.insert("IT", null, values);
        values = createEntry("400-500", 0.027, 0.04, 0.063, 0.097, 0.155, 0.25, 0.4);
        db.insert("IT", null, values);
    }
}
