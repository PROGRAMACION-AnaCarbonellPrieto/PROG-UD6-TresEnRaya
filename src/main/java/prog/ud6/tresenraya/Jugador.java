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
    private Simbolos simbolos;
    
    public Jugador(EstadoCasilla color, Simbolos simbolos) {
        this.ficha = color;
        this.simbolos = simbolos;
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
        System.out.printf("\n¡El jugador %s es el ganador!\n", simbolos.obtenerSimbolo(this.ficha));
    }
    
    private Coordenada recogerCoordenada() {
        do {
            System.out.printf("\nJugador con %s\n", simbolos.obtenerSimbolo(this.ficha));
            
            int fila = TresEnRaya.pedirEntero(String.format("Introduce fila [1-%d]: ", Tablero.DIMENSION));
            int columna = TresEnRaya.pedirEntero(String.format("Introduce columna [1-%d]: ", Tablero.DIMENSION));
            
            Coordenada coordenada = new Coordenada(fila, columna);
            if (coordenada.isValida(Tablero.DIMENSION)) return coordenada;
            
            System.out.println("¡Error! Introduce una coordenada válida");
        } while (true);
    }
}
