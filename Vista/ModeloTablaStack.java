/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Expresion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivic
 */
public class ModeloTablaStack extends AbstractTableModel  {

    private Object pasos[] = null;
    Expresion expresion;

    public int ultimoElementoOcupado() {
        int ocupada = 0;

        for (Object simbolo: pasos) {
            if (simbolo == null) {
                return ocupada;
            }
            ocupada += 1;
        }

        return ocupada;
    }

    public Object[] getPasos() {
        return pasos;
    }

    public void setPasos(Object[] pasos) {
        this.pasos = pasos;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }


    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getRowCount() {
        return ultimoElementoOcupado();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return expresion != null ? "Expresión: " + expresion.getExpresion() : "No definida" ;
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return pasos[i] != null ? pasos[i].toString(): " - ";
            default:
                return null;
        }
    }

}
