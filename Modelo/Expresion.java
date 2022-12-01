/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Pilas.Excepciones.PilaNullException;
import Controlador.Pilas.Excepciones.TopeException;
import Controlador.Pilas.Pila;

/**
 *
 * @author vivic
 */
public class Expresion {

    private String expresion = "";
    private Boolean esValida;
    private Pila pilaSimbolos;
    // private Pila pilaSimbolosValidacion;

    public Expresion() {
        pilaSimbolos = new Pila(25);
    }

    // public Expresion(String expresion){
    //   this.expresion = expresion;
    // } 
    public Pila getPilaSimbolos() {
        return pilaSimbolos;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) throws TopeException {
        this.expresion = expresion;

        for (int i = 0; i < expresion.length(); i++) {
            Character currentCharacter = expresion.charAt(i);
            if (Simbolo.esSimboloValido(currentCharacter)) {
                pilaSimbolos.push(new Simbolo(currentCharacter));
                // pilaSimbolosValidacion.push(new Simbolo(currentCharacter));
            }
        }
    }

    public Boolean getEsValida() {
        return esValida;
    }

    public Boolean determinarEsValida() throws TopeException, PilaNullException, PosicionException, ListaNullException {
        Pila pilaValidacion = new Pila(25);
        // Simbolo ultimoSimboloEnPila = null;
        // Simbolo simbolosIngresados[] = new Simbolo[25];

        for (int i = 0; i < expresion.length(); i++) {
            Character currentCharacter = expresion.charAt(i);

            if (Simbolo.esSimboloValido(currentCharacter)) {
                Simbolo currentSimbolo = new Simbolo(currentCharacter);
                // System.out.println("Simbolo: " + currentSimbolo.toString());

                if (pilaValidacion.estaVacia()) {
                    pilaValidacion.push(currentSimbolo);
                } else {
                    Simbolo ultimoElementoEnPila = (Simbolo) pilaValidacion.pop();

                    // System.out.println(ultimoElementoEnPila.toString() + " - " + currentSimbolo.toString() + " -> " + ultimoElementoEnPila.esPar(currentSimbolo));
                    if (!ultimoElementoEnPila.esPar(currentSimbolo)) {
                        pilaValidacion.push(ultimoElementoEnPila);
                        pilaValidacion.push(currentSimbolo);
                    }
                }
            }
        }

        this.esValida = pilaValidacion.estaVacia();

        System.out.println("La expresion " + this.toString() + " es valida? " + esValida);
        return esValida;
    }

    public Boolean obtenerPilaValidacionPorPasos(Pila pilaValidacion, String restExpresion) throws TopeException, PilaNullException, PosicionException, ListaNullException {

        if (restExpresion.length() == 0) {
            return true;
        }

        Character currentCharacter = restExpresion.charAt(0);

        if (Simbolo.esSimboloValido(currentCharacter)) {
            Simbolo currentSimbolo = new Simbolo(currentCharacter);

            if (pilaValidacion.estaVacia()) {
                pilaValidacion.push(currentSimbolo);
                return false;
            } else {
                Simbolo ultimoElementoEnPila = (Simbolo) pilaValidacion.pop();

                // System.out.println(ultimoElementoEnPila.toString() + " - " + currentSimbolo.toString() + " -> " + ultimoElementoEnPila.esPar(currentSimbolo));
                if (!ultimoElementoEnPila.esPar(currentSimbolo)) {
                    pilaValidacion.push(ultimoElementoEnPila);
                    pilaValidacion.push(currentSimbolo);
                    return false;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.expresion;
    }

}
