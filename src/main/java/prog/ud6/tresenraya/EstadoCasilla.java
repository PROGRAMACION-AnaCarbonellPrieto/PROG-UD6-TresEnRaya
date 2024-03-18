/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud6.tresenraya;

/**
 *
 * @author Ana Carbonell Prieto
 */
public enum EstadoCasilla {
    FICHA_O("O"),
    FICHA_X("X"),
    VACIO(" ");
    
    private String color;

    EstadoCasilla(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.color;
    }
}
