
package Clases;

public class Tablero {

    private int fila;
    private int columna;
    private char[][] matriz = new char[3][3];
    private char simboloPorDefecto = '-';

    public void inicializarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = this.simboloPorDefecto;
            }
        }
    }

    public void crearTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void actualizarTablero(int fila, int columna, char simbolo) {
        matriz[fila][columna] = simbolo;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public char getSimboloPorDefecto() {
        return simboloPorDefecto;
    }
    
    
}
