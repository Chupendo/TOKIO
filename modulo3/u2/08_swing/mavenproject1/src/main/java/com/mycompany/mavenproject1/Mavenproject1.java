/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.windows.Windows1;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

/**
 *
 * @author andre
 */
public class Mavenproject1 {

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        System.out.println("Hello World!");
        SwingUtilities.invokeAndWait(()->new Windows1().setVisible(true));
    }
}
