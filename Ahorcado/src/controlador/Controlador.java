
package controlador;
import com.sun.media.sound.MidiUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modelo.Juego;
import vista.Game;
import vista.Teclado;
import vista.Temporizador;

/**
 *
 * @author aiza
 */
public class Controlador implements ActionListener{
    Juego   juego;
    Teclado teclado;
    String  palabraAnterior, palabraPosterior, palabraPrincipal, palabraVisible;
    int     errores=0;
    Temporizador tiempo;
    Game    dibujo;
    private JMenuBar menuprincipal;
    private JMenu menu;
    private JMenuItem opcion1, opcion2, opcion3;
    
    public Controlador(Juego j, Teclado t) throws InterruptedException{
     
    juego       =   j;
    teclado     =   t;
    this.dibujo      =   teclado.getDibujo();
    this.tiempo      =   teclado.getTemporizador();
    agregarOyente();
    
        menuprincipal=new JMenuBar();
        teclado.pegarMenu(menuprincipal);
        menu=new JMenu("Opciones");
        menuprincipal.add(menu);
        opcion1=new JMenuItem("Reiniciar");
        opcion1.addActionListener(this);
        menu.add(opcion1);
        menu.add(new JSeparator());
        opcion2=new JMenuItem("Exit");
        opcion2.addActionListener(this);
        menu.add(opcion2);
        teclado.bloquearBotones();
    
    }
    
        public void agregarOyente() {
        teclado.botonq.addActionListener(this);
        teclado.botonw.addActionListener(this);
        teclado.botone.addActionListener(this);
        teclado.botonr.addActionListener(this);
        teclado.botont.addActionListener(this);
        teclado.botony.addActionListener(this);
        teclado.botonu.addActionListener(this);
        teclado.botoni.addActionListener(this);
        teclado.botono.addActionListener(this);
        teclado.botonp.addActionListener(this);
        teclado.botona.addActionListener(this);
        teclado.botons.addActionListener(this);
        teclado.botond.addActionListener(this);
        teclado.botonf.addActionListener(this);
        teclado.botong.addActionListener(this);

        teclado.botonh.addActionListener(this);
        teclado.botonj.addActionListener(this);
        teclado.botonk.addActionListener(this);
        teclado.botonl.addActionListener(this);
        teclado.botonz.addActionListener(this);
        teclado.botonx.addActionListener(this);
        teclado.botonc.addActionListener(this);
        teclado.botonv.addActionListener(this);
        teclado.botonb.addActionListener(this);
        teclado.botonn.addActionListener(this);
        teclado.botonm.addActionListener(this);
        teclado.play  .addActionListener(this);

    }
        public void dibujador(int n) throws InterruptedException{
        if(n==1){
            teclado.dibujo.dibujarCabeza();
        }
        if(n==2){
            teclado.dibujo.dibujarBrazoDerecho();
            teclado.dibujo.dibujarManoDerecho();
        }
        if(n==3){
            teclado.dibujo.dibujarManoIzquierda();
            
        }
        if(n==4){
            teclado.dibujo.dibujarCuerpo();
            
        }
        if(n==5){
            teclado.dibujo.dibujarPiernaDerecha();
        }
        if(n==6){
            teclado.dibujo.dibujarPiernaIzquierda();
        }
        if(n==7){
            teclado.dibujo.dibujarCuerda();
            tiempo.setJugada("perdiste");
        }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==opcion1){ // reiniciar
             palabraPrincipal=juego.generarPalabra();
             palabraVisible =juego.visible(palabraPrincipal);
             teclado.palabraPrincipal.setText(palabraVisible);
             tiempo.setBandera(true);
             juego.setPalabraPrincipal(palabraPrincipal);
             juego.setPalabra(palabraVisible);
             teclado.play.setEnabled(false);
             teclado.dibujo.reiniciar();
             teclado.dibujo.repaint();
             errores=0;
             teclado.tiempo.setTiempo(0);  
             tiempo.setJugada("jugando");
             teclado.ganaste.setVisible(false);
             teclado.perdiste.setVisible(false);
             
        }
        if(e.getSource()==opcion2){
             teclado.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             System.exit( 0 ); 
        }
        
        if(e.getSource()==teclado.play){
            palabraPrincipal=juego.generarPalabra();
             palabraVisible =juego.visible(palabraPrincipal);
             teclado.palabraPrincipal.setText(palabraVisible);
             tiempo.setBandera(true);
             juego.setPalabraPrincipal(palabraPrincipal);
             juego.setPalabra(palabraVisible);
             teclado.play.setEnabled(false);
             teclado.habilitarBotones();

           }
        if(tiempo.getTiempo()<50 && tiempo.jugada.equals("jugando")){
        if (e.getSource() == teclado.botonq) {
            teclado.visor.setText("Q");
            
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
            juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
            palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonw) {
            teclado.visor.setText("W");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botone) {
            teclado.visor.setText("E");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonr) {
            teclado.visor.setText("R");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botont) {
            teclado.visor.setText("T");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botony) {
            teclado.visor.setText("Y");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonu) {
            teclado.visor.setText("U");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botoni) {
            teclado.visor.setText("I");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botono) {
            teclado.visor.setText("O");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonp) {
            teclado.visor.setText("P");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botona) {
            teclado.visor.setText("A");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botons) {
            teclado.visor.setText("S");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botond) {
            teclado.visor.setText("D");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonf) {
            teclado.visor.setText("F");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botong) {
            teclado.visor.setText("G");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonh) {
            teclado.visor.setText("H");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonj) {
            teclado.visor.setText("J");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonk) {
            teclado.visor.setText("K");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonl) {
            teclado.visor.setText("L");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonz) {
            teclado.visor.setText("Z");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonx) {
            teclado.visor.setText("X");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonc) {
            teclado.visor.setText("C");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonv) {
            teclado.visor.setText("V");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonb) {
            teclado.visor.setText("B");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonn) {
            teclado.visor.setText("N");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        if (e.getSource() == teclado.botonm) {
            teclado.visor.setText("M");
            teclado.palabraPrincipal.setText(
            juego.jugar(teclado.visor.getText().charAt(0)));
            palabraAnterior=juego.getPalabra();
                        juego.setPalabra(juego.jugar(teclado.visor.getText().charAt(0)));
                        palabraPosterior=juego.getPalabra();
            if(palabraAnterior.equals(palabraPosterior)){
            errores++;
                try {
                    dibujador(errores);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(juego.palabra.equals(palabraPosterior)){
                teclado.ganaste();
            }
        }
        }
    }
}
