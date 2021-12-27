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
        if (mjuego.getOpcionVentanaPrincipal() == 1) {
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
            mjuego.getJugador1().mostrarMovimientos(mjuego.getJugador1().getMovimientos(), mjuego.getJugador1().getNombre());
            mjuego.getJugador2().mostrarMovimientos(mjuego.getJugador2().getMovimientos(), mjuego.getJugador2().getNombre());
        }else if(mjuego.getOpcionVentanaPrincipal()==2){
            String ruta = "C:\\Users\\Usuario\\Documents\\UNS\\VI CICLO\\ARQUITECTURA DE SOFTWARE EMPRESARIAL\\PRODUCTOS\\PRIMER MINI_PRODUCTO\\MVP_TresEnRaya\\"+vjuego.mostrarReanudarPartida();
            System.out.println(mjuego.leerPartida(ruta));
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
            /*
            mjuego.setFila(vjuego.mostrarIngresoFilas());
            mjuego.setColumna(vjuego.mostrarIngresoColumnas());*/
            posicionOcupada(mjuego.getMatriz());
            mjuego.realizarMovimiento();
            seleccionarOpcionSoloSiNoExisteGanador();
            //i++;
            //mjuego.crearTablero();
            //vjuego.mostrarTablero();

            /*
            if (mjuego.getJugador2().getNombre() != "PC") {

            }*/
        } while (!mjuego.ganador());
    }

    public void seleccionarOpcionSoloSiNoExisteGanador() {
        if (!mjuego.ganador()) {
            this.seleccionarOpciondeJuego();
        }
    }

    public void seleccionarOpciondeJuego() {
        mjuego.setOpcionJuego(vjuego.mostrarOpcionesdeJuego());
        if (mjuego.getOpcionJuego() == 1) {
            // retroceder
            mjuego.deshacerMovimiento(mjuego.getFila(), mjuego.getColumna(), '-');
        } else if (mjuego.getOpcionJuego() == 2) {
            String nombre = vjuego.mostrarGuardarPartida();
            mjuego.guardarPartida(nombre);
            mjuego.setOpcionDespuesGuardado(vjuego.mostrarOpcionesDespuesGuardado());
            if (mjuego.getOpcionDespuesGuardado() == 1) {
                System.exit(0);
            } else if (mjuego.getOpcionDespuesGuardado() == 2) {
                System.out.println("------ CONTINUANDO ------");
            }
        } else if (mjuego.getOpcionJuego() == 3) {
            System.out.println("CONTINUANDO CON EL JUEGO");
        }
    }

    public void mantenerJuegoPC() {
        do {
            if (mjuego.indicarTurno()) {

                /*
                mjuego.setFila(vjuego.mostrarIngresoFilas());
                mjuego.setColumna(vjuego.mostrarIngresoColumnas());*/
                posicionOcupada(mjuego.getMatriz());
                mjuego.realizarMovimiento();
            } else {
                //mjuego.indicarTurno();
                mjuego.realizarMovimiento();
            }

        } while (!mjuego.ganador());
    }

    public void posicionOcupada(char[][] matriz) {
        boolean posicionOcupada = true;
        int fila, columna;
        do {
            fila = vjuego.mostrarIngresoFilas();
            columna = vjuego.mostrarIngresoColumnas();
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[fila][columna] != '-') {
                        posicionOcupada = true;
                    } else {
                        posicionOcupada = false;
                    }
                }
            }
            if (posicionOcupada) {
                System.out.println("La posición está ocupada");
            }
        } while (posicionOcupada);
        mjuego.setFila(fila);
        mjuego.setColumna(columna);
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
