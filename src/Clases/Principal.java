
package Clases;

public class Principal {
    public static void main(String[] args) {
        IVJuego juego = new VCJuego();
        PJuego presentador = new PJuego(juego);
        juego.setPresentador(presentador);
        juego.iniciar();
    }
    
}

