package Clases;

import java.util.Scanner;

public class ValidacionConsola implements IValidacion {

    Scanner leer = new Scanner(System.in);

    @Override
    public int validarOpcion() {
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                opcion = leer.nextInt();
                if (opcion == 1 || opcion == 2) {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese una opción");
            }
        } while (!valido);
        return opcion;
    }

    @Override
    public String validarString() {
        boolean valido = false;
        String entrada = "";
        do {
            try {
                entrada = leer.nextLine();
                if (entrada != "") {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese una opción");
            }
        } while (!valido);
        return entrada;
    }

    public int validarFilasyColumnas() {
        boolean valido = false;
        int posicion = 0;
        do {
            try {
                posicion = leer.nextInt();
                if (posicion>=0 && posicion<=2) {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese una opción");
            }
        } while (!valido);
        return posicion;
    }
    

    @Override
    public String validarGanador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char validarMovimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarError(String formato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
