package Clases;
public interface IVJuego {
    void setPresentador(PJuego p);
    void iniciar();
    String mostrarReanudarPartida();
    int mostrarSeleccionarModoJuego();
    int mostrarElegirJugador();
    String mostrarIngresoNombreJugador(int opcion);
    void mostrarTablero();
    int mostrarOpcionesdeJuego();
    int mostrarIngresoFilas();
    int mostrarIngresoColumnas();
    String mostrarGanador(String nombre);
    String mostrarGuardarPartida();
    int mostrarVentanaPrincipal();
    int mostrarOpcionesDespuesGuardado();
}
