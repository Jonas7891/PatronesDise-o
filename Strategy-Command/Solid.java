/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solid;

/**
 *
 * @author thiag
 */





// ==========================
// COMMAND PATTERN
// ==========================

// Interfaz Command
interface Command {
    void execute();
}

// Command concreto: click izquierdo
class ClickIzquierdoCommand implements Command {

    private Espada espada;

    public ClickIzquierdoCommand(Espada espada) {
        this.espada = espada;
    }

    @Override
    public void execute() {
        espada.setEstrategia(new EstrategiaGolpear());
        espada.usar();
    }
}

// Command concreto: click derecho
class ClickDerechoCommand implements Command {

    private Espada espada;

    public ClickDerechoCommand(Espada espada) {
        this.espada = espada;
    }

    @Override
    public void execute() {
        espada.setEstrategia(new EstrategiaCubrirse());
        espada.usar();
    }
}

// Invoker
class Jugador {

    private Command clickIzquierdo;
    private Command clickDerecho;

    public void setClickIzquierdo(Command command) {
        this.clickIzquierdo = command;
    }

    public void setClickDerecho(Command command) {
        this.clickDerecho = command;
    }

    public void clickIzquierdo() {
        System.out.println("Jugador hace CLICK IZQUIERDO");
        clickIzquierdo.execute();
    }

    public void clickDerecho() {
        System.out.println("Jugador hace CLICK DERECHO");
        clickDerecho.execute();
    }
}


// ==========================
// MAIN (USA AMBOS PATRONES)
// ==========================

public class Main {

    public static void main(String[] args) {

        // Receiver
        Espada espada = new Espada();

        // Commands
        Command atacar = new ClickIzquierdoCommand(espada);
        Command cubrirse = new ClickDerechoCommand(espada);

        // Invoker
        Jugador jugador = new Jugador();

        jugador.setClickIzquierdo(atacar);
        jugador.setClickDerecho(cubrirse);

        // Simulación Minecraft
        jugador.clickIzquierdo();

        System.out.println();

        jugador.clickDerecho();
    }
}
