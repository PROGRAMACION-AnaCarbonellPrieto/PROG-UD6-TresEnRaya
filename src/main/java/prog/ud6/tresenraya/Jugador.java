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
        boolean isOcupado;
        
        do {
            coordenada = recogerCoordenada();
            isOcupado = tablero.isOcupada(coordenada);
            
            if (isOcupado) System.out.println("¡Error! Coordenada ocupada en el tablero");
        } while (isOcupado);
        
        tablero.ponerFicha(coordenada, this.ficha);
    }
    
    public void cantarVictoria() {
        System.out.printf("\n¡El jugador %s es el ganador!\n", simbolos.obtenerSimbolo(this.ficha));
    }
    
    private Coordenada recogerCoordenada() {
        Coordenada coordenada;
        boolean isValid;
        
        do {
            System.out.printf("\nJugador con %s\n", simbolos.obtenerSimbolo(this.ficha));
            
            int fila = TresEnRaya.pedirEntero(String.format("Introduce fila [1-%d]: ", Tablero.DIMENSION));
            int columna = TresEnRaya.pedirEntero(String.format("Introduce columna [1-%d]: ", Tablero.DIMENSION));
            
            coordenada = new Coordenada(fila, columna);
            isValid = coordenada.isValida(Tablero.DIMENSION);
            
            if (!isValid) System.out.println("¡Error! Introduce una coordenada válida");
        } while (!isValid);
        
        return coordenada;
    }
}
