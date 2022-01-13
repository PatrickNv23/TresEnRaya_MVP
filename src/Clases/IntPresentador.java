package Clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IntPresentador {

    public void configurarJugador1vsJugador2();

    public void configurarJugadorvsPc();

    public void presentar();

    public void mantenerJuego();

    public void mantenerJuegoPC();

    public void posicionOcupada(char[][] matriz);
}
