package com.example.bptestingapp.models;

/**
 * Created by C0RRUP70R on 13.07.2017.
 */

public class Material {

    private int id;
    private String name;
    private int static_thrust;
    private int static_pressure;
    private int static_bend;
    private int static_cut;
    private int passive_thrust;
    private int passive_pressure;
    private int passive_bend;
    private int passive_cut;
    private int alternate_thrust;
    private int alternate_pressure;
    private int alternate_bend;
    private int alternate_cut;

    public Material(int id, String name,
                    int static_hrust, int static_pressure, int static_bend, int static_cut,
                    int passive_hrust, int passive_pressure, int passive_bend, int passive_cut,
                    int alternate_hrust, int alternate_pressure, int alternate_bend, int alternate_cut) {
        this.id = id;
        this.name = name;
        this.static_thrust = static_hrust;
        this.static_pressure = static_pressure;
        this.static_bend = static_bend;
        this.static_cut = static_cut;
        this.passive_thrust = passive_hrust;
        this.passive_pressure = passive_pressure;
        this.passive_bend = passive_bend;
        this.passive_cut = passive_cut;
        this.alternate_thrust = alternate_hrust;
        this.alternate_pressure = alternate_pressure;
        this.alternate_bend = alternate_bend;
        this.alternate_cut = alternate_cut;
    }

    public Material() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatic_thrust() {
        return static_thrust;
    }

    public void setStatic_thrust(int static_hrust) {
        this.static_thrust = static_hrust;
    }

    public int getStatic_pressure() {
        return static_pressure;
    }

    public void setStatic_pressure(int static_pressure) {
        this.static_pressure = static_pressure;
    }

    public int getStatic_bend() {
        return static_bend;
    }

    public void setStatic_bend(int static_bend) {
        this.static_bend = static_bend;
    }

    public int getStatic_cut() {
        return static_cut;
    }

    public void setStatic_cut(int static_cut) {
        this.static_cut = static_cut;
    }

    public int getPassive_thrust() {
        return passive_thrust;
    }

    public void setPassive_thrust(int passive_hrust) {
        this.passive_thrust = passive_hrust;
    }

    public int getPassive_pressure() {
        return passive_pressure;
    }

    public void setPassive_pressure(int passive_pressure) {
        this.passive_pressure = passive_pressure;
    }

    public int getPassive_bend() {
        return passive_bend;
    }

    public void setPassive_bend(int passive_bend) {
        this.passive_bend = passive_bend;
    }

    public int getPassive_cut() {
        return passive_cut;
    }

    public void setPassive_cut(int passive_cut) {
        this.passive_cut = passive_cut;
    }

    public int getAlternate_thrust() {
        return alternate_thrust;
    }

    public void setAlternate_thrust(int alternate_hrust) {
        this.alternate_thrust = alternate_hrust;
    }

    public int getAlternate_pressure() {
        return alternate_pressure;
    }

    public void setAlternate_pressure(int alternate_pressure) {
        this.alternate_pressure = alternate_pressure;
    }

    public int getAlternate_bend() {
        return alternate_bend;
    }

    public void setAlternate_bend(int alternate_bend) {
        this.alternate_bend = alternate_bend;
    }

    public int getAlternate_cut() {
        return alternate_cut;
    }

    public void setAlternate_cut(int alternate_cut) {
        this.alternate_cut = alternate_cut;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", static_thrust=" + static_thrust +
                ", static_pressure=" + static_pressure +
                ", static_bend=" + static_bend +
                ", static_cut=" + static_cut +
                ", passive_thrust=" + passive_thrust +
                ", passive_pressure=" + passive_pressure +
                ", passive_bend=" + passive_bend +
                ", passive_cut=" + passive_cut +
                ", alternate_thrust=" + alternate_thrust +
                ", alternate_pressure=" + alternate_pressure +
                ", alternate_bend=" + alternate_bend +
                ", alternate_cut=" + alternate_cut +
                '}';
    }
}
