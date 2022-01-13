package Clases;

import Vistas.VFormJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PFormJuego implements ActionListener, IntPresentador {

    private MJuego mjuego;
    private VFormJuego vjuego;
    int intentos;

    public PFormJuego(VFormJuego vjuego) {
        this.mjuego = new MJuego();
        this.vjuego = vjuego;
    }

    @Override
    public void presentar() {
        mjuego.getTablero().inicializarTablero();
        vjuego.obtenerTablero(mjuego.getTablero().getMatriz());
    }

    @Override
    public void configurarJugador1vsJugador2() {
        this.mandarDatosJugador1AlModelo();
        this.mandarDatosJugador2AlModelo();
    }

    @Override
    public void configurarJugadorvsPc() {
        this.mandarDatosJugador1AlModelo();
        this.mandarDatosJugadorPCAlModelo();
    }

    public void mandarDatosJugador1AlModelo() {
        mjuego.getTurnoo().getJugador1().setNombre(vjuego.getJugador1());
        mjuego.getTurnoo().getJugador1().setTipojugador(TipoJugador.PERSONA);
    }

    public void mandarDatosJugador2AlModelo() {
        mjuego.getTurnoo().getJugador2().setNombre(vjuego.getJugador2());
        mjuego.getTurnoo().getJugador2().setTipojugador(TipoJugador.PERSONA);
    }

    public void mandarDatosJugadorPCAlModelo() {
        mjuego.getTurnoo().getJugador2().setNombre(vjuego.getJugadorPc());
        mjuego.getTurnoo().getJugador2().setTipojugador(TipoJugador.MAQUINA);
    }

    @Override
    public void mantenerJuego() {
        //mjuego.getTurnoo().indicarTurno();
        vjuego.mostrarNombreTurno(mjuego.getTurnoo().indicarTurno(), mjuego.getTurnoo().getJugador1().getNombre(), mjuego.getTurnoo().getJugador2().getNombre());
        this.verificarEmpateEnModelo();
        this.verificarGanadorEnModelo();
    }

    public void verificarEmpateEnModelo() {
        if (mjuego.getValidacionGanador().existeEmpate(9, mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto())) {
            vjuego.mostrarEmpate();
            System.exit(0);
        }
    }

    public void verificarGanadorEnModelo() {
        if (mjuego.getValidacionGanador().validarGanador(mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto())) {
            vjuego.mostrarGanadorr(mjuego.getTurnoo().indicarTurno(), mjuego.getTurnoo().getJugador1().getNombre(), mjuego.getTurnoo().getJugador2().getNombre());
            System.exit(0);
        };
    }

    @Override
    public void mantenerJuegoPC() {
        //mjuego.getTurnoo().indicarTurno();
        vjuego.mostrarNombreTurno(mjuego.getTurnoo().indicarTurno(), mjuego.getTurnoo().getJugador1().getNombre(), mjuego.getTurnoo().getJugador2().getNombre());
        vjuego.obtenerTablero(mjuego.getTablero().getMatriz());
        this.verificarEmpateEnModelo();
        this.verificarGanadorEnModelo();
    }

    @Override
    public void posicionOcupada(char[][] matriz) {
        boolean posicionOcupada = true;
        int fila, columna;
        do {
            vjuego.ingresarFila();
            vjuego.ingresarColumna();
            fila = vjuego.getFila();
            columna = vjuego.getColumna();
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
                JOptionPane.showMessageDialog(null, "La posición está ocupada");
            }
        } while (posicionOcupada);
        mjuego.getTablero().setFila(fila);
        mjuego.getTablero().setColumna(columna);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(vjuego.iniciarPartida)) {

        } else if (evento.getActionCommand().equals(vjuego.reiniciarPartida)) {

        } else if (evento.getActionCommand().equals(vjuego.jugadorvsPc)) {
            this.vjuego.ingresarJugador1();
            this.configurarJugadorvsPc();
            mantenerJuegoPC();
        } else if (evento.getActionCommand().equals(vjuego.jugador1vsjugador2)) {
            //this.configurarJugador1vsJugador2();
        } else if (evento.getActionCommand().equals(vjuego.jugador1X)) {
            this.vjuego.ingresarJugador1();
            this.vjuego.ingresarJugador2();
            this.configurar2Jugadores();
        } else if (evento.getActionCommand().equals(vjuego.jugador2O)) {
            this.vjuego.ingresarJugador1();
            this.vjuego.ingresarJugador2();
            this.configurar2Jugadores();
        } else if (evento.getActionCommand().equals(vjuego.empezarTurno)) {
            this.posicionOcupada(mjuego.getTablero().getMatriz());
            mjuego.getTablero().actualizarTablero(vjuego.getFila(), vjuego.getColumna(), this.devolverSimboloAlaVista());
            vjuego.obtenerTablero(mjuego.getTablero().getMatriz());

        } else if (evento.getActionCommand().equals(vjuego.finalizarTurno)) {
            mjuego.getTurnoo().cambiarTurno();
            if (mjuego.getTurnoo().getJugador2().getNombre() == "PC") {
                if (!mjuego.getTurnoo().isTurno()) {
                    if (mjuego.getValidacionGanador().validarGanador(mjuego.getTablero().getMatriz(), mjuego.getTablero().getSimboloPorDefecto())) {
                        mantenerJuegoPC();
                    } else {
                        mjuego.movimientoPC();
                        mantenerJuegoPC();
                    }
                } else {
                    mantenerJuegoPC();
                }
            } else {
                mantenerJuego();
            }
        } else if (evento.getActionCommand().equals(vjuego.finalizarPartida)) {
            System.exit(0);
        } else if (evento.getActionCommand().equals(vjuego.retrocederJugada)) {
            this.mjuego.getTablero().actualizarTablero(vjuego.getFila(), vjuego.getColumna(), mjuego.getTablero().getSimboloPorDefecto());
            vjuego.obtenerTablero(mjuego.getTablero().getMatriz());
        } else if (evento.getActionCommand().equals(vjuego.guardarPartida)) {
            mjuego.guardarPartida(vjuego.mostrarGuardarPartida());
        }

    }

    public char devolverSimboloAlaVista() {
        char simbolo;
        if (mjuego.getTurnoo().isTurno()) {
            simbolo = 'X';
        } else {
            simbolo = 'O';
        }
        return simbolo;
    }

    public void configurar2Jugadores() {
        this.configurarJugador1vsJugador2();

        if (mjuego.getTurnoo().getJugador2().getNombre() != "PC") {
            mantenerJuego();
        }
    }
}
