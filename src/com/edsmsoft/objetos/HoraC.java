package com.edsmsoft.objetos;

import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalTime;
import java.time.format.FormatStyle;

/**
 * Created by rcraft on 08-20-16.
 */
public class HoraC
{
    LocalTime horaInicio;
    LocalTime horaFinal;

    public HoraC(LocalTime horaInicio, LocalTime horaFinal)
    {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public HoraC(LocalTime horaInicio, int minutos)
    {
        this(horaInicio,horaInicio.plusMinutes(minutos));

    }

    public LocalTime getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal()
    {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal)
    {
        this.horaFinal = horaFinal;
    }

    @Override
    public String toString()
    {
       return new LocalTimeStringConverter(FormatStyle.SHORT).toString(horaInicio)+"-"+new LocalTimeStringConverter(FormatStyle.SHORT).toString(horaFinal);
    }
}
