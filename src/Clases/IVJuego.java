
package Clases;

public interface IVJuego {
    void setPresentador(PJuego p);
    void iniciar();
    void mostrarReanudarPartida();
    int mostrarSeleccionarModoJuego();
    int mostrarElegirJugador();
    String mostrarIngresoNombreJugador(int opcion);
    void mostrarTablero();
    int mostrarOpcionesdeJuego();
    int mostrarIngresoFilas();
    int mostrarIngresoColumnas();
    String mostrarGanador(String nombre);
    void mostrarGuardarPartida();
    int mostrarVentanaPrincipal();
}
