/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tokio.school.swing.calculadora;

import com.tokio.school.swing.calculadora.frames.CalculadoraFrame;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author andre
 */
public class Calculadora {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(()->new CalculadoraFrame());
        } catch (InterruptedException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
