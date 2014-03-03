package vista;

import modelo.Juego;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class Teclado {

    public  JFrame  frame;
    public  Game    dibujo;
    JLayeredPane capas;
    JPanel  panel_principal;
    JPanel  panel_centralsuperior;
    JPanel  panel_centralmedio;
    JPanel  panel_centralabajo;
    JPanel  panel_norte;
    JPanel  panel_botones;
    public  JLabel  visor;
    public  JLabel  palabraPrincipal;
    public  JButton botonq, botonw, botone, botonr, botont, botony,
            botonu, botoni, botono, botonp, botona, botons, botond, botonf,
            botong, botonh, botonj, botonk, botonl, botonz, botonx, botonc,
            botonv, botonb, botonn, botonm, play  ;
    ImageIcon    iconoPlay;
    ImageIcon    iconoPause;
    ImageIcon    iconoStop;
    ImageIcon    imaPerdiste = new ImageIcon("./src/imagenes/gameOver.png");
    ImageIcon    imaGanaste  = new ImageIcon("./src/imagenes/Ganaste.png");
    public  JLabel  perdiste = new JLabel(imaPerdiste);
    public  JLabel  ganaste  = new JLabel(imaGanaste );
    public       Temporizador tiempo;


    public Teclado() throws InterruptedException {
        frame = new JFrame();
        // frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS));
        frame.setLayout(new BorderLayout());
        dibujo = new Game();
       /* 
        dibujo.dibujarCabeza();
        dibujo.dibujarBrazoDerecho();
        dibujo.dibujarManoDerecho();
        dibujo.dibujarManoIzquierda();
        dibujo.dibujarCuerpo();
        dibujo.dibujarPiernaDerecha();
        dibujo.dibujarPiernaIzquierda();
        dibujo.dibujarCuerda();
        
        */    

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_principal       = new JPanel();
        panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
        capas                 = new JLayeredPane();
        tiempo                = new Temporizador();
        panel_norte           = new JPanel();
        panel_centralsuperior = new JPanel();
        panel_centralabajo    = new JPanel();
        panel_centralmedio    = new JPanel();
        panel_botones         = new JPanel();
        visor                 = new JLabel("_");
        iconoPlay             = new ImageIcon("./src/imagenes/play.png");
        panel_norte.setLayout(new FlowLayout(FlowLayout.LEFT) );
        palabraPrincipal      = new JLabel("Que palabra es?");
        palabraPrincipal.setFont(new java.awt.Font("Monospaced", Font.BOLD, 30));


        inicializarBotones();

        perdiste.setVisible(false);
        ganaste .setVisible(false);
        dibujo.setSize(300, 500);
        ganaste.setSize(imaGanaste.getIconWidth(), imaGanaste.getIconHeight());
        perdiste.setSize(imaPerdiste.getIconWidth(), imaPerdiste.getIconHeight());
        panel_norte.add(palabraPrincipal);
        panel_norte.add(tiempo);
        frame.add(panel_norte, BorderLayout.NORTH);
        panel_principal.add(visor);
        agregar();
        panel_principal.add(panel_centralsuperior);
        panel_principal.add(panel_centralmedio);
        panel_principal.add(panel_centralabajo);
        panel_principal.add(panel_botones);
        
        frame.add(panel_principal, BorderLayout.SOUTH);
       // frame.add(perdiste, BorderLayout.LINE_END);
       // frame.add(ganaste, BorderLayout.LINE_END);
        capas.add(dibujo,new Integer(0));
        capas.add(ganaste,new Integer(1));
        capas.add(perdiste,new Integer(2));
        //frame.getContentPane().add(capas);
        frame.add(capas, BorderLayout.CENTER);

        frame.setSize(490, 650);
        frame.setVisible(true);
      
        Timer timer = new Timer (1000, new ActionListener (){
             public void actionPerformed(ActionEvent e)
             {
                            perdiste();
             }
         });
         timer.start();

    }

    public Game getDibujo(){
        return this.dibujo;
    }
    public Temporizador getTemporizador(){
        return this.tiempo;
    }
    public void perdiste(){
        if(tiempo.jugada=="perdiste"){
        perdiste.setVisible(true);
       // dibujo.setVisible(false);
        }
    }
    
     public void ganaste(){
        ganaste.setVisible(true);
        tiempo.jugada="ganaste";
    }

    public void agregar() {

        //  panel_centralsuperior.setLayout(new GridLayout(1,10,8,8));
        //  panel_centralmedio.setLayout(new GridLayout(1,9,8,8));
        //  panel_centralabajo.setLayout(new GridLayout(1,7,8,8));

        panel_centralsuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_centralmedio.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_centralabajo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_centralsuperior.add(botonq);
        panel_centralsuperior.add(botonw);
        panel_centralsuperior.add(botone);
        panel_centralsuperior.add(botonr);
        panel_centralsuperior.add(botont);
        panel_centralsuperior.add(botony);
        panel_centralsuperior.add(botonu);
        panel_centralsuperior.add(botoni);
        panel_centralsuperior.add(botono);
        panel_centralsuperior.add(botonp);
        panel_centralmedio.add(botona);
        panel_centralmedio.add(botons);
        panel_centralmedio.add(botond);
        panel_centralmedio.add(botonf);
        panel_centralmedio.add(botong);
        panel_centralmedio.add(botonh);
        panel_centralmedio.add(botonj);
        panel_centralmedio.add(botonk);
        panel_centralmedio.add(botonl);
        panel_centralabajo.add(botonz);
        panel_centralabajo.add(botonx);
        panel_centralabajo.add(botonc);
        panel_centralabajo.add(botonv);
        panel_centralabajo.add(botonb);
        panel_centralabajo.add(botonn);
        panel_centralabajo.add(botonm);
        panel_botones.add(play);
    }

    public void inicializarBotones() {
        botonq = new JButton("Q");
        botonw = new JButton("W");
        botone = new JButton("E");
        botonr = new JButton("R");
        botont = new JButton("T");
        botony = new JButton("Y");
        botonu = new JButton("U");
        botoni = new JButton("I");
        botono = new JButton("O");
        botonp = new JButton("P");
        botona = new JButton("A");
        botons = new JButton("S");
        botond = new JButton("D");
        botonf = new JButton("F");
        botong = new JButton("G");
        botonh = new JButton("H");
        botonj = new JButton("J");
        botonk = new JButton("K");
        botonl = new JButton("L");
        botonz = new JButton("Z");
        botonx = new JButton("X");
        botonc = new JButton("C");
        botonv = new JButton("V");
        botonb = new JButton("B");
        botonn = new JButton("N");
        botonm = new JButton("M");
        play   = new JButton(iconoPlay);

    }
        public void  bloquearBotones() {
        botonq.setEnabled(false);
        botonw.setEnabled(false);
        botone.setEnabled(false);
        botonr.setEnabled(false);
        botont.setEnabled(false);
        botony.setEnabled(false);
        botonu.setEnabled(false);
        botoni.setEnabled(false);
        botono.setEnabled(false);
        botonp.setEnabled(false);
        botona.setEnabled(false);
        botons.setEnabled(false);
        botond.setEnabled(false);
        botonf.setEnabled(false);
        botong.setEnabled(false);
        botonh.setEnabled(false);
        botonj.setEnabled(false);
        botonk.setEnabled(false);
        botonl.setEnabled(false);
        botonz.setEnabled(false);
        botonx.setEnabled(false);
        botonc.setEnabled(false);
        botonv.setEnabled(false);
        botonb.setEnabled(false);
        botonn.setEnabled(false);
        botonm.setEnabled(false);
        

    }
        public void  habilitarBotones() {
        botonq.setEnabled(true);
        botonw.setEnabled(true);
        botone.setEnabled(true);
        botonr.setEnabled(true);
        botont.setEnabled(true);
        botony.setEnabled(true);
        botonu.setEnabled(true);
        botoni.setEnabled(true);
        botono.setEnabled(true);
        botonp.setEnabled(true);
        botona.setEnabled(true);
        botons.setEnabled(true);
        botond.setEnabled(true);
        botonf.setEnabled(true);
        botong.setEnabled(true);
        botonh.setEnabled(true);
        botonj.setEnabled(true);
        botonk.setEnabled(true);
        botonl.setEnabled(true);
        botonz.setEnabled(true);
        botonx.setEnabled(true);
        botonc.setEnabled(true);
        botonv.setEnabled(true);
        botonb.setEnabled(true);
        botonn.setEnabled(true);
        botonm.setEnabled(true);
        

    }

    public static void main(String[] inforusx) throws InterruptedException {
        Teclado j = new Teclado();

    }
// metodo para el menu
  
    public void pegarMenu(JMenuBar e) {
           frame.setJMenuBar(e);
    }

 
}
