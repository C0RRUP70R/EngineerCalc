package com.example.bptestingapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bptestingapp.auxiliary.DbEntries;
import com.example.bptestingapp.models.Material;
import com.example.bptestingapp.models.ToleranceField;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by C0RRUP70R on 13.07.2017.
 */

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EnginnerDB";
    private static final String TABLE_NAME = "Materials";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_STATIC_THRUST = "static_thrust";
    private static final String KEY_STATIC_PRESSURE = "static_pressure";
    private static final String KEY_STATIC_BEND = "static_bend";
    private static final String KEY_STATIC_CUT = "static_cut";
    private static final String KEY_PASSIVE_THRUST = "passive_thrust";
    private static final String KEY_PASSIVE_PRESSURE = "passive_pressure";
    private static final String KEY_PASSIVE_BEND = "passive_bend";
    private static final String KEY_PASSIVE_CUT = "passive_cut";
    private static final String KEY_ALTERNATE_THRUST = "alternate_thrust";
    private static final String KEY_ALTERNATE_PRESSURE = "alternate_pressure";
    private static final String KEY_ALTERNATE_BEND = "alternate_bend";
    private static final String KEY_ALTERNATE_CUT = "alternate_cut";

    private static final String[] COLUMNS = {
            KEY_ID,
            KEY_NAME,
            KEY_STATIC_THRUST,
            KEY_STATIC_PRESSURE,
            KEY_STATIC_BEND,
            KEY_STATIC_CUT,
            KEY_PASSIVE_THRUST,
            KEY_PASSIVE_PRESSURE,
            KEY_PASSIVE_BEND,
            KEY_PASSIVE_CUT,
            KEY_ALTERNATE_THRUST,
            KEY_ALTERNATE_PRESSURE,
            KEY_ALTERNATE_BEND,
            KEY_ALTERNATE_CUT
    };

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       /* String CREATION_TABLE = "CREATE TABLE Materials ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "thrust INTEGER, " + "pressure INTEGER, " + "bend INTEGER, " + "cut INTEGER)";*/

        String CREATION_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " +
                KEY_STATIC_THRUST + " INTEGER, " +
                KEY_STATIC_PRESSURE + " INTEGER, " +
                KEY_STATIC_BEND + " INTEGER, " +
                KEY_STATIC_CUT + " INTEGER, " +
                KEY_PASSIVE_THRUST + " INTEGER, " +
                KEY_PASSIVE_PRESSURE + " INTEGER, " +
                KEY_PASSIVE_BEND + " INTEGER, " +
                KEY_PASSIVE_CUT + " INTEGER, " +
                KEY_ALTERNATE_THRUST + " INTEGER, " +
                KEY_ALTERNATE_PRESSURE + " INTEGER, " +
                KEY_ALTERNATE_BEND + " INTEGER, " +
                KEY_ALTERNATE_CUT + " INTEGER)";
        db.execSQL(CREATION_TABLE);

        createDbMaterialEntries(db);
        DbEntries.crateDbEntries(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    private void createDbMaterialEntries(SQLiteDatabase db) {
        ContentValues values = createMaterialEntry("11343", 90, 90, 100, 55, 75, 75, 85, 45, 60, 60, 65, 35);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("11373", 100, 100, 110, 65, 65, 65, 70, 40, 45, 45, 50, 30);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("11423", 115, 115, 120, 70, 75, 75, 80, 45, 55, 55, 60, 35);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("11500", 140, 140, 150, 85, 90, 90, 100, 55, 65, 65, 70, 40);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("11600", 150, 150, 170, 105, 110, 110, 125, 65, 75, 75, 85, 50);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("11700", 210, 210, 230, 125, 135, 135, 150, 80, 90, 90, 105, 60);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("12020", 115, 115, 125, 70, 95, 95, 105, 45, 75, 75, 80, 33);
        db.insert(TABLE_NAME, null, values);
        values = createMaterialEntry("12060", 175, 175, 190, 110, 150, 150, 120, 70, 115, 115, 85, 50);
        db.insert(TABLE_NAME, null, values);
    }

    private ContentValues createMaterialEntry(String name, int static_thrust, int static_pressure, int static_bend, int static_cut,
                                              int passive_thrust, int passive_pressure, int passive_bend, int passive_cut,
                                              int alternate_thrust, int alternate_pressure, int alternate_bend, int alternate_cut) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_STATIC_THRUST, static_thrust);
        values.put(KEY_STATIC_PRESSURE, static_pressure);
        values.put(KEY_STATIC_BEND, static_bend);
        values.put(KEY_STATIC_CUT, static_cut);
        values.put(KEY_PASSIVE_THRUST, passive_thrust);
        values.put(KEY_PASSIVE_PRESSURE, passive_pressure);
        values.put(KEY_PASSIVE_BEND, passive_bend);
        values.put(KEY_PASSIVE_CUT, passive_cut);
        values.put(KEY_ALTERNATE_THRUST, alternate_thrust);
        values.put(KEY_ALTERNATE_PRESSURE, alternate_pressure);
        values.put(KEY_ALTERNATE_BEND, alternate_bend);
        values.put(KEY_ALTERNATE_CUT, alternate_cut);
        return values;
    }

    public Material getMaterial(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " name = ?", // c. selections
                new String[]{String.valueOf(name)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit*/

        if (cursor != null)
            cursor.moveToFirst();

        Material material = new Material();
        material.setId(cursor.getInt(cursor.getColumnIndex("id")));
        material.setName(cursor.getString(cursor.getColumnIndex("name")));
        material.setStatic_thrust(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_THRUST)));
        material.setStatic_pressure(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_PRESSURE)));
        material.setStatic_bend(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_BEND)));
        material.setStatic_cut(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_CUT)));
        material.setPassive_thrust(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_THRUST)));
        material.setPassive_pressure(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_PRESSURE)));
        material.setPassive_bend(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_BEND)));
        material.setPassive_cut(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_CUT)));
        material.setAlternate_thrust(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_THRUST)));
        material.setAlternate_pressure(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_PRESSURE)));
        material.setAlternate_bend(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_BEND)));
        material.setAlternate_cut(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_CUT)));

        return material;
    }

    public int getMaterialProperty(String name, String property) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                new String[]{String.valueOf(property)}, // b. column names
                " name = ?", // c. selections
                new String[]{String.valueOf(name)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit*/

        if (cursor != null)
            cursor.moveToFirst();

        return cursor.getInt(cursor.getColumnIndex(property));
    }

    public List<Material> allMaterials() {

        List<Material> materials = new LinkedList<Material>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Material material = null;

        if (cursor.moveToFirst()) {
            do {
                material = new Material();
                material.setId(cursor.getInt(cursor.getColumnIndex("id")));
                material.setName(cursor.getString(cursor.getColumnIndex("name")));
                material.setStatic_thrust(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_THRUST)));
                material.setStatic_pressure(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_PRESSURE)));
                material.setStatic_bend(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_BEND)));
                material.setStatic_cut(cursor.getInt(cursor.getColumnIndex(KEY_STATIC_CUT)));
                material.setPassive_thrust(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_THRUST)));
                material.setPassive_pressure(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_PRESSURE)));
                material.setPassive_bend(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_BEND)));
                material.setPassive_cut(cursor.getInt(cursor.getColumnIndex(KEY_PASSIVE_CUT)));
                material.setAlternate_thrust(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_THRUST)));
                material.setAlternate_pressure(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_PRESSURE)));
                material.setAlternate_bend(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_BEND)));
                material.setAlternate_cut(cursor.getInt(cursor.getColumnIndex(KEY_ALTERNATE_CUT)));
                materials.add(material);
            } while (cursor.moveToNext());
        }

        return materials;
    }

    public double getFieldTolerance(String name, String range, String it){
        SQLiteDatabase db = this.getReadableDatabase();
       /*String query = "SELECT " + it + " FROM " + name + " WHERE range = '" + range + "'" ;
        Cursor cursor = db.rawQuery(query, null);*/
       Cursor cursor = db.query(name, // a. table
                new String[]{it}, // b. column names
                " range = ?", // c. selections
                new String[]{String.valueOf(range)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        double field = cursor.getDouble(cursor.getColumnIndex(it));
        return field;
    }


}
