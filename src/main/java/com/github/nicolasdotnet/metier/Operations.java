/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nicolasdotnet.metier;

/**
 *
 * @author nicolasdotnet
 * @version Alpha
 * @since 2019
 */
public class Operations {
    
    /**
     * fonction d'addition : 
     * @param a
     * @param b
     * @return resultat en double
     */
    public static double addition (double a,double b) {

        
        return a+b;
    
    }
    
    /**
     * fonction soustraction : 
     * @param a
     * @param b
     * @return resultat en double
     */
    public static double soustraction(double a, double b) {

        return a - b;

    }
    
    /**
     * fonction multiplication : 
     * @param a
     * @param b
     * @return resultat en double
     */
    public static double multiplication (double a,double b) {
    
        return a*b;
    
    };
    
    /**
     * fonction division
     * @param a
     * @param b
     * @return resultat en double 
     * @throws IllegalArgumentException
     */
    public static double division (double a,double b) throws IllegalArgumentException{
        if (b==0){
            
            throw new IllegalArgumentException("Fatal basouka");
        
        }
 
    
        return a/b;
    
    }
    
}
