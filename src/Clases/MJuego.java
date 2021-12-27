package Clases;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MJuego {

    private int id;
    private int opcionModoJuego;
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private int fila;
    private int columna;
    private int opcionJugadorElegido;
    private int opcionVentanaPrincipal;
    private char[][] matriz = new char[3][3];
    private char simboloPorDefecto = '-';
    private boolean turno = true;
    private int opcionJuego;
    private int opcionDespuesGuardado;

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

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setOpcionJugadorElegido(int opcionJugadorElegido) {
        this.opcionJugadorElegido = opcionJugadorElegido;
    }

    public void inicializarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = this.simboloPorDefecto;
            }
        }
    }

    public void crearTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void actualizarTablero(int fila, int columna, char simbolo) {
        matriz[fila][columna] = simbolo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void crearPartida(Jugador jugador1, Jugador jugador2) {

    }

    public void cambiarJugador() {
        this.turno = !this.turno;
    }

    public boolean existeEmpate(int intentos) {
        boolean empate = false;
        boolean posicionocupada = false;
        if (intentos >= 9) {
            if(matriz[0][0]!=this.simboloPorDefecto && matriz[0][1] != this.simboloPorDefecto &&
               matriz[0][2] != this.simboloPorDefecto && matriz[1][0] != this.simboloPorDefecto &&
               matriz[1][1] != this.simboloPorDefecto && matriz[1][2] != this.simboloPorDefecto &&
               matriz[2][0] != this.simboloPorDefecto && matriz[2][1] != this.simboloPorDefecto &&
               matriz[2][2] != this.simboloPorDefecto)
            {
                posicionocupada = true;
            }
            else
            {
                posicionocupada = false;
            }
        }
        if (posicionocupada && !this.ganador()) {
            empate = true;
        }
        return empate;
    }
    
    /*
    public boolean existeEmpate(int intentos) {
        boolean empate = false;
        boolean posicionocupada = false;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] != this.simboloPorDefecto) {
                        posicionocupada = true;
                    } else {
                        posicionocupada = false;
                    }

                }
            }
        }
        if (posicionocupada && !this.ganador()) {
            empate = true;
        }
        return empate;
    }*/

    public void realizarMovimiento() {
        if (turno) {
            Movimiento mj1 = new Movimiento();

            mj1.setSimbolo('X');
            mj1.setFilas(fila);
            mj1.setColumnas(columna);

            this.jugador1.getMovimientos().add(mj1);
            this.actualizarTablero(fila, columna, mj1.getSimbolo());
        } else {
            if (this.jugador2.getNombre() == "PC") {
                Movimiento mj2 = new Movimiento();
                this.movimientoPC();
                mj2.setSimbolo('O');
                mj2.setFilas(fila);
                mj2.setColumnas(columna);
                this.jugador2.getMovimientos().add(mj2);
            } else if (this.jugador2.getNombre() != "PC") {
                Movimiento mj2 = new Movimiento();
                mj2.setSimbolo('O');
                mj2.setFilas(fila);
                mj2.setColumnas(columna);
                this.jugador2.getMovimientos().add(mj2);
                this.actualizarTablero(fila, columna, mj2.getSimbolo());
            }
        }
        this.crearTablero();
        definirGanador();
        finalizarMovimiento();
    }

    public char[][] getMatriz() {
        return matriz;
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
                jugador1 = this.getJugador1().getNombre();
                jugador2 = this.getJugador2().getNombre();
                tablero = this.getMatriz();
                turno = this.turno;
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println("-------------------");
                linea.println("Partida: " + nombrepartida);
                linea.println("Jugador1 ----> " + jugador1);
                linea.println("Jugador2 ----> " + jugador2);
                linea.println("-------------------");
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        linea.print(matriz[i][j] + " ");
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
                jugador1 = this.getJugador1().getNombre();
                jugador2 = this.getJugador2().getNombre();
                tablero = this.getMatriz();
                turno = this.turno;
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println("-------------------");
                linea.println("Partida: " + nombrepartida);
                linea.println("Jugador1 ----> " + jugador1);
                linea.println("Jugador2 ----> " + jugador2);
                linea.println("-------------------");
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        linea.print(matriz[i][j] + " ");
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

        } while (matriz[fila][columna] != this.simboloPorDefecto);
        this.fila = fila;
        this.columna = columna;
        matriz[fila][columna] = 'O';

    }

    public void deshacerMovimiento(int fila, int columna, char simbolo) {
        this.actualizarTablero(fila, columna, simbolo);
        this.crearTablero();
        this.cambiarJugador();
    }

    public void finalizarMovimiento() {
        this.cambiarJugador();
    }

    public boolean indicarTurno() {
        if (this.turno) {
            System.out.println("ES EL TURNO DE : " + this.jugador1.getNombre());
        } else {
            System.out.println("ES EL TURNO DE : " + this.jugador2.getNombre());
        }
        return turno;
    }

    public char coincidenciaLinea() {
        char simbolo;
        boolean coincidencia;
        for (int i = 0; i < matriz.length; i++) {
            coincidencia = true;
            simbolo = matriz[i][0];
            if (simbolo != this.simboloPorDefecto) {
                for (int j = 1; j < matriz[0].length; j++) {
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        return this.simboloPorDefecto;
    }

    public char coincidenciaColumna() {
        char simbolo;
        boolean coincidencia;
        for (int j = 0; j < matriz.length; j++) {
            coincidencia = true;
            simbolo = matriz[0][j];
            if (simbolo != this.simboloPorDefecto) {
                for (int i = 1; i < matriz[0].length; i++) {
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        return this.simboloPorDefecto;

    }

    public char coincidenciaDiagonal() {
        char simbolo;
        boolean coincidencia = true;
        simbolo = matriz[0][0];
        if (simbolo != this.simboloPorDefecto) {
            for (int i = 1; i < matriz.length; i++) {
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        coincidencia = true;

        // diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != this.simboloPorDefecto) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        return this.simboloPorDefecto;

    }

    public boolean ganador() {
        char simbolo = coincidenciaLinea();
        if (simbolo != this.simboloPorDefecto) {
            return true;
        }
        simbolo = coincidenciaColumna();

        if (simbolo != this.simboloPorDefecto) {
            return true;
        }
        simbolo = coincidenciaDiagonal();
        if (simbolo != this.simboloPorDefecto) {
            return true;
        }
        return false;
    }

    public void definirGanador() {
        if (this.ganador()) {
            if (this.isTurno()) {
                System.out.println("El ganador es: " + this.getJugador1().getNombre());
            } else {
                System.out.println("El ganador es: " + this.getJugador2().getNombre());
            }
        }
    }

    public void seleccionModoJuego() {

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public int getOpcionJugadorElegido() {
        return opcionJugadorElegido;
    }

}
