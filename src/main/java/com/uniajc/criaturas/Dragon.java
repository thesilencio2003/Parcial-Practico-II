package com.uniajc.criaturas;

import com.uniajc.habilidades.HabilidadEspecial;

public class Dragon extends Criatura implements HabilidadEspecial {

    private String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = this.fuerza * 2;
        System.out.println(this.nombre + " ataca ferozmente a " + objetivo.getNombre() 
                + " con sus garras y fuego, infligiendo " + daño + " puntos de daño base.");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int reduccion = 5;
        int dañoEfectivo = Math.max(1, daño - reduccion);

        this.salud = Math.max(0, this.salud - dañoEfectivo);

        System.out.println(this.nombre + " se defiende con sus '" + this.escamas 
                + "' reduciendo " + reduccion + " de daño. Daño recibido: " + dañoEfectivo 
                + ". Salud restante: " + this.salud);
    }

    @Override
    public void usarHabilidadEspecial(Criatura objetivo) {
        int dañoEspecial = this.fuerza * 3;
        System.out.println("¡" + this.nombre + " desata su Habilidad Especial [Aliento de Fuego Devastador] contra " 
                + objetivo.getNombre() + ", causando " + dañoEspecial + " de daño masivo!");
        objetivo.defender(dañoEspecial);
    }


    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }
}
