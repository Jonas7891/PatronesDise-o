/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solid;

/**
 *
 * @author thiag
 */
// Context
public class Espada {

    private EstrategiaCombate estrategia;

    public void setEstrategia(EstrategiaCombate estrategia) {
        this.estrategia = estrategia;
    }

    public void usar() {
        if (estrategia != null) {
            estrategia.usar();
        } else {
            System.out.println("No hay estrategia asignada.");
        }
    }
}
