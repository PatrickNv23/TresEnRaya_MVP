
package Clases;

public class VCJuego implements IVJuego{
    private PJuego presentador;
    char [][] matriz= new char[3][3];
    private char simboloPorDefecto = '-';

    @Override
    public void setPresentador(PJuego p) {
        this.presentador = p;
    }

    @Override
    public void iniciar() {
        presentador.presentar();  
    }
    
    @Override
    public int mostrarVentanaPrincipal() {
        IValidacion validacion = new ValidacionConsola();
        System.out.println("------- TRES EN RAYA ------");
        System.out.println("BIENVENIDOS AL JUEGO");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Iniciar partida");
        System.out.println("2. Reanudar partida");
        return validacion.validarOpcion();
    }
    

    @Override
    public void mostrarReanudarPartida() {
        
    }

    @Override
    public int mostrarSeleccionarModoJuego() {
        IValidacion validacion = new ValidacionConsola();
        System.out.println("Seleccione su modo de juego: ");
        System.out.println("1. Jugador vs PC");
        System.out.println("2. Jugador1 vs Jugador2");
        return validacion.validarOpcion();
    }

    @Override
    public int mostrarElegirJugador() {
        IValidacion validacion = new ValidacionConsola();
        System.out.println("Seleccione el jugador: ");
        System.out.println("1. Jugador1 (X)");
        System.out.println("2. Jugador2 (O)");
        return validacion.validarOpcion();
    }

    @Override
    public String mostrarIngresoNombreJugador(int opcion) {
       IValidacion validacion = new ValidacionConsola();
        System.out.println("Ingrese el nombre del jugador " +opcion+ ": ");
        return validacion.validarString();
    }

    @Override
    public void mostrarTablero() {
       char [][] matriz= new char[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print('-' + " ");
            }
            System.out.println(" ");
        }
    }
    /*
    @Override
    public void mostrarTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
    public void actualizarTablero(int fila, int columna, char simbolo) {
        matriz[fila][columna] = simbolo;
    }*/
    
    

    @Override
    public int mostrarIngresoFilas() {
        ValidacionConsola validacion = new ValidacionConsola();
        System.out.println("Ingrese el número de fila: ");
        return validacion.validarFilasyColumnas();
    }

    @Override
    public int mostrarIngresoColumnas() {
        ValidacionConsola validacion = new ValidacionConsola();
        System.out.println("Ingrese el número de columna: ");
        return validacion.validarFilasyColumnas();
    }

    @Override
    public String mostrarGanador(String nombre) {
        System.out.println("El nombre del ganador es: ");
        return nombre;
    }

    @Override
    public void mostrarGuardarPartida() {
       IValidacion validacion = new ValidacionConsola();
        System.out.println("-------- GUARDAR PARTIDA -------");
        System.out.println("Ingrese el nombre del archivo: ");
        validacion.validarString();
        System.out.println("!GUARDADO!");
    }

}
