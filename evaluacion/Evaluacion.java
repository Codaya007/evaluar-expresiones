/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

// import Modelo.Expresion;
import Vista.frmInicio;

/**
 *
 * @author vivic
 */
public class Evaluacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Expresion expresionUno = new Expresion();
            // expresionUno.setExpresion("((7) ((8) (9)) (4) )");

            // Expresion expresionDos = new Expresion();
            // expresionDos.setExpresion("([4] {(7)} (9))");

            // Expresion expresionTres = new Expresion();
            // expresionTres.setExpresion("([4((((");

            // expresionUno.determinarEsValida();
            // expresionDos.determinarEsValida();
            // expresionTres.determinarEsValida();
            
            new frmInicio().setVisible(true);

        } catch (Exception e) {
            System.out.println("Error en main: " + e);
            e.printStackTrace();
        }
    }

}
