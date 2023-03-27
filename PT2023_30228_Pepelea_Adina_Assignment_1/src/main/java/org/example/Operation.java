package org.example;

import org.example.Monomial;
import org.example.Polynomial;

import java.util.Map;

public class Operation {
    //aici am implementat cele 6 operatii ale temei
    public Polynomial addition(Polynomial p1, Polynomial p2) {
        //se primesc 2 polinoame si se returneaza unul singur, fiind suma lor
        Polynomial polinomRez = new Polynomial();
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            for (Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
                if (monom1.getKey() == monom2.getKey()) {
                    polinomRez.addMonom(new Monomial(monom1.getKey(), monom1.getValue() + monom2.getValue()));
                }
            }
        }
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            if (polinomRez.getPolynom().containsKey(monom1.getKey()) == false) {
                polinomRez.addMonom(new Monomial(monom1.getKey(), monom1.getValue()));
            }
        }
        for (Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
            if (polinomRez.getPolynom().containsKey(monom2.getKey()) == false) {
                polinomRez.addMonom(new Monomial(monom2.getKey(), monom2.getValue()));
            }
        }
        return polinomRez;
    }

    public Polynomial substract(Polynomial p1, Polynomial p2) {
        //se primesc 2 polinoame si se returneaza unul singur, fiind diferenta lor
        Polynomial polinomRez = new Polynomial();
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            for (Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
                if (monom1.getKey() == monom2.getKey()) {
                    polinomRez.addMonom(new Monomial(monom1.getKey(), monom1.getValue() - monom2.getValue()));
                }
            }
        }
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            if (polinomRez.getPolynom().containsKey(monom1.getKey()) == false) {
                polinomRez.addMonom(new Monomial(monom1.getKey(), monom1.getValue()));
            }
        }
        for (Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
            if (polinomRez.getPolynom().containsKey(monom2.getKey()) == false) {
                polinomRez.addMonom(new Monomial(monom2.getKey(), -monom2.getValue()));
            }
        }
        return polinomRez;
    }

    public Polynomial multiplication(Polynomial p1, Polynomial p2) {
        //se primesc 2 polinoame si se returneaza unul singur, fiind inmultirea lor
        Polynomial polinomRez = new Polynomial();
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            for (Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
                //polinomRez.addMonom(new Monomial(monom1.getKey()+monom2.getKey(), monom1.getValue() * monom2.getValue()));
                Monomial monomRez = new Monomial();
                monomRez.setCoef(monom1.getValue() * monom2.getValue());
                monomRez.setPutere(monom1.getKey() + monom2.getKey());
                if (polinomRez.getPolynom().containsKey(monomRez.getPutere()) == true) {
                    monomRez.setCoef(monomRez.getCoef() + polinomRez.getPolynom().get(monomRez.getPutere()));
                }
                polinomRez.addMonom(monomRez);
            }
        }
        return polinomRez;
    }

    public Polynomial derivative(Polynomial p1) {
        //se primeste 1 polinom si se returneaza derivata lui
        Polynomial polinomRez = new Polynomial();
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            Monomial monomRez = new Monomial();
            monomRez.setCoef(monom1.getKey() * monom1.getValue());
            monomRez.setPutere(monom1.getKey() - 1);
            polinomRez.addMonom(monomRez);
        }
        return polinomRez;
    }

    public Polynomial integration(Polynomial p1) {
        //se primeste 1 polinom si se returneaza integrata lui
        Polynomial polinomRez = new Polynomial();
        for (Map.Entry<Integer, Double> monom1 : p1.getPolynom().entrySet()) {
            Monomial monomRez = new Monomial();
            monomRez.setCoef(monom1.getValue() / (monom1.getKey() + 1));
            monomRez.setPutere(monom1.getKey() + 1);
            polinomRez.addMonom(monomRez);
        }
        return polinomRez;
    }
public Polynomial division(Polynomial p1, Polynomial p2, boolean select) {
    //se primesc 2 polinoame si se returneaza unul singur
    //pentru a returna rezultatul impartirii celor 2 polinoame, punem ca al treilea parametru "true"
    //pentru a returna restul impartirii celor 2 polinoame, punem ca al treilea parametru "false"
    Polynomial result=new Polynomial();
    Polynomial rest=new Polynomial();
    Polynomial polinomAux=new Polynomial();
    int gradp1= p1.gradMax();
    int gradp2= p2.gradMax();
    while(gradp1>=gradp2){
        polinomAux.getPolynom().clear();
        int putereDivizor=gradp1-gradp2;
        double coefDivizor=p1.coeficientMonom(gradp1)/p2.coeficientMonom(gradp2);
        Monomial monomAux = new Monomial();
        monomAux.setCoef(coefDivizor);
        monomAux.setPutere(putereDivizor);
        result.addMonom(monomAux);
        for(Map.Entry<Integer, Double> monom2 : p2.getPolynom().entrySet()) {
            Monomial monomAux1=new Monomial();
            monomAux1.setCoef(-(monom2.getValue()*coefDivizor));
            monomAux1.setPutere(monom2.getKey()+putereDivizor);
            polinomAux.addMonom(monomAux1);
        }
        Operation operatie1=new Operation();
        rest=operatie1.addition(p1, polinomAux);
        p1=rest;
        gradp1--;
    }
    if(select==true) return result;
    else return rest;
}

}
