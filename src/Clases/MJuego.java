package Clases;

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

    /*
    public char[][] inicializarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = this.simboloPorDefecto;
            }
        }
        return matriz;
    }*/
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

    public void realizarMovimiento() {
        if (turno) {
            //this.posicionOcupada(fila, columna, matriz);
            Movimiento mj1 = new Movimiento();

            mj1.setSimbolo('X');
            mj1.setFilas(fila);
            mj1.setColumnas(columna);

            this.jugador1.getMovimientos().add(mj1);
            this.actualizarTablero(fila, columna, mj1.getSimbolo());
        } else {
            if (this.jugador2.getNombre() == "PC") {
                //this.posicionOcupada(fila, columna, matriz);
                Movimiento mj2 = new Movimiento();
                this.movimientoPC();
                mj2.setSimbolo('O');
                mj2.setFilas(fila);
                mj2.setColumnas(columna);
                this.jugador2.getMovimientos().add(mj2);
                //this.actualizarTablero(fila, columna, mj2.getSimbolo());
            } else if (this.jugador2.getNombre() != "PC") {
                //this.posicionOcupada(fila, columna, matriz);
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
/*
    public void posicionOcupada(int fila, int columna, char[][] matriz) {
        boolean posicionOcupada = true;
        do {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[fila][columna] != this.simboloPorDefecto) {
                        System.out.println("La posición está ocupada");
                    } else {
                        posicionOcupada = false;
                    }
                }
            }
        } while (posicionOcupada);
    }*/

    public char[][] getMatriz() {
        return matriz;
    }

    /*
    public void realizarMovimientoPC() {
        Movimiento mj2 = new Movimiento();
        this.movimientoPC();
        mj2.setSimbolo('O');
        mj2.setFilas(fila);
        mj2.setColumnas(columna);
        this.jugador2.getMovimientos().add(mj2);
        this.actualizarTablero(fila, columna, mj2.getSimbolo());
    }*/
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
        matriz[fila][columna] = 'O';
        this.fila = fila;
        this.columna = columna;
    }
/*
    public void deshacerMovimiento(Jugador jugador) {
        
    }*/
    public void deshacerMovimiento(int fila, int columna, char simbolo){
        this.actualizarTablero(fila, columna, simbolo);
        this.crearTablero();
        this.cambiarJugador();
    }

    public void finalizarMovimiento() {
        this.cambiarJugador();
    }

    /*
    public void indicarTurno() {
        if (this.turno) {
            System.out.println("ES EL TURNO DE : " + this.jugador1.getNombre());
        } else {
            System.out.println("ES EL TURNO DE : " + this.jugador2.getNombre());
        }
    }*/
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
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = matriz[i][0];
            if (simbolo != this.simboloPorDefecto) {
                for (int j = 1; j < matriz[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
        return this.simboloPorDefecto;
    }

    public char coincidenciaColumna() {
        char simbolo;
        boolean coincidencia;
        for (int j = 0; j < matriz.length; j++) {
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = matriz[0][j];
            if (simbolo != this.simboloPorDefecto) {
                for (int i = 1; i < matriz[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
        return this.simboloPorDefecto;

    }

    public char coincidenciaDiagonal() {
        char simbolo;
        boolean coincidencia = true;
        //Diagonal principal
        simbolo = matriz[0][0];
        if (simbolo != this.simboloPorDefecto) {
            for (int i = 1; i < matriz.length; i++) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        coincidencia = true;
        //Diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != this.simboloPorDefecto) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
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
