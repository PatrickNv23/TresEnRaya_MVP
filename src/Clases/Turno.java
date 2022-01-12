
package Clases;

public class Turno {
    private boolean turno = true;
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    
    public boolean indicarTurno(){
          if (this.turno) {
            System.out.println("ES EL TURNO DE : " + this.jugador1.getNombre());
        } else {
            System.out.println("ES EL TURNO DE : " + this.jugador2.getNombre());
        }
        return turno;
    }
    
    public void cambiarTurno(){
        this.turno = !this.turno;
    }

    public boolean isTurno() {
        return turno;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    
    
}
