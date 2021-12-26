package Clases;

public class PJuego {

    private MJuego mjuego;
    private IVJuego vjuego;

    public PJuego(IVJuego vjuego) {
        this.mjuego = new MJuego();
        this.vjuego = vjuego;
    }

    public void presentar() {
        mjuego.setOpcionVentanaPrincipal(vjuego.mostrarVentanaPrincipal());
        mjuego.setOpcionModoJuego(vjuego.mostrarSeleccionarModoJuego());
        if (mjuego.getOpcionModoJuego() == 1) {
            this.configurarJugadorvsPc();
        } else if (mjuego.getOpcionModoJuego() == 2) {
            this.configurarJugador1vsJugador2();
        }
        mjuego.inicializarTablero();
        mjuego.crearTablero();
        //mantenerJuego();

        if (mjuego.getJugador2().getNombre() == "PC") {
            mantenerJuegoPC();
        } else {
            mantenerJuego();
        }

        //vjuego.mostrarTablero(mjuego.inicializarTablero());
        //mantenerJuego();
    }

    public void configurarJugadorvsPc() {
        mjuego.getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
        mjuego.getJugador2().setNombre("PC");
        System.out.println("Jugador1: " + mjuego.getJugador1().getNombre());
        System.out.println("Jugador 2: PC");
    }

    public void configurarJugador1vsJugador2() {
        mjuego.setOpcionJugadorElegido(vjuego.mostrarElegirJugador());
        if (mjuego.getOpcionJugadorElegido() == 1) {
            mjuego.getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
            mjuego.getJugador2().setNombre(vjuego.mostrarIngresoNombreJugador(2));
        } else if (mjuego.getOpcionJugadorElegido() == 2) {
            mjuego.getJugador2().setNombre(vjuego.mostrarIngresoNombreJugador(2));
            mjuego.getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
        }
    }

    public void mantenerJuego() {
        //int i = 0;
        do {
            mjuego.indicarTurno();
            mjuego.setFila(vjuego.mostrarIngresoFilas());
            mjuego.setColumna(vjuego.mostrarIngresoColumnas());
            mjuego.realizarMovimiento();
            //i++;
            //mjuego.crearTablero();
            //vjuego.mostrarTablero();

            /*
            if (mjuego.getJugador2().getNombre() != "PC") {

            }*/
        } while (!mjuego.ganador());
    }

    public void mantenerJuegoPC() {
        do {
            if (mjuego.indicarTurno()) {
                mjuego.setFila(vjuego.mostrarIngresoFilas());
                mjuego.setColumna(vjuego.mostrarIngresoColumnas());
                mjuego.realizarMovimiento();
            } else {
                //mjuego.indicarTurno();
                mjuego.realizarMovimiento();
            }

        } while (!mjuego.ganador());
    }

    /*
    public void definirGanadorAlaVista(){
         if(mjuego.isTurno()){
            vjuego.mostrarGanador(mjuego.getJugador1().getNombre());
        }else{
            vjuego.mostrarGanador(mjuego.getJugador2().getNombre());
        }
    }*/
}
