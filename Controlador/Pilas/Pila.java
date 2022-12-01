/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Pilas;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Listas.ListaEnlazada;
import Controlador.Pilas.Excepciones.PilaNullException;
import Controlador.Pilas.Excepciones.TopeException;

/**
 *
 * @author Admin
 */
public class Pila<E> extends ListaEnlazada<E> {

    private Integer tope;

    public Pila(Integer tope) {
        this.tope = tope;
    }

    public Boolean estaLleno() {
        return tope == getSize();
    }

    public void push(E dato) throws TopeException {
        if (!estaLleno()) {
            insertarCabecera(dato);
        } else {
            throw new TopeException();
        }
    }

    public E pop() throws PilaNullException, PosicionException, ListaNullException {
        if (!estaVacia()) {
            E dato = eliminarDato(0);
            return dato;
        } else {
            throw new PilaNullException();
        }
    }
    
    public Object[] toArray() throws ListaNullException, PosicionException{
        Object array[] = new Object[this.tope];
        // System.out.println("Tope: " + this.tope);
        for (int i = 0; i < this.getSize(); i++) {
            // System.out.println(i);
            array[i] = this.obtener(i);
        }
        
        return array;
    }
}
