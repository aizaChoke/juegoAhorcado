
package vista;

import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {

	int cabeza = 0;
        
	int md1= 120;
        int md2= 100;
        int md3= 170;
        int md4= 150;
        int mi1=120;
        int mi2=100;
       
        int cuerpo1=120;
        int cuerpo2=83;
        
        int piernaD1=120;
        int piernaD2=250;
        
        int piernaI1=120;
        int piernaI2=250;
        
        int cuerda=0;
        
        Thread hilo=new Thread();
    private Stroke dashed;
    
        public void reiniciar() {
         cabeza = 0;
         md1= 120;
         md2= 100;
         md3= 170;
         md4= 150;
         mi1=120;
         mi2=100;
       
         cuerpo1=120;
         cuerpo2=100;
        
         piernaD1=120;
         piernaD2=250;
        
         piernaI1=120;
         piernaI2=250;
        
         cuerda=0;
	}
        
        private void cabeza() {
                cabeza=50;

     //  GeneralPath path = new GeneralPath(); 
     //  path.moveTo(10,20);   // se establece la posición inicial
     //  path.lineTo(20,30);   // se dibuja un segmento de linea hasta el 30
	}
	private void manoIzquierda() {
		mi1--;
                mi2++;
                
	}
        private void manoDerecha() {
		md1++;
                md2++;
	}
        private void manoDerecha2() {
                md3++;
                md4--;
	}
        private void cuerpo() {
                cuerpo2++;
	}
        private void piernaDerecha() {
		piernaD1++;
                piernaD2++;
	}
        private void piernaIzquierda() {
		piernaI1--;
                piernaI2++;
	}

        public void dibujarCuerda() throws InterruptedException {
        while (cuerda<100) {
                        cuerda++;
			repaint();
			hilo.sleep(10);
        }	
        }
        public void dibujarCabeza() throws InterruptedException {
     
                        cabeza();
			repaint();
			hilo.sleep(10);
		
        }
         public void dibujarBrazoDerecho() throws InterruptedException {
        while (md1<170) {
                        manoDerecha();
			repaint();
			hilo.sleep(10);
		}

        }
                  public void dibujarManoDerecho() throws InterruptedException {

         while (md4>130) {
                        manoDerecha2();
			repaint();
			hilo.sleep(10);
		}
        }
         public void dibujarManoIzquierda() throws InterruptedException {
        while (mi1>=50) {
                        manoIzquierda();
			repaint();
			hilo.sleep(10);
		}
        }
         
         public void dibujarCuerpo() throws InterruptedException {
        while (cuerpo2<250) {
                        cuerpo();
			repaint();
			hilo.sleep(10);
		}
        }
         
         public void dibujarPiernaDerecha() throws InterruptedException {
        while (piernaD1<200) {
                        piernaDerecha();
			repaint();
			hilo.sleep(10);
		}
        }
         public void dibujarPiernaIzquierda() throws InterruptedException {
        while (piernaI1>=50) {
                        piernaIzquierda();
			repaint();
			hilo.sleep(10);
		}
        }
         	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d =  (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
                

		
                g2d.fillOval(100, 50, cabeza, cabeza);

                g2d.setStroke(new BasicStroke(5.0f)); //da volumen a la linea

                
                g2d.drawLine(120, 100, md1, md2);
                g2d.drawLine(170, 150, md3, md4);
                g2d.drawLine(120, 100, mi1, mi2);
                 g2d.setStroke(new BasicStroke(10.0f)); //da volumen a la linea
                g2d.drawLine(120, 80, 120, cuerpo2);
                 g2d.setStroke(new BasicStroke(5.0f)); //da volumen a la linea
                g2d.drawLine(120, 250, piernaD1, piernaD2);
                g2d.drawLine(120, 250, piernaI1, piernaI2);
                
                float dash1[] = {5.0f};
                BasicStroke dashed = new BasicStroke(5.0f, 
                                                      BasicStroke.CAP_BUTT, 
                                                      BasicStroke.JOIN_MITER, 
                                                      5.0f, dash1, 0.0f);
                g2d.setStroke(dashed);
                g2d.drawLine(120, 0, 120, cuerda);
                
	}


	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                game.dibujarCabeza();
                game.dibujarBrazoDerecho();
		game.dibujarManoDerecho();
                game.dibujarManoIzquierda();
                game.dibujarCuerpo();
                game.dibujarPiernaDerecha();
                game.dibujarPiernaIzquierda();
                game.dibujarCuerda();
                
                game.reiniciar();
		game.repaint();
                
	}
}