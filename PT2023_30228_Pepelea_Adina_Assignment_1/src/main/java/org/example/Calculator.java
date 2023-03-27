package org.example;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator{

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Create the application.
     */
    public Calculator() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("1. Polynomial:");
        lblNewLabel.setBounds(10, 10, 101, 30);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("2. Polynomial:");
        lblNewLabel_1.setBounds(10, 64, 101, 30);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Result:");
        lblNewLabel_2.setBounds(10, 124, 101, 30);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Rest:");
        lblNewLabel_3.setBounds(10, 175, 45, 13);
        frame.getContentPane().add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(88, 10, 338, 44);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(88, 70, 338, 44);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(88, 124, 338, 44);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JTextField textField_3 = new JTextField();
        textField_3.setBounds(88, 169, 338, 24);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    Polynomial polinom2=new Polynomial();
                    String polinom1Text=textField.getText();
                    String polinom2Text=textField_1.getText();
                    parsePolinom(polinom1Text, polinom1);
                    parsePolinom(polinom2Text, polinom2);
                    System.out.print(polinom1.toString());
                    System.out.print(polinom2.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.addition(polinom1, polinom2);
                    textField_2.setText(rezultat.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton.setBounds(10, 198, 133, 51);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Substract");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    Polynomial polinom2=new Polynomial();
                    String polinom1Text=textField.getText();
                    String polinom2Text=textField_1.getText();
                    parsePolinom(polinom1Text, polinom1);
                    parsePolinom(polinom2Text, polinom2);
                    System.out.print(polinom1.toString());
                    System.out.print(polinom2.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.substract(polinom1, polinom2);
                    textField_2.setText(rezultat.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton_1.setBounds(167, 198, 120, 51);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Multiplicate");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    Polynomial polinom2=new Polynomial();
                    String polinom1Text=textField.getText();
                    String polinom2Text=textField_1.getText();
                    parsePolinom(polinom1Text, polinom1);
                    parsePolinom(polinom2Text, polinom2);
                    System.out.print(polinom1.toString());
                    System.out.print(polinom2.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.multiplication(polinom1, polinom2);
                    textField_2.setText(rezultat.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton_2.setBounds(309, 198, 117, 51);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Divide");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    Polynomial polinom2=new Polynomial();
                    String polinom1Text=textField.getText();
                    String polinom2Text=textField_1.getText();
                    parsePolinom(polinom1Text, polinom1);
                    parsePolinom(polinom2Text, polinom2);
                    System.out.print(polinom1.toString());
                    System.out.print(polinom2.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.division(polinom1, polinom2, true);
                    textField_2.setText(rezultat.toString());
                    Operation operatie2=new Operation();
                    Polynomial rezultat2=operatie1.division(polinom1, polinom2, false);
                    textField_3.setText(rezultat2.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton_3.setBounds(10, 259, 133, 44);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Derivate");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    String polinom1Text=textField.getText();
                    parsePolinom(polinom1Text, polinom1);
                    System.out.print(polinom1.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.derivative(polinom1);
                    textField_2.setText(rezultat.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton_4.setBounds(167, 259, 120, 44);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Integrate");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Polynomial polinom1=new Polynomial();
                    String polinom1Text=textField.getText();
                    parsePolinom(polinom1Text, polinom1);
                    System.out.print(polinom1.toString());
                    Operation operatie1=new Operation();
                    Polynomial rezultat=operatie1.integration(polinom1);
                    textField_2.setText(rezultat.toString());
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid number");
                }
            }
        });
        btnNewButton_5.setBounds(309, 259, 117, 44);
        frame.getContentPane().add(btnNewButton_5);
    }
    public void parsePolinom(String input, Polynomial polinom){
        Pattern p = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");
        Matcher m = p.matcher(input);
        while(m.find()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            Monomial monom= new Monomial();
            monom.setCoef(Double.parseDouble(m.group(1)));
            monom.setPutere(Integer.parseInt(m.group(2)));
            polinom.addMonom(monom);
        }
    }
}

