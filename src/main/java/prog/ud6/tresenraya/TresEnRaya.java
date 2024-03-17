/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prog.ud6.tresenraya;

import java.util.Scanner;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class TresEnRaya {
    public static Scanner input;
    private Tablero tablero;
    private Jugador[] jugadores;
    
    public TresEnRaya() {
        this.tablero = new Tablero();
        
        Jugador jugador1 = new Jugador(EstadoCasilla.FICHA_O);
        Jugador jugador2 = new Jugador(EstadoCasilla.FICHA_X);
        
        this.jugadores = new Jugador[2];
        this.jugadores[0] = jugador1;
        this.jugadores[1] = jugador2;
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
    }
    
    public void jugar() {
        do {
            System.out.println("\nVamos a jugar al \"Tres en Raya\"");
            boolean isGanado;
            int turno = 1;

            do {
                if (turno == 0) {
                    turno++;
                } else {
                    turno--;
                }

                this.tablero.mostrar();
                jugadores[turno].ponerFicha(this.tablero);
                
            } while (!(isGanado = tablero.hayTresEnRaya()) && !tablero.estaLleno());

            if (isGanado) {
                jugadores[turno].cantarVictoria();
            } else {
                System.out.println("Empate");
            }
            
            tablero.mostrar();
            tablero.vaciar();
        } while (pedirConfirmacion());
    }
    
    private boolean pedirConfirmacion() {
        do {
            System.out.print("\n¿Quieres volver a jugar? [S/N]: ");
            
            char userInput = input.next().charAt(0);
            
            if (userInput == 'S') {
                return true;
            } else if (userInput == 'N') {
                return false;
            }
            
            System.out.println("¡Error! Debes introducir S o N");
        } while (true);
    }
}
