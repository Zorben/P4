
import java.util.*;

/**
 * Clase para jugar a la sopa de letras con una sola palabra.
 */
public class SopaUnaPalabra extends SopaDeLetras
{

    /**
     * Constructor con parámetros de la clase SopaUnaPalabra(herencia de SopaDeLetras).
     */
    public SopaUnaPalabra (int fil, int col)
    {
        super (fil, col);
    }

    /**
     * Metodo que muestra la palabra a buscar en la sopa.
     */
    public  String buscar (){
        return getPalabraEscondida();
    }

    /**
     * Método para esconder una palabra en la sopa.
     */

    public void esconderPalabra(String palabra){

        boolean sePuede;
        Random azar = new Random();
        do{
            int incf = azar.nextInt (3)-1;
            int incc = azar.nextInt (3)-1;
            int fil = azar.nextInt (getSopa()[0].length);
            int col = azar.nextInt (getSopa().length);
            sePuede = sePuedeEsconder(palabra,fil,col,incf,incc);
            esconderPalabra(palabra,fil,col,incf,incc);

        }while(sePuede == false);
    }

    /**
     * Método para encontrar una  palabra escondida en la sopa de letras dada la palabra y su posición.
     */

    public boolean procesarPalabra (String palabra, int fil, int col, int incf, int incc)
    {
        boolean a = super.encontrarPalabra(palabra,fil,col,incc,incf);
        String procesada = buscar();
        palabra = getPalabraEscondida();

        if(a == true && procesada.equals(palabra)){
            do{

                super.setFin (true);
                return true;
            }while(a == false);

        }else{
            return false;
        }
    }

    public static void main (String[]args){
        SopaUnaPalabra probar = new SopaUnaPalabra(15,16);
        probar.esconderPalabra("tiramisú");
        System.out.println(probar.toString());
    }
}

