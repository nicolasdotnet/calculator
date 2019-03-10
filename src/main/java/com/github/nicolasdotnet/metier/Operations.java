/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nicolasdotnet.metier;

/**
 *
 * @author pi
 */
public class Operations {
    
    
    
    
    public static double addition (double a,double b) {

        
        return a+b;
    
    }
    
    
    
    public static double soustraction(double a, double b) {

        return a - b;

    }
    
    public static double multiplication (double a,double b) {
    
        return a*b;
    
    };
    
    
    public static double division (double a,double b) throws IllegalArgumentException{
        if (b==0){
            
            throw new IllegalArgumentException("Fatal basouka");
        
        }
 
    
        return a/b;
    
    }
    
}
