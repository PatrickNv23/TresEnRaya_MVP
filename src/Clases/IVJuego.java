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
    String getJugador1();
    String getJugador2();
    String getJugadorPc();
    void obtenerTablero(char[][]tablero);
    
    static final String iniciarPartida = "INICIAR PARTIDA";
    static final String reiniciarPartida = "REINICIAR PARTIDA";
    static final String jugadorvsPc = "JUGADOR VS PC";
    static final String jugador1vsjugador2 = "JUGADOR1 VS JUGADOR2";
    static final String jugador1X = "JUGADOR1 (X)";
    static final String jugador2O = "JUGADOR2 (O)";
    static final String empezarTurno = "empezarTurno";
    static final String finalizarTurno = "Finalizar Turno";
    static final String retrocederJugada = "Retroceder Jugada";
    static final String guardarPartida = "Guardar Partida";
    static final String finalizarPartida = "Finalizar Partida";
}
