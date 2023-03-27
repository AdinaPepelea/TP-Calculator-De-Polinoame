package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {
    @Test
    public void additionTest(){
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
        Polynomial rezultat=operatie1.addition(polinom1, polinom2);
        assertEquals(" + 2.0x^4 + 2.0x^2  -3.0x^1  -3.0x^0", rezultat.toString());
    }

    @Test
    public void substractTest(){
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
        Polynomial rezultat=operatie1.substract(polinom1, polinom2);
        assertEquals(" + 2.0x^4 + 0.0x^2 + 5.0x^1  -3.0x^0", rezultat.toString());
    }

    @Test
    public void multiplicationTest(){
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
        Polynomial rezultat=operatie1.multiplication(polinom1, polinom2);
        assertEquals(" + 2.0x^6  -8.0x^5 + 1.0x^4  -3.0x^3  -7.0x^2 + 12.0x^1", rezultat.toString());
    }

    @Test
    public void derivativeTest(){
        Monomial monom1=new Monomial(4,2);
        Monomial monom2=new Monomial(2,1);
        Monomial monom3=new Monomial(1,1);
        Monomial monom4=new Monomial(0, -3);
        Polynomial polinom1=new Polynomial();
        polinom1.addMonom(monom1);
        polinom1.addMonom(monom2);
        polinom1.addMonom(monom3);
        polinom1.addMonom(monom4);
        Operation operatie1=new Operation();
        Polynomial rezultat=operatie1.derivative(polinom1);
        assertEquals(" + 8.0x^3 + 2.0x^1 + 1.0x^0 + -0.0x^-1", rezultat.toString());
    }

    @Test
    public void integrationTest(){
        Monomial monom1=new Monomial(4,2);
        Monomial monom2=new Monomial(2,1);
        Monomial monom3=new Monomial(1,1);
        Monomial monom4=new Monomial(0, -3);
        Polynomial polinom1=new Polynomial();
        polinom1.addMonom(monom1);
        polinom1.addMonom(monom2);
        polinom1.addMonom(monom3);
        polinom1.addMonom(monom4);
        Operation operatie1=new Operation();
        Polynomial rezultat=operatie1.integration(polinom1);
        assertEquals(" + 0.4x^5 + 0.3333333333333333x^3 + 0.5x^2  -3.0x^1", rezultat.toString());
    }

    @Test
    public void divisionTest(){
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
        assertEquals(" + 2.0x^2 + 8.0x^1 + 33.0x^0", rezultat.toString());
        Operation operatie2=new Operation();
        Polynomial rezultat2=operatie2.division(polinom1, polinom2, false);
        assertEquals(" + 0.0x^4 + 0.0x^3 + 0.0x^2 + 133.0x^1  -3.0x^0", rezultat2.toString());
    }
}
