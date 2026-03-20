/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author jonat
 */
public class Alerta implements Observer {
    @Override
    public void actualizar(String mensaje) {
        System.out.println(mensaje);
    }
}
