
package Clases;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Movimiento> movimientos = new ArrayList<>();
    private TipoJugador tipojugador;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    public void mostrarMovimientos(ArrayList<Movimiento> movimientos,String nombre){
        for(Movimiento m: movimientos){
            System.out.println("Jugador: "+nombre+", Simbolo: "+m.getSimbolo()+", Fila: "+m.getFilas()+", Columna: "+m.getColumnas()+"\n");
        }
    }

    public TipoJugador getTipojugador() {
        return tipojugador;
    }

    public void setTipojugador(TipoJugador tipojugador) {
        this.tipojugador = tipojugador;
    }
    
    
    
}
