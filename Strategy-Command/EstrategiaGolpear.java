/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solid;

/**
 *
 * @author thiag
 */
// Strategy concreta: Golpear
public class EstrategiaGolpear implements EstrategiaCombate {
    @Override
    public void usar() {
        System.out.println("La espada lanza un golpe!");
    }
}
