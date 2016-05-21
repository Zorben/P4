
public abstract class SopaDeLetras {

	/*
     * Constructor con parametros que crea las dimensiones de la sopa de letras.
     */
	public SopaDeLetras(){}

	/*
     * Método get para la matriz.
     */
    public char [][] getSopa (){}

    /*
     * Método get para la filas i.
     */
    public char [] getFilaI (){}

    /*
     * Método que devuelve la columna i.
     */
    public char [] getColI (){}

    /*
     * Método que devuelve el número de filas.
     */
    public int getTotalFilas (){}

    /*
     * Método para obtener el número de columnas.
     */
    public int getTotalColumnas (){}

    public String getPalabraEscondida(){}

    /*
     * Método que devuelve el fin de la partida.
     */
    public boolean getFin (){}

    public void setFin(){}

    /*
     * Método que devuelve la palabra que hay que buscar en la sopa.(se completa en las hijas)
     */
    public abstract String buscar ();

    /*
     * Método que devuelve la sopa de letras como una matriz de letras.
     */
    public String toString (){}

    /*
     * Método que rellena la sopa de letras aleatoriamente.
     */
    public void rellenarSopaAleatoriamente (){}

    /*
     * Método que devuelve true si la palabra se puede esconder en la posicion y direccion dadas.
     */
     public boolean esconderPalabra(String palabra, int fil, int col, int incf, int incc){}

     /*
      * Método que esconde la palabra a buscar en una posición y dirección aleatoria.(abstracto , se completa en las hijas)
      */
     public abstract void esconderPalabra();

     /*
      * Método que devuelve si la palabra cabe en la sopa a partir de la posición (fil, col)en la
        dirección asociada a (incf,incc).
      */
     public boolean sePuedeEsconder (){}

     /*
      * Método que dice si se ha encontrado la palabra a partir de la posición y de la dirección en la que se cree que está.
      * (duda)(casa / casado).
      */
     public boolean encontrarPalabra (){}

     /*
      * Método que devuelve true si has encontrado la palabra y marca el final del juego en caso de encontrarla.
      * (abstracto, se completa en las hijas)
      */
     public abstract boolean procesarPalabra ();
}
