/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Utilidades;

/**
 *
 * @author vivic
 */
public class Utilidades {

    public static <T> boolean contains(Character array[], Character c) {
        for (Character i : array) {
            if (i.equals(c)) {
                // System.out.println(c+ " == " + i + " -> true");
                return true;
            }
        }

        return false;
    }
}
