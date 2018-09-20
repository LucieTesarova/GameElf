package com.example.lucie.mygame1;

public class Item {

    private int id;
    private String hlavniText;
    private String odpovedA;
    private String odpovedB;
    private String odkazA;
    private String odkazB;

    public Item(int id, String hlavniText, String odpovedA, String odpovedB, String odkazA, String odkazB) {
        this.id = id;
        this.hlavniText = hlavniText;
        this.odpovedA = odpovedA;
        this.odpovedB = odpovedB;
        this.odkazA = odkazA;
        this.odkazB = odkazB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHlavniText() {
        return hlavniText;
    }

    public void setHlavniText(String hlavniText) {
        this.hlavniText = hlavniText;
    }

    public String getOdpovedA() {
        return odpovedA;
    }

    public void setOdpovedA(String odpovedA) {
        this.odpovedA = odpovedA;
    }

    public String getOdpovedB() {
        return odpovedB;
    }

    public void setOdpovedB(String odpovedB) {
        this.odpovedB = odpovedB;
    }

    public String getOdkazA() {
        return odkazA;
    }

    public void setOdkazA(String odkazA) {
        this.odkazA = odkazA;
    }

    public String getOdkazB() {
        return odkazB;
    }

    public void setOdkazB(String odkazB) {
        this.odkazB = odkazB;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", hlavniText='" + hlavniText + '\'' +
                ", odpovedA='" + odpovedA + '\'' +
                ", odpovedB='" + odpovedB + '\'' +
                ", odkazA='" + odkazA + '\'' +
                ", odkazB='" + odkazB + '\'' +
                '}';
    }
}
