/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud6.tresenraya;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Simbolos {
    private final String[][] PACKS = {
        {"X", "O"},
        {"$", "€"}
    };
    private int packSeleccionado;

    public Simbolos() {
        this.packSeleccionado = 1;
    }
    
    public void seleccionar() {
        System.out.println("Vamos a seleccionar los iconos con los que jugar:");
        
        for (int i = 0; i < PACKS.length; i++) {
            System.out.printf("%d) %s %s\n", i + 1, PACKS[i][0], PACKS[i][1]);
        }
        System.out.println((PACKS.length + 1) + ") Aleatorio");
        
        do {
            this.packSeleccionado = TresEnRaya.pedirEntero(String.format("Selecciona una opción [1-%d]: ", (PACKS.length + 1)));
            
            if (this.packSeleccionado > 0 || this.packSeleccionado <= (PACKS.length + 1)) break;
            
            System.out.println("Debe introducir un valor dentro del rango establecido");
        } while(true);
        
        if (this.packSeleccionado == (PACKS.length + 1)) {
            this.packSeleccionado = (int) (Math.random() * PACKS.length + 1);
        }
    }
    
    public String obtenerSimbolo(EstadoCasilla estadoCasilla) {
        return (estadoCasilla == EstadoCasilla.FICHA_X) ? PACKS[this.packSeleccionado - 1][0] : (estadoCasilla == EstadoCasilla.FICHA_O) ? PACKS[this.packSeleccionado - 1][1] : " ";
    }
}
