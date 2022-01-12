package Clases;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MJuego {
    private int id;
    private int opcionModoJuego;
    private int opcionJugadorElegido;
    private int opcionVentanaPrincipal;
    private int opcionJuego;
    private int opcionDespuesGuardado;
    private Turno turnoo = new Turno();
    private Tablero tablero = new Tablero();
    private Ganador validacionGanador = new Ganador();

    public Turno getTurnoo() {
        return turnoo;
    }
    
    public int getOpcionDespuesGuardado() {
        return opcionDespuesGuardado;
    }

    public void setOpcionDespuesGuardado(int opcionDespuesGuardado) {
        this.opcionDespuesGuardado = opcionDespuesGuardado;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getOpcionJuego() {
        return opcionJuego;
    }

    public void setOpcionJuego(int opcionJuego) {
        this.opcionJuego = opcionJuego;
    }

    private String ganador;

    public int getOpcionModoJuego() {
        return opcionModoJuego;
    }

    public void setOpcionVentanaPrincipal(int opcionVentanaPrincipal) {
        this.opcionVentanaPrincipal = opcionVentanaPrincipal;
    }

    public void setOpcionModoJuego(int opcionModoJuego) {
        this.opcionModoJuego = opcionModoJuego;
    }

    public Tablero getTablero() {
        return tablero;
    }
    

    public void setOpcionJugadorElegido(int opcionJugadorElegido) {
        this.opcionJugadorElegido = opcionJugadorElegido;
    }

    public void realizarMovimiento() {
        if (this.getTurnoo().isTurno()) {
            Movimiento mj1 = new Movimiento();

            mj1.setSimbolo('X');
            mj1.setFilas(this.tablero.getFila());
            mj1.setColumnas(this.tablero.getColumna());

            this.turnoo.getJugador1().getMovimientos().add(mj1);
            this.tablero.actualizarTablero(this.tablero.getFila(),this.tablero.getColumna(), mj1.getSimbolo());
        } else {
            if (this.getTurnoo().getJugador2().getNombre() == "PC") {
                Movimiento mj2 = new Movimiento();
                this.movimientoPC();
                mj2.setSimbolo('O');
                mj2.setFilas(this.tablero.getFila());
                mj2.setColumnas(this.tablero.getColumna());
                this.getTurnoo().getJugador2().getMovimientos().add(mj2);
            } else if (this.getTurnoo().getJugador2().getNombre() != "PC") { 
                Movimiento mj2 = new Movimiento();
                mj2.setSimbolo('O');
                mj2.setFilas(this.tablero.getFila());
                mj2.setColumnas(this.tablero.getColumna());
                this.getTurnoo().getJugador2().getMovimientos().add(mj2);
                this.tablero.actualizarTablero(this.tablero.getFila(),this.tablero.getColumna(), mj2.getSimbolo());
            }
        }
        this.tablero.crearTablero();
        definirGanador();
        finalizarMovimiento();
    }

    public void guardarPartida(String nombrearchivo) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        String jugador1 = "", jugador2 = "", nombrepartida = "";
        boolean turno = true;
        char[][] tablero = new char[3][3];
        archivo = new File(nombrearchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                nombrepartida = nombrearchivo;
                jugador1 = this.getTurnoo().getJugador1().getNombre();
                jugador2 = this.getTurnoo().getJugador2().getNombre();
                tablero = this.tablero.getMatriz();
                turno = this.getTurnoo().isTurno();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println("-------------------");
                linea.println("Partida: " + nombrepartida);
                linea.println("Jugador1 ----> " + jugador1);
                linea.println("Jugador2 ----> " + jugador2);
                linea.println("-------------------");
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        linea.print(this.tablero.getMatriz()[i][j] + " ");
                    }
                    linea.println(" ");
                }
                if (turno) {
                    linea.println("ES EL TURNO DE : " + jugador1);
                } else {
                    linea.println("ES EL TURNO DE : " + jugador2);
                }
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(MJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                nombrepartida = nombrearchivo;
                jugador1 = this.getTurnoo().getJugador1().getNombre();
                jugador2 = this.getTurnoo().getJugador2().getNombre();
                tablero = this.tablero.getMatriz();
                turno = this.getTurnoo().isTurno();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println("-------------------");
                linea.println("Partida: " + nombrepartida);
                linea.println("Jugador1 ----> " + jugador1);
                linea.println("Jugador2 ----> " + jugador2);
                linea.println("-------------------");
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        linea.print(this.tablero.getMatriz()[i][j] + " ");
                    }
                    linea.println(" ");
                }
                if (turno) {
                    linea.println("ES EL TURNO DE : " + jugador1);
                } else {
                    linea.println("ES EL TURNO DE : " + jugador2);
                }
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(MJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public String leerPartida(String direccion) {
        String texto = "";
        int contador = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temporal = "";
            String bfread;
            while ((bfread = bf.readLine()) != null) {
                contador++;
                if (contador >= 6 && contador <= 8) {
                    temporal += bfread;
                }
            }
            texto = temporal;
        } catch (Exception e) {
            System.out.println("No se encontró el archivo");
        }
        return texto;
    }

    public char[] convertirStringToCharArray(String contenidoTexto) {
        char[] caracteres = contenidoTexto.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            System.out.print(caracteres[i] + " ");
        }
        return caracteres;
    }

    public int getOpcionVentanaPrincipal() {
        return opcionVentanaPrincipal;
    }

    public void reanudarPartida() {

    }

    public void movimientoPC() {
        int fila, columna;
        do {
            do {
                fila = (int) (Math.random() * (3 - 1 + 1) + 1);
            } while (fila < 1 || fila > 3);
            fila--;

            do {
                columna = (int) (Math.random() * (3 - 1 + 1) + 1);
            } while (columna < 1 || columna > 3);
            columna--;

        } while (this.tablero.getMatriz()[fila][columna] != this.tablero.getSimboloPorDefecto());
        this.tablero.setFila(fila);
        this.tablero.setColumna(columna);
        this.tablero.getMatriz()[fila][columna] = 'O';
    }

    public void deshacerMovimiento(int fila, int columna, char simbolo) {
        this.tablero.actualizarTablero(fila, columna, simbolo);
        this.tablero.crearTablero();
        this.getTurnoo().cambiarTurno();
    }

    public void finalizarMovimiento() {
        this.getTurnoo().cambiarTurno();
    }
    
    public void definirGanador() {
        if (this.validacionGanador.validarGanador(this.tablero.getMatriz(), this.tablero.getSimboloPorDefecto())) {
            if (this.getTurnoo().isTurno()) { 
                System.out.println("El ganador es: " + this.getTurnoo().getJugador1().getNombre());
            } else {
                System.out.println("El ganador es: " + this.getTurnoo().getJugador2().getNombre());
            }
        }
    }

    public int getOpcionJugadorElegido() {
        return opcionJugadorElegido;
    }

    public Ganador getValidacionGanador() {
        return validacionGanador;
    }

}
