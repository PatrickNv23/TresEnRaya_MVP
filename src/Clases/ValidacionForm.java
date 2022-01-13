
package Clases;

import javax.swing.JOptionPane;


public class ValidacionForm implements IValidacion {
    @Override
    public String validarGanador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String validarString() {
        boolean valido = true;
        String entrada="";
        do {
            entrada = JOptionPane.showInputDialog(formatoEntrada(textoGuardadoPartida()));
            if (entrada.isEmpty() || entrada==null) {
                this.mostrarError("Ingrese una cadena de caracteres");
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        return entrada;
    }
    
    public String formatoEntrada(String formato){
        return formato;
    }
    
    public String textoGuardadoPartida(){
        return "Ingrese el nombre de la partida: ";
    }

    @Override
    public char validarMovimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarError(String formato) {
        JOptionPane.showMessageDialog(null,formato);
    }

    @Override
    public int validarMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
