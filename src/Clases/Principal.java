package Clases;

import Vistas.VFormJuego;

public class Principal {

    public static void main(String[] args) {
        /*
       IVJuego juego = new VCJuego();
        PJuego presentador = new PJuego(juego);*/
        
        VFormJuego juego = new VFormJuego();
        PFormJuego presentador = new PFormJuego(juego);
        
        juego.setPresentador(presentador);
        juego.iniciar();
    }
}
