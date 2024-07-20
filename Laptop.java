package org.example.Seminar6.Hom;

public class Laptop {
    private String model;
    private int RAM;
    private int HDD;
    private String OS;
    private String Color;

    public Laptop(String model, int RAM, int HDD, String OS, String Color) {
        this.model = model;
        this.RAM = RAM;
        this.HDD = HDD;
        this.OS = OS;
        this.Color = Color;
    }
    public int getRam() {
        return RAM;
    }
    public int getHdd() {
        return HDD;
    }
    public String getOs() {
        return OS;
    }
    public String getColor() {
        return Color;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", RAM=" + RAM +
                ", HDD=" + HDD +
                ", OS='" + OS + '\'' +
                ", Color='" + Color + '\'' +
                '}';
   }
}
