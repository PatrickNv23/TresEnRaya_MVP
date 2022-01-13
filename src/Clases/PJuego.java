package Clases;

public class PJuego implements IntPresentador {

    private MJuego mjuego;
    private IVJuego vjuego;
    int intentos;

    public PJuego(IVJuego vjuego) {
        this.mjuego = new MJuego();
        this.vjuego = vjuego;
    }

    @Override
    public void presentar() {
        mjuego.setOpcionVentanaPrincipal(vjuego.mostrarVentanaPrincipal());
        if (mjuego.getOpcionVentanaPrincipal() == 1) {
            mjuego.setOpcionModoJuego(vjuego.mostrarSeleccionarModoJuego());
            if (mjuego.getOpcionModoJuego() == 1) {
                this.configurarJugadorvsPc();
            } else if (mjuego.getOpcionModoJuego() == 2) {
                this.configurarJugador1vsJugador2();
            }
            mjuego.getTablero().inicializarTablero();
            mjuego.getTablero().crearTablero();

            if (mjuego.getTurnoo().getJugador2().getNombre() == "PC") {
                mantenerJuegoPC();
            } else {
                mantenerJuego();
            }

            mjuego.getTurnoo().getJugador1().mostrarMovimientos(mjuego.getTurnoo().getJugador1().getMovimientos(), mjuego.getTurnoo().getJugador1().getNombre());
            mjuego.getTurnoo().getJugador2().mostrarMovimientos(mjuego.getTurnoo().getJugador2().getMovimientos(), mjuego.getTurnoo().getJugador2().getNombre());
        } else if (mjuego.getOpcionVentanaPrincipal() == 2) {
            String ruta = "C:\\Users\\Usuario\\Documents\\UNS\\VI CICLO\\ARQUITECTURA DE SOFTWARE EMPRESARIAL\\PRODUCTOS\\PRIMER MINI_PRODUCTO\\MVP_TresEnRaya\\" + vjuego.mostrarReanudarPartida();
            System.out.println(mjuego.leerPartida(ruta));
        }
    }

    @Override
    public void configurarJugadorvsPc() {
        mjuego.getTurnoo().getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
        mjuego.getTurnoo().getJugador1().setTipojugador(TipoJugador.PERSONA);

        mjuego.getTurnoo().getJugador2().setNombre("PC");
        mjuego.getTurnoo().getJugador2().setTipojugador(TipoJugador.MAQUINA);

        System.out.println("Jugador1: " + mjuego.getTurnoo().getJugador1().getNombre());
        System.out.println("Jugador 2: PC");
    }

    @Override
    public void configurarJugador1vsJugador2() {
        mjuego.setOpcionJugadorElegido(vjuego.mostrarElegirJugador());
        if (mjuego.getOpcionJugadorElegido() == 1) {
            mjuego.getTurnoo().getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
            mjuego.getTurnoo().getJugador1().setTipojugador(TipoJugador.PERSONA);
            mjuego.getTurnoo().getJugador2().setNombre(vjuego.mostrarIngresoNombreJugador(2));
            mjuego.getTurnoo().getJugador2().setTipojugador(TipoJugador.PERSONA);
        } else if (mjuego.getOpcionJugadorElegido() == 2) {
            mjuego.getTurnoo().getJugador2().setNombre(vjuego.mostrarIngresoNombreJugador(2));
            mjuego.getTurnoo().getJugador2().setTipojugador(TipoJugador.PERSONA);
            mjuego.getTurnoo().getJugador1().setNombre(vjuego.mostrarIngresoNombreJugador(1));
            mjuego.getTurnoo().getJugador1().setTipojugador(TipoJugador.PERSONA);
        }
    }

    @Override
    public void mantenerJuego() {
        intentos = 0;
        do {
            intentos++;
            mjuego.getTurnoo().indicarTurno();
            posicionOcupada(mjuego.getTablero().getMatriz());
            mjuego.realizarMovimiento();
            seleccionarOpcionSoloSiNoExisteGanador();
            existeTableroLlenoSegunModelo();

        } while (!mjuego.getValidacionGanador().validarGanador(mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto()));
    }

    public void seleccionarOpcionSoloSiNoExisteGanador() {
        if (!mjuego.getValidacionGanador().validarGanador(mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto()) && !mjuego.getValidacionGanador().existeEmpate(intentos, mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto())) {
            this.seleccionarOpciondeJuego();
        }
    }

    public void seleccionarOpciondeJuego() {
        mjuego.setOpcionJuego(vjuego.mostrarOpcionesdeJuego());
        if (mjuego.getOpcionJuego() == 1) {
            // retroceder
            mjuego.deshacerMovimiento(mjuego.getTablero().getFila(), mjuego.getTablero().getColumna(), '-');
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

    @Override
    public void mantenerJuegoPC() {
        intentos = 0;
        do {
            intentos++;
            if (mjuego.getTurnoo().indicarTurno()) {
                posicionOcupada(mjuego.getTablero().getMatriz());
                mjuego.realizarMovimiento();
            } else {
                mjuego.realizarMovimiento();
            }
            existeTableroLlenoSegunModelo();
        } while (!mjuego.getValidacionGanador().validarGanador(mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto()));
    }

    public void existeTableroLlenoSegunModelo() {
        if (mjuego.getValidacionGanador().existeEmpate(intentos, mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto())) {
            System.out.println("EMPATE");
            System.out.println("FIN DEL JUEGO");
            System.exit(0);
        }
    }

    @Override
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
        mjuego.getTablero().setFila(fila);
        mjuego.getTablero().setColumna(columna);
    }
    

}
