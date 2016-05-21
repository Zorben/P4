
public abstract class SopaDeLetras {

	/*
     * Constructor con parametros que crea las dimensiones de la sopa de letras.
     */
	public SopaDeLetras(){}

	/*
     * M�todo get para la matriz.
     */
    public char [][] getSopa (){}

    /*
     * M�todo get para la filas i.
     */
    public char [] getFilaI (){}

    /*
     * M�todo que devuelve la columna i.
     */
    public char [] getColI (){}

    /*
     * M�todo que devuelve el n�mero de filas.
     */
    public int getTotalFilas (){}

    /*
     * M�todo para obtener el n�mero de columnas.
     */
    public int getTotalColumnas (){}

    public String getPalabraEscondida(){}

    /*
     * M�todo que devuelve el fin de la partida.
     */
    public boolean getFin (){}

    public void setFin(){}

    /*
     * M�todo que devuelve la palabra que hay que buscar en la sopa.(se completa en las hijas)
     */
    public abstract String buscar ();

    /*
     * M�todo que devuelve la sopa de letras como una matriz de letras.
     */
    public String toString (){}

    /*
     * M�todo que rellena la sopa de letras aleatoriamente.
     */
    public void rellenarSopaAleatoriamente (){}

    /*
     * M�todo que devuelve true si la palabra se puede esconder en la posicion y direccion dadas.
     */
     public boolean esconderPalabra(String palabra, int fil, int col, int incf, int incc){}

     /*
      * M�todo que esconde la palabra a buscar en una posici�n y direcci�n aleatoria.(abstracto , se completa en las hijas)
      */
     public abstract void esconderPalabra();

     /*
      * M�todo que devuelve si la palabra cabe en la sopa a partir de la posici�n (fil, col)en la
        direcci�n asociada a (incf,incc).
      */
     public boolean sePuedeEsconder (){}

     /*
      * M�todo que dice si se ha encontrado la palabra a partir de la posici�n y de la direcci�n en la que se cree que est�.
      * (duda)(casa / casado).
      */
     public boolean encontrarPalabra (){}

     /*
      * M�todo que devuelve true si has encontrado la palabra y marca el final del juego en caso de encontrarla.
      * (abstracto, se completa en las hijas)
      */
     public abstract boolean procesarPalabra ();
}
