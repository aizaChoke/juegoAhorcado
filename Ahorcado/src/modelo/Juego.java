
package modelo;

import java.util.ArrayList;

public final class Juego {
    String arreglo_palabras[] ;
    public String palabra;
    public String palabra_visible;
    
    public Juego(){
           arreglo_palabras=new String [28]; 
           llenarPalabras();
         //  palabra=generarPalabra();
         //  palabra_visible=visible(palabra);
         //  System.out.println(palabra_visible);
         //  System.out.println(jugar('o'));
    }
    
    
    public String generarPalabra(){ //elije una palabra
           String palabraGenerado =  "";
           int numAleatorio       =  (int)(Math.random()*28);
           palabraGenerado        =  arreglo_palabras[numAleatorio];
    return palabraGenerado;
    }
    
    
    public String visible(String palabra){ // devuelve la palabra que solo vera el usuario
           String letraVisible=palabra;
           ArrayList<Integer> indIncognitas =indicesIncognita(letraVisible.length());
           for(int i=0; i<indIncognitas.size(); i++){
               letraVisible=letraVisible.replace(letraVisible.charAt(indIncognitas.get(i)),'*' );
           }
    return letraVisible;
    }
    
    
    public ArrayList<Integer> indicesIncognita(int cantidad){
           ArrayList<Integer> indices=new ArrayList<>();
                for(int i=0; i<cantidad/2; i++){
                    indices.add((int)(Math.random()*cantidad));
                }
    return indices;
    }
    
    
    public void llenarPalabras(){ //estas son las palabras que seran adivinadas
    arreglo_palabras[0]="TERROR";
    arreglo_palabras[1]="ODIO";
    arreglo_palabras[2]="TEXAS";
    arreglo_palabras[3]="EGOISMO";
    arreglo_palabras[4]="MICROSOFT";
    arreglo_palabras[5]="CELOS";
    arreglo_palabras[6]="GOOGLE";
    arreglo_palabras[7]="ERROR";
    arreglo_palabras[8]="GANASTE";
    arreglo_palabras[9]="PERDISTE";
    arreglo_palabras[10]="FACEBOOK";
    arreglo_palabras[11]="LENGUAJE";
    arreglo_palabras[12]="SISTEMAS";
    arreglo_palabras[13]="INFORMATICA";
    arreglo_palabras[14]="UNIVERSITARIO";
    arreglo_palabras[15]="COLEGIALA";
    arreglo_palabras[16]="ESTUDIANTE";
    arreglo_palabras[17]="MUNDIAL";
    arreglo_palabras[18]="MUSICA";
    arreglo_palabras[19]="FLOJERA";
    arreglo_palabras[20]="COMPUTADORAS";
    arreglo_palabras[21]="LAPTOP";
    arreglo_palabras[22]="HISTORIA";
    arreglo_palabras[23]="CASA";
    arreglo_palabras[24]="EDIFICIO";
    arreglo_palabras[25]="OCEANO";
    arreglo_palabras[26]="NADAR";
    arreglo_palabras[27]="DEPORTE";
    }
    public void setPalabra(String newPalabra){
    palabra_visible=newPalabra;
    }
    
    public String getPalabra(){
    return palabra_visible;
    }
    public void setPalabraPrincipal(String newPalabra){
    palabra=newPalabra;
    }
    
    public String jugar(char letra){
    String resultado="";
    int contador=0;
    ArrayList<Integer> indices=new ArrayList<>();
    ArrayList<Character> copia  =new ArrayList<>();
    while(palabra.length()>contador){
        if(palabra.charAt(contador)==letra){
          indices.add(contador);
        }
        contador++;
    } 
    for(int i=0; i<=palabra_visible.length()-1; i++){
        copia.add(palabra_visible.charAt(i));
    }

       for(int i=0; i<=indices.size()-1; i++){
        copia.set(indices.get(i), letra);
    }  
       
            for(int i=0; i<=copia.size()-1; i++){
            resultado=resultado+copia.get(i);
    }  
        
   
    indices.clear();
    return resultado;
    }
        public static void main(String[] args) {
        Juego j=new Juego();
        
    }
}
