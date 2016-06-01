
import java.util.*;

/**
 * Clase para jugar a la sopa de letras con varias palabras.
 */
public class SopaMuchasPalabras extends SopaDeLetras
{
    private boolean [][] entrelazadas;
    private ArrayList <String> palabras;
    private ArrayList <Boolean> palabrasEnc;

    /**
     * Constructor con parámetros de la clase SopaMuchasPalabras
     */
    public SopaMuchasPalabras (int fil, int col)
    {
        super (fil, col);
        palabras = new ArrayList <String> ();
        palabrasEnc = new ArrayList <Boolean> ();
        entrelazadas = new boolean [fil][col];
    }

    /**
     * Método que devuelve arrayList de palabras que faltan por buscar (?)
     */
    public String buscar ()
    {
        ArrayList <String> palabrasFaltan = new ArrayList <String> ();
        String result = "";
        for (int i = 0; i < palabras.size (); i++){
            if(palabrasEnc.get (i) == false){
                palabrasFaltan.add(palabras.get(i));
            }
        }

        for(int j = 0; j < palabrasFaltan.size();j++){
            result += palabrasFaltan.get(j) + "";
        }
        return result;
    }

    /**
     * Método que indica si la palabra se puede entrelazar y por tanto esconder.
     *
     */

    public boolean sePuedeEsconder (String palabra, int fil, int col, int incf, int incc)
    {
        super.sePuedeEsconder(palabra, fil, col, incf, incc);
        boolean esconder = true;

        for (int i = fil, j = col , d = 0 ; d < palabra.length () && esconder == true ; d++, i += incf , j += incc){
            if(i >= 0 && j >= 0 && i < getSopa().length && j < getSopa()[i].length){
                if(entrelazadas [i][j] == true){
                    if(super.getSopa () [i][j] == palabra.charAt(d)){
                        esconder = true;
                    }else{
                        esconder = false;
                    }
                }else{
                    esconder = true;
                }
            }else{
                esconder = false;
            }
        }
        if(esconder == true){
            for (int p = 0,i = fil, j = col; p < palabra.length () && esconder == true ; p++, i += incf , j += incc){
                entrelazadas[i][j] = true;
            }
        }

        return esconder;
    }

    /**
     * Método que esconde la palabra dada. Es capaz de esconder varias palabras en este caso.
     *
     */

    public void esconderPalabra (String palabra)
    {
        palabras.add(palabra);
        palabrasEnc.add(false);
        int fil=0;
        int col=0;
        int incf=0;
        int incc=0;
        Random gen = new Random();
        do{
            fil= gen.nextInt (getSopa().length-1);
            col= gen.nextInt(getSopa()[0].length-1);
            do{
                incf= gen.nextInt(3)-1;
                incc= gen.nextInt(3)-1;
            }
            while(incc==0&&incf==0);
        }
        while(super.esconderPalabra(palabra, fil, col, incf, incc)==false);

    }

    /**
     * Método procesar palabra para varias palabras.
     */
    public boolean procesarPalabra (String palabra, int fil, int col, int incf, int incc)
    {

        boolean encontrado = false;
        boolean a = true;
        int i = 0;
        boolean si = super.encontrarPalabra(palabra,fil,col,incf,incc);

        while (  i < palabras.size () && encontrado == false){
            if( palabra == palabras.get(i)){
                encontrado = true;
            }else{
                i++;
            }
        }

        if(si == true && encontrado == true ){
            palabrasEnc.set(i,true);
        }

        for (int j = 0; j < palabrasEnc.size () && a == true; j++){
            if(palabrasEnc.get(j) == true){
                a = true;
                super.setFin(true);
            }else{
                a = false;
                super.setFin(false);
            }
        }

        return encontrado && si ;
    }

    public static void main (String[]args){
        SopaMuchasPalabras probar = new SopaMuchasPalabras(15,16);
        probar.esconderPalabra("besis");
        probar.esconderPalabra("tiramisu");
        probar.esconderPalabra("chulerton");
        probar.esconderPalabra("hola");
        probar.esconderPalabra("adios");
        probar.esconderPalabra("hiloo");
        System.out.println(probar.toString());
    }

}
