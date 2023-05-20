/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.validaciones;

import java.util.regex.Pattern;

/**
 *
 * @author BYRON
 */
public class Validar {
    
    public static boolean isNumeric(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }
}
