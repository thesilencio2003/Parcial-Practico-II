package com.uniajc;

import com.uniajc.criaturas.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BatallaTest {

    @Test
    @DisplayName("Simular batalla entre Dragon y Mago concluye con un ganador")
    void testBatallaDragonVsMago() {
        Criatura dragon = new Dragon("Draco", 120, 15, "Escamas de acero");
        Criatura mago = new Mago("Merlin", 100, 12, "Fuego");

        Main.simularBatalla(dragon, mago);

          assertTrue(dragon.estaViva() ^ mago.estaViva(), "Debe haber exactamente un ganador vivo al finalizar");

        if (dragon.estaViva()) {
            assertTrue(dragon.getSalud() > 0);
            assertEquals(0, mago.getSalud());
            assertFalse(mago.estaViva());
        } else {
            assertTrue(mago.getSalud() > 0);
            assertEquals(0, dragon.getSalud());
            assertFalse(dragon.estaViva());
        }
    }

    @Test
    @DisplayName("Simular batalla entre Guerrero y Orco")
    void testBatallaGuerreroVsOrco() {
        Criatura guerrero = new Guerrero("Thor", 130, 14, "Espada");
        Criatura orco = new Orco("Grom", 110, 13, "Hacha");

        Main.simularBatalla(guerrero, orco);

        assertTrue(guerrero.estaViva() ^ orco.estaViva(), "Debe haber un ganador al terminar el combate");
        assertTrue(guerrero.getSalud() == 0 || orco.getSalud() == 0, "Al menos una criatura debe quedar en 0 de salud");
    }

    @Test
    @DisplayName("Polimorfismo: arreglo o lista de criaturas tratadas genéricamente")
    void testPolimorfismoColeccionCriaturas() {
        Criatura[] ejercito = new Criatura[] {
            new Dragon("Smaug", 150, 25, "Escamas Doradas"),
            new Mago("Saruman", 90, 18, "Orbe"),
            new Guerrero("Gimli", 120, 15, "Hacha Doble"),
            new Orco("Lurtz", 100, 14, "Arco Pesado")
        };

        for (Criatura c : ejercito) {
            assertNotNull(c.getNombre());
            assertTrue(c.estaViva());
            assertTrue(c.getSalud() > 0);
            assertTrue(c.getFuerza() > 0);
        }
    }
}
