
package Clases;

public interface IValidacion {
    String validarGanador();
    String validarString();
    char validarMovimiento();
    void mostrarError(String formato);
    int validarOpcion();
}
