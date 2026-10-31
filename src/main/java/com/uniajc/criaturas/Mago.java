package com.uniajc.criaturas;

import com.uniajc.habilidades.HabilidadEspecial;

public class Mago extends Criatura implements HabilidadEspecial {

    private String hechizos;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = this.fuerza;
        System.out.println(this.nombre + " lanza un hechizo de " + this.hechizos + " contra " 
                + objetivo.getNombre() + ", causando " + daño + " puntos de daño.");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int reduccion = 4;
        int dañoEfectivo = Math.max(1, daño - reduccion);

        this.salud = Math.max(0, this.salud - dañoEfectivo);

        System.out.println(this.nombre + " activa una barrera mágica reduciendo " + reduccion 
                + " de daño. Daño recibido: " + dañoEfectivo + ". Salud restante: " + this.salud);
    }

    @Override
    public void usarHabilidadEspecial(Criatura objetivo) {
        int dañoEspecial = this.fuerza * 2 + 5;
        System.out.println("¡" + this.nombre + " desata su Habilidad Especial [Tormenta Arcana] sobre " 
                + objetivo.getNombre() + ", causando " + dañoEspecial + " de daño mágico devastador!");
        objetivo.defender(dañoEspecial);
    }

    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }
}
