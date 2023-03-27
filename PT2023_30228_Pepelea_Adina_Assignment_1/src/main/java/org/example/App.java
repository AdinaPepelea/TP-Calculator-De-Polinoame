package org.example;

import java.awt.*;

public class App
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator window = new Calculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /*Monomial monom1=new Monomial(2,2);
        Monomial monom2=new Monomial(3,1);
        Monomial monom3=new Monomial(2,3);
        Monomial monom4=new Monomial(1, 2);
        Polynomial polinom1=new Polynomial();
        polinom1.addMonom(monom1);
        polinom1.addMonom(monom2);
        Polynomial polinom2=new Polynomial();
        polinom2.addMonom(monom3);
        polinom2.addMonom(monom4);
        Operation operatie1=new Operation();
        Polynomial rezultat=operatie1.addition(polinom1, polinom2);
        System.out.println(rezultat.toString());
        Polynomial rezultat2=operatie1.substract(polinom1, polinom2);
        System.out.println(rezultat2.toString());
        Polynomial rezultat3=operatie1.multiplication(polinom1, polinom2);
        System.out.println(rezultat3.toString());
        Polynomial rezultat4=operatie1.derivative(polinom1);
        System.out.println(rezultat4.toString());*/

        /*
        Monomial monom1=new Monomial(4,2);
        Monomial monom2=new Monomial(2,1);
        Monomial monom3=new Monomial(1,1);
        Monomial monom4=new Monomial(0, -3);
        Polynomial polinom1=new Polynomial();
        polinom1.addMonom(monom1);
        polinom1.addMonom(monom2);
        polinom1.addMonom(monom3);
        polinom1.addMonom(monom4);
        Monomial monom5=new Monomial(2,1);
        Monomial monom6=new Monomial(1,-4);
        Polynomial polinom2=new Polynomial();
        polinom2.addMonom(monom5);
        polinom2.addMonom(monom6);
        Operation operatie1=new Operation();
        Polynomial rezultat=operatie1.division(polinom1, polinom2, true);
        System.out.println(rezultat.toString());
         */
    }
}
