/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nicolasdotnet.vue;

import com.github.nicolasdotnet.metier.Operations;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pi
 */
public class Window extends JFrame {

    private final JPanel contenair = new JPanel();
    private final JPanel nbrPanel = new JPanel();
    private final JPanel opePanel = new JPanel();
    private JLabel panneau;
    private int counter = 0;
    private double a = 0;
    StringBuilder sb = new StringBuilder(10);

    public Window() {

        // default setting
        this.setTitle("::: Calculator :::");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(false);

        // widget creation
        contenair.setLayout(new BorderLayout());
        clavNumbers("0");
        clavOpe("0");
        panneau = panneau();
        contenair.add(nbrPanel, BorderLayout.CENTER);
        contenair.add(opePanel, BorderLayout.EAST);
        contenair.add(panneau, BorderLayout.NORTH);
        this.setContentPane(contenair);

        // default setting visibility
        this.setVisible(true);

    }

    private String clavNumbers(String a) {

        nbrPanel.setLayout(new GridLayout(4, 3));

        String carac[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "="};

        for (int i = 0; i <= 11; i++) {

            String nbr = carac[i];

            JButton bouton = new JButton(nbr);

            nbrPanel.add(bouton);

            bouton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {

                    sb.append(bouton.getText());
                    panneau.setText(sb.toString());

                }
            });

        }

        return sb.toString();

    }

    private void clavOpe(String sbString) {

        double sbDouble = Double.parseDouble(sbString);

        ArrayList l = new ArrayList();

        opePanel.setLayout(new GridLayout(5, 1) {

        });

        String carac[] = {"C", "+", "-", "*", "/"};

        for (int i = 0; i <= 4; i++) {

            String nbr = carac[i];

            JButton bouton = new JButton(nbr);

            opePanel.add(bouton);

            bouton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {

                    if (l.isEmpty() && counter == 0) {

                        counter++;

                        l.add(bouton.getText());

                    } else if (counter == 2) {

//                        l.removeAll(l);
                        clavNumbers(bouton.getText());
                        counter++;

                    } else {
                        
                        counter++;
                        String r = l.get(0).toString();

                        switch (r) {
                            case "+":

                                System.out.println("sbdouble"+sbDouble);
                                Double resultat = Operations.addition(a, sbDouble);
                                System.out.println("resultat"+resultat);
                                Window.this.a = resultat;
                                panneau.setText(Double.toString(resultat));
                                sb.delete(0,9);

                                break;
                            case "-":

                                panneau.setText(Double.toString(Operations.soustraction(a, sbDouble)));

                                break;
                        }

                        System.out.println("hoolle " + l.get(0));

                        panneau.setText(l.get(0).toString());

//                        l.removeAll(l);
                    }

                }

            }
            );

        }
    }

    private JLabel panneau() {

        JLabel panneau = new JLabel("0");
        Font police = new Font("Tahoma", Font.BOLD, 25);
        panneau.setFont(police);
        panneau.setHorizontalAlignment(JLabel.RIGHT);

        return panneau;

    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//
//        List l = new LinkedList();
//
//        StringBuilder sb = new StringBuilder(10);
//
//        String r = ((JButton) ae.getSource()).getText();
//
//        switch (r) {
//            case "1":
//                panneau.setText("1");
//                sb.append("1");
//                String Item = sb.toString();
//
//                System.out.println(Item);
//                break;
//            case "2":
//                panneau.setText("2");
//                sb.append("2");
//                break;
//        }
//
//        if (((JButton) ae.getSource()).getText().equals("0")) {
//
//            String Item = sb.toString();
//            panneau.setText(Item);
//            System.out.println(Item);
//
//        } else {
//
//            System.out.println("Ecoute");
//            double resul=Operations.addition(10, 25);
//            panneau.setText(Double.toString(resul));
//
//        }
}
