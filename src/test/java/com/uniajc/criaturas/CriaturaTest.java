package com.uniajc.criaturas;

import com.uniajc.habilidades.HabilidadEspecial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CriaturaTest {

    private Dragon dragon;
    private Mago mago;
    private Guerrero guerrero;
    private Orco orco;

    @BeforeEach
    void setUp() {
        dragon = new Dragon("Fafnir", 100, 20, "Escamas de Fuego");
        mago = new Mago("Gandalf", 80, 15, "Relámpago");
        guerrero = new Guerrero("Aragorn", 110, 18, "Andúril");
        orco = new Orco("Azog", 90, 16, "Maza Pesada");
    }

    @Test
    @DisplayName("Verificar valores iniciales y estado estaViva")
    void testEstadoInicialYEstaViva() {
        assertTrue(dragon.estaViva(), "El dragón debe iniciar vivo con salud > 0");
        assertEquals("Fafnir", dragon.getNombre());
        assertEquals(100, dragon.getSalud());
        assertEquals(20, dragon.getFuerza());
        assertEquals("Escamas de Fuego", dragon.getEscamas());

         dragon.setSalud(0);
        assertFalse(dragon.estaViva(), "La criatura no debe estar viva con salud 0");
    }

    @Test
    @DisplayName("Ataque del Dragón debe ser el doble de su fuerza (fuerza * 2)")
    void testAtaqueDragon() {
        dragon.atacar(guerrero);
        assertEquals(73, guerrero.getSalud(), "El guerrero debería quedar con 73 de salud tras recibir 37 de daño");
    }

    @Test
    @DisplayName("Defensa del Dragón reduce 5 de daño gracias a sus escamas")
    void testDefensaDragon() {
        dragon.defender(20);
        assertEquals(85, dragon.getSalud());
    }

    @Test
    @DisplayName("Ataque y defensa del Mago")
    void testAtaqueYDefensaMago() {
        mago.atacar(orco);
        assertEquals(77, orco.getSalud());
        mago.defender(10);
        assertEquals(74, mago.getSalud());
    }

    @Test
    @DisplayName("Ataque y defensa del Guerrero")
    void testAtaqueYDefensaGuerrero() {
        guerrero.atacar(dragon);
        assertEquals(87, dragon.getSalud());
        guerrero.defender(10);
        assertEquals(103, guerrero.getSalud());
    }

    @Test
    @DisplayName("Ataque del Orco debe incluir bonificación (+3)")
    void testAtaqueYDefensaOrco() {
        orco.atacar(mago);
        assertEquals(65, mago.getSalud());
        orco.defender(10);
        assertEquals(82, orco.getSalud());
    }

    @Test
    @DisplayName("Uso de Habilidad Especial en criaturas que implementan la interfaz")
    void testHabilidadEspecial() {

        assertInstanceOf(HabilidadEspecial.class, dragon);
        dragon.usarHabilidadEspecial(guerrero);
        assertEquals(53, guerrero.getSalud());

        assertInstanceOf(HabilidadEspecial.class, mago);
        mago.usarHabilidadEspecial(orco);
        assertEquals(57, orco.getSalud());
    }

    @Test
    @DisplayName("El daño letal no debe dejar la salud en números negativos")
    void testSaludNoNegativa() {
        dragon.defender(500);
        assertEquals(0, dragon.getSalud(), "La salud no debe ser negativa tras daño excesivo");
        assertFalse(dragon.estaViva());
    }
}
