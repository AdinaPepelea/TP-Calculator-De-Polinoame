package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Double> polynom = new TreeMap<Integer, Double>(Collections.<Integer>reverseOrder());

    public TreeMap<Integer, Double> getPolynom() {
        //returneaza polinomul
        return polynom;
    }

    public void setPolynom(TreeMap<Integer, Double> polynom) {
        this.polynom = polynom;
    }

    public void addMonom(Monomial monom)
    {
        //cu aceasta functie adaug cate un monom in polinom
            polynom.put(monom.getPutere(), monom.getCoef());
    }

    public int gradMax(){
        //returneaza gradul maxim al polinomului
        int max=-32000;
        for (Map.Entry<Integer, Double> monom1 : polynom.entrySet()){
            if(monom1.getKey()>max)
                max=monom1.getKey();
        }
        return max;
    }

    public double coeficientMonom(int i){
        //returneaza coeficientul monomului care are puterea cu numarul parametrului pe care il dam functiei, in polinom
        double coef=0;
        for (Map.Entry<Integer, Double> monom1 : polynom.entrySet()){
            if(monom1.getKey()==i){
                coef=monom1.getValue();
            }
        }
        return coef;
    }

    @Override
    public String toString() {
        //returneaza polinomul ca string
        String result="";
        if(polynom.isEmpty()){
            result="0";
        }
        else{
            for(Map.Entry<Integer, Double> monom : polynom.entrySet()){
                if(monom.getValue() >=0)
                    result=result + " + " + monom.getValue() + "x^" + monom.getKey();
                else result=result + "  " + monom.getValue() + "x^" + monom.getKey();
            }
        }
        return result;
    }
}
