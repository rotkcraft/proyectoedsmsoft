package com.edsmsoft.utilidades;

/**
 * Created by rcraft on 03-25-16.
 */
public enum Dias
{
    LUNES("Lunes"),MARTES("Martes"),MIERCOLES("Miercoles"),JUEVES("Jueves"),VIERNES("Viernes"),SABADO("Sabado"),DOMINGO("Domingo");
    private String dia;

    private Dias(String dia)
    {
         this.dia=dia;
    }

    @Override
    public String toString()
    {
        return this.dia;
    }
}
