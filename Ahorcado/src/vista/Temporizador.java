
package vista;

import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Temporizador extends JPanel{
    JLabel  hora = new JLabel("");
    int     seg  = 0;
    Timer   timer;
    boolean bandera;
    public  String jugada;
    Contador cont;
    
    
    public Temporizador() {
        GridLayout vista = new GridLayout(1,1,1,1);
        setLayout(vista);
        add(hora);
        timer         = new Timer();
        cont = new Contador();
        timer.schedule(cont,0,1000); 
        
        bandera       = false;
        jugada        = "jugando";
        
       // setVisible(true);
    }
    public void setBandera(boolean bandera){
    this.bandera=bandera;
    } 
    public boolean getBandera(){
    return bandera;
    }
    public String getJugada(){
    return jugada;
    }
    public int getTiempo(){
    return seg;
    }
    public void setTiempo(int seg){
    this.seg=seg;
    }
    public void setJugada(String jugada){
    this.jugada = jugada;
    bandera     = true;
    }

    

    
    class Contador extends TimerTask{
        
        public void run(){
          if(seg<50 ){
              if(jugada.equals("ganaste")){
                bandera=false;
              }
              if(jugada.equals("perdiste")){
                bandera=false;
              }
            if( bandera==true ){
              seg++;
              hora.setText(seg/60+":"+seg%60);
            }
            else if(bandera==false){
             hora.setText(seg/60+":"+seg%60);
            }
          }else{
            jugada="perdiste";
            bandera=false;
          }
        }  
    }
    public static void main (String args[]){
        Temporizador t=new Temporizador();
    }
}
 
