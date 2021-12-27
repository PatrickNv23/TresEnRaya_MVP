package Clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacionConsola implements IValidacion {

    Scanner leer = new Scanner(System.in);

    @Override
    public int validarMenu() {
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                String entrada = leer.next();
                opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > 2) {
                    this.mostrarError("Ingrese un número del 1 al 2");
                } else {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese un número");
            }
        } while (!valido);
        return opcion;
    }

    public int validarOpciones() {
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                String entrada = leer.next();
                opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > 3) {
                    this.mostrarError("Ingrese un número del 1 al 3");
                } else {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese un número");
            }
        } while (!valido);
        return opcion;
    }

    /*
    @Override
    public String validarString() {
        boolean valido = false;
        String entrada = "";
        do {
            
            try {
                String entrada2 = leer.next();
                entrada = entrada2;
        //entrada = leer.next();
                if (entrada == "") {
                    this.mostrarError("Ingrese una cadena de caracteres");
                }else{
                    valido = true;
                }
//InputMismatchException
            } catch (Exception e) {
                this.mostrarError("Ingrese una cadena de caracteres");
            }
        } while (valido);
        return entrada;
    }*/
    
    
    @Override
    public String validarString() {
        boolean valido = true;
        String entrada="";
        do {
            entrada = leer.nextLine();
            if (entrada.isEmpty() || entrada==null) {
                this.mostrarError("Ingrese una cadena de caracteres");
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        return entrada;
    }

    public int validarFilasyColumnas() {
        boolean valido = false;
        int posicion = 0;
        do {
            try {
                String entrada = leer.next();
                posicion = Integer.parseInt(entrada);
                if (posicion < 0 || posicion > 2) {
                    this.mostrarError("Ingrese un número del 0 al 2");
                } else {
                    valido = true;
                }

            } catch (Exception e) {
                this.mostrarError("Ingrese un número");
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
        System.out.println("Error: " + formato);
    }

}
