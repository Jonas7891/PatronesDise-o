/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package banco;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class Banco {

    private double saldo;
    private ArrayList<String> historial = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    public double verSaldo() {
        return saldo;
    }

    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    public void notificarObservadores(String mensaje) {
        for (Observer o : observadores) {
            o.actualizar(mensaje);
        }
    }
    
    public void consignar(double consignacion) {
        saldo += consignacion;
        historial.add("Consignacion de: $" + consignacion);
        notificarObservadores("La consignacion ha sido exitosa");
    }

    public void retirar(double retiro) {
        if (retiro <= saldo) {
            saldo -= retiro;
            historial.add("Retiro de: $" + retiro);
            notificarObservadores("El retiro ha sido exitoso");
        } else {
            notificarObservadores("Saldo insuficiente");
        }
    }

    public void mostrarHistorial() {
        System.out.println("===== HISTORIAL DE MOVIMIENTOS =====");

        Iterator<String> iterator = historial.iterator();

        if (!iterator.hasNext()) {
            System.out.println("No hay movimientos registrados.");
        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco cuenta = new Banco();
        
        Alerta alertaSistema = new Alerta();
        cuenta.agregarObservador(alertaSistema);
        
        int opcion;

        do {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consignar dinero");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("===== SU SALDO ES DE =====");
                    System.out.println(cuenta.verSaldo());
                    break;

                case 2:
                    System.out.print("Ingrese valor a retirar: ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;

                case 3:
                    System.out.print("Ingrese valor a consignar: ");
                    double consignacion = scanner.nextDouble();
                    cuenta.consignar(consignacion);
                    break;

                case 4:
                    cuenta.mostrarHistorial();
                    break;

                case 5:
                    cuenta.notificarObservadores("Gracias por utilizar el sistema bancario");
                    break;

                default:
                    cuenta.notificarObservadores("Opcion invalida");
            }
        } while (opcion != 5);
    }
}