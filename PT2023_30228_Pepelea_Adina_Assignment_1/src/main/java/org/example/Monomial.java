package org.example;

public class Monomial {
    //am creat clasa monom, care este alcatuita dintr-un grad si un coeficient, pe care o sa il adaug intr-un polinom
    private double coef;
    private int putere;

    public Monomial(int putere, double coef) {
        this.coef = coef;
        this.putere = putere;
    }

    public Monomial() {
        this(0, 0);
    }

    public int getPutere() {
        //returneaza gradul monomului
        return putere;
    }

    public void setPutere(int putere) {
        //seteaza valoarea parametrului ca fiind puterea monomului
        this.putere = putere;
    }

    public double getCoef() {
        //returneaza coeficientul monomului
        return coef;
    }

    public void setCoef(double coef) {
        //seteaza valoarea parametrului ca fiind coeficientul monomului
        this.coef = coef;
    }

    @Override
    public String toString() {
        //returneaza monomul ca string
        return "Monomial{" +
                "coef=" + coef +
                ", putere=" + putere +
                '}';
    }
}
