
package com.uniajc.criaturas;

public class Guerrero extends Criatura {

    private String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    // El guerrero ataca utilizando su arma
    @Override
    public void atacar(Criatura objetivo) {

        int daño = this.fuerza;

        System.out.println(this.nombre + " ataca a "
                + objetivo.getNombre() + " con su "
                + this.arma + ", causando " + daño + " puntos de daño.");

        objetivo.defender(daño);
    }

    // El guerrero utiliza su armadura para reducir el daño
    @Override
    public void defender(int daño) {

        int reduccion = 3;
        int dañoEfectivo = Math.max(1, daño - reduccion);

        this.salud = Math.max(0, this.salud - dañoEfectivo);

        System.out.println(this.nombre + " se defiende con su armadura, "
                + "reduciendo " + reduccion + " de daño. Salud restante: "
                + this.salud);
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }
}
