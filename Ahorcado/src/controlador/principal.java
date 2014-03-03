/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Juego;
import vista.Teclado;

/**
 *
 * @author aiza
 */
public class principal {
    
        public static void main(String[] inforusx) throws InterruptedException {
            Juego j=new Juego();
            Teclado t=new Teclado();
            Controlador c = new Controlador(j,t);

    }
}
