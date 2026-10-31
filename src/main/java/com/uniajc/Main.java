
package com.uniajc;

import com.uniajc.criaturas.*;
import com.uniajc.habilidades.HabilidadEspecial;

public class Main {

    // Simula una batalla entre dos criaturas
    public static void simularBatalla(Criatura criatura1,
                                      Criatura criatura2) {

        System.out.println("\n========== INICIO DE BATALLA ==========");
        System.out.println(criatura1.getNombre() + " VS "
                + criatura2.getNombre());

        // Controla si cada criatura ya utilizo su habilidad especial
        boolean habilidad1Usada = false;
        boolean habilidad2Usada = false;

        int turno = 1;

        // La batalla continua mientras ambas criaturas esten vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {

            System.out.println("\n========== TURNO " + turno + " ==========");

            // Turno de la primera criatura
            if (criatura1 instanceof HabilidadEspecial
                    && !habilidad1Usada) {

                System.out.println("\n¡" + criatura1.getNombre()
                        + " utiliza su habilidad especial!");

                ((HabilidadEspecial) criatura1)
                        .usarHabilidadEspecial(criatura2);

                habilidad1Usada = true;

            } else {
                criatura1.atacar(criatura2);
            }

            // Verificar si la segunda criatura sigue viva
            if (!criatura2.estaViva()) {
                break;
            }

            // Turno de la segunda criatura
            if (criatura2 instanceof HabilidadEspecial
                    && !habilidad2Usada) {

                System.out.println("\n¡" + criatura2.getNombre()
                        + " utiliza su habilidad especial!");

                ((HabilidadEspecial) criatura2)
                        .usarHabilidadEspecial(criatura1);

                habilidad2Usada = true;

            } else {
                criatura2.atacar(criatura1);
            }

            turno++;
        }

        // Mostrar el resultado final
        System.out.println("\n========== RESULTADO FINAL ==========");

        if (criatura1.estaViva()) {
            System.out.println("GANADOR: " + criatura1.getNombre());
        } else {
            System.out.println("GANADOR: " + criatura2.getNombre());
        }

        System.out.println("\nSalud final:");

        System.out.println(criatura1.getNombre() + ": "
                + criatura1.getSalud());

        System.out.println(criatura2.getNombre() + ": "
                + criatura2.getSalud());

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        // Crear las diferentes criaturas
        Criatura dragon = new Dragon(
                "Draco", 120, 15, "Escamas de acero");

        Criatura mago = new Mago(
                "Merlin", 100, 12, "Fuego");

        Criatura guerrero = new Guerrero(
                "Thor", 130, 14, "Espada");

        Criatura orco = new Orco(
                "Grom", 110, 13, "Hacha");

        // Primera batalla: Dragon contra Mago
        simularBatalla(dragon, mago);

        // Segunda batalla: Guerrero contra Orco
        simularBatalla(guerrero, orco);

        // Tercera batalla: Dragon contra Guerrero
        simularBatalla(dragon, guerrero);
    }
}
