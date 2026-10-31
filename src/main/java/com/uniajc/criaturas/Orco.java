
package com.uniajc.criaturas;

public class Orco extends Criatura {

    private String tipoArma;

    public Orco(String nombre, int salud, int fuerza, String tipoArma) {
        super(nombre, salud, fuerza);
        this.tipoArma = tipoArma;
    }

    // El orco ataca utilizando su fuerza bruta
    @Override
    public void atacar(Criatura objetivo) {

        int daño = this.fuerza + 3;

        System.out.println(this.nombre + " ataca a "
                + objetivo.getNombre() + " utilizando su "
                + this.tipoArma + ", causando " + daño + " puntos de daño.");

        objetivo.defender(daño);
    }

    // El orco resiste parte del daño recibido
    @Override
    public void defender(int daño) {

        int reduccion = 2;
        int dañoEfectivo = Math.max(1, daño - reduccion);

        this.salud = Math.max(0, this.salud - dañoEfectivo);

        System.out.println(this.nombre + " resiste el ataque, "
                + "reduciendo " + reduccion + " de daño. Salud restante: "
                + this.salud);
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }
}
