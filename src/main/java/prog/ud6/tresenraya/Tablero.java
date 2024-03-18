/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud6.tresenraya;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Tablero {
    public final static int DIMENSION = 3;
    private EstadoCasilla[][] casillas;
    
    public Tablero() {
        vaciar();
    }
    
    public void mostrar() {
        System.out.print("\n| |");
        
        for (int i = 0; i < DIMENSION; i++) {
            System.out.printf("%d|", i + 1);
        }
        
        System.out.println();
        
        for (int i = 0; i < DIMENSION; i++) {
            System.out.printf("|%d|", i + 1);
            for (int j = 0; j < DIMENSION; j++) {
                String ficha = casillas[i][j].toString();
                System.out.printf("%s|", ficha);
            }
            System.out.println();
        }
    }
    
    public boolean hayTresEnRaya() {
        return (hayTresEnRaya(EstadoCasilla.FICHA_O) || hayTresEnRaya(EstadoCasilla.FICHA_X));
    }
    
    public boolean isOcupada(Coordenada coordenada) {
        return (casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] != EstadoCasilla.VACIO);
    }
    
    public void ponerFicha(Coordenada coordenada, EstadoCasilla ficha) {
        casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = ficha;
    }
    
    public void vaciar() {
        casillas = new EstadoCasilla[DIMENSION][DIMENSION];
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = EstadoCasilla.VACIO;
            }
        }
    }
    
    public boolean estaLleno() {
        for (EstadoCasilla[] filas: casillas) {
            for (EstadoCasilla casilla: filas) {
                if (casilla == EstadoCasilla.VACIO) return false;
            }
        }
        
        return true;
    }
    
    private boolean hayTresEnRaya(EstadoCasilla color) {
        int cont = 0;
        
        for (EstadoCasilla[] filas: casillas) {
            for (EstadoCasilla casilla: filas) {
                if (casilla == color) cont++;
            }
            if (cont == DIMENSION) return true;
            cont = 0;
        }
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (casillas[j][i] == color) cont++;
            }
            if (cont == DIMENSION) return true;
            cont = 0;
        }
        
        for (int i = 0; i < DIMENSION; i++) {
            if (casillas[i][i] == color) cont++;
        }
        if (cont == DIMENSION) return true;
        cont = 0;
        
        for (int i = 0; i < DIMENSION; i++) {
            if (casillas[i][DIMENSION - 1 - i] == color) cont++;
        }
        if (cont == DIMENSION) return true;
        
        return false;
    }
}
