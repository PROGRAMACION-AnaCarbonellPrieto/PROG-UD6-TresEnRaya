/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud6.tresenraya;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Jugador {
    private EstadoCasilla ficha;
    
    public Jugador(EstadoCasilla color) {
        this.ficha = color;
    }
    
    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada;
        
        do {
            coordenada = recogerCoordenada();
            if (!tablero.isOcupada(coordenada)) break;
            
            System.out.println("¡Error! Coordenada ocupada en el tablero");
        } while (true);
        
        tablero.ponerFicha(coordenada, this.ficha);
    }
    
    public void cantarVictoria() {
        System.out.printf("\n¡El jugador %s es el ganador!\n", this.ficha.toString());
    }
    
    private Coordenada recogerCoordenada() {
        Coordenada coordenada;
        
        do {
            System.out.printf("\nJugador con %s\n", this.ficha.toString());
            
            int fila = pedirEntero(String.format("Introduce fila [1-%d]: ", Tablero.DIMENSION));
            int columna = pedirEntero(String.format("Introduce columna [1-%d]: ", Tablero.DIMENSION));
            
            coordenada = new Coordenada(fila, columna);
            if (coordenada.isValida(Tablero.DIMENSION)) return coordenada;
            
            System.out.println("¡Error! Introduce una coordenada válida");
        } while (true);
    }
    
    private int pedirEntero(String mensaje) {
        do {
            System.out.print(mensaje);
            
            if (TresEnRaya.input.hasNextInt()) {
                return TresEnRaya.input.nextInt();
            }
            
            System.out.println("¡Error! Debe introducir un número entero");
            TresEnRaya.input.next();
        } while (true);
    }
}
