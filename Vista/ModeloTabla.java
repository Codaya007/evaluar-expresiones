/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Pilas.Excepciones.PilaNullException;
import Controlador.Pilas.Excepciones.TopeException;
import Modelo.Expresion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivic
 */
public class ModeloTabla extends AbstractTableModel  {

    private Expresion expresiones[] = new Expresion[25];

    public int ultimoElementoOcupado() {
        int ocupada = 0;

        for (Expresion expresion : expresiones) {
            if (expresion == null) {
                return ocupada;
            }
            ocupada += 1;
        }

        return ocupada;
    }

    public Expresion[] getExpresions() {
        return expresiones;
    }

    public void setExpresions(Expresion[] expresiones) {
        this.expresiones = expresiones;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return ultimoElementoOcupado();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "ID";
            case 1:
                return "Expresión";
            case 2:
                return "Valida";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Expresion expresion = null;

        try {
            expresion = expresiones[i];
        } catch (Exception ex) {
            System.out.println("Error getValueAt, Modelo tabla" + ex);
        }

        switch (i1) {
            case 0:
                return (i + 1);
            case 1:
                return (expresion != null) ? expresion.toString():"NO DEFINIDO";
            case 2:
            {
                try {
                    return (expresion != null) ? expresion.determinarEsValida(): "NO DEFINIDO";
                } catch (TopeException | PilaNullException | PosicionException | ListaNullException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }

            default:
                return null;
        }
    }

}
