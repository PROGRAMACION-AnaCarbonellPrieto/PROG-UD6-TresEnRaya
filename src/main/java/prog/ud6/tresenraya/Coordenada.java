/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud6.tresenraya;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Coordenada {
    private int fila;
    private int columna;
    
    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFila() {
        return this.fila;
    }
    
    public int getColumna() {
        return this.columna;
    }
    
    public boolean isValida(int dimension) {
        return (this.fila > 0 && this.fila <= dimension && this.columna > 0 && this.columna <= dimension);
    }
}
