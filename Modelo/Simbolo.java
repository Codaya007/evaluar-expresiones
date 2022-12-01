/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Utilidades.Utilidades;

/**
 *
 * @author vivic
 */
public class Simbolo {

    private Character simbolo = null;
    private String tipo = null;
    private static final Character[] SIMBOLOS_APERTURA = new Character[]{
        '[',
        '(',
        '<',
        '{'
    };
    private static final Character[] SIMBOLOS_CIERRE = new Character[]{
        ']',
        ')',
        '>',
        '}'
    };

    public Simbolo() {
    }

    public Simbolo(Character simbolo) {
        this.tipo = obtenerTipoSimbolo(simbolo);
        this.simbolo = simbolo;
    }

    public Character getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Character simbolo) {
        this.tipo = obtenerTipoSimbolo(simbolo);
        this.simbolo = simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public static Boolean esSimboloValido(Character simbolo) {
        // // System.out.println("En es simbolo válido: " + simbolo);
        
        return Utilidades.contains(SIMBOLOS_APERTURA, simbolo)
                || Utilidades.contains(SIMBOLOS_CIERRE, simbolo);
    }

    public static String obtenerTipoSimbolo(Character simbolo) {
        if (esSimboloValido(simbolo)) {
            return Utilidades.contains(SIMBOLOS_APERTURA, simbolo)
                    ? "Apertura"
                    : "Cierre";
        }

        throw new Error("Símbolo no valido: " + simbolo);
    }

    public Boolean esPar(Simbolo s) {
        Boolean esPar = this.getSimbolo() != null
                && s.getSimbolo() != null
                && !this.getTipo().equals(s.getTipo());
        
        // System.out.println("Primera validacion par: " + esPar);

        if (esPar) {
            Integer indiceDeSimboloEnArray = null;
            Character[] arrayThis = "Apertura".equals(this.tipo) ? SIMBOLOS_APERTURA : SIMBOLOS_CIERRE;
            
            // System.out.println("Arraythis" + arrayThis.toString());

            for (int i = 0; i < arrayThis.length; i++) {
                if (simbolo.equals(arrayThis[i])) {
                    indiceDeSimboloEnArray = i;
                    break;
                }
            }
            
            // System.out.println("Elemento: " + indiceDeSimboloEnArray);

            Character[] arrayComparador = "Apertura".equals(s.getTipo()) ? SIMBOLOS_APERTURA : SIMBOLOS_CIERRE;
            
            // System.out.println("arrayComparador" + arrayComparador.toString());
            
            esPar = indiceDeSimboloEnArray != null && arrayComparador[indiceDeSimboloEnArray].equals(s.getSimbolo());
            
            // System.out.println("Es par 2da: " + esPar);
            //// System.out.println("Comparando si son pares: " + this.getSimbolo() + " - " + s.getSimbolo());
            //// System.out.println("Indice de simbolo en array: " + indiceDeSimboloEnArray);
        }

        return esPar;
    }

    @Override
    public String toString() {
        return this.simbolo.toString();
    }
}
