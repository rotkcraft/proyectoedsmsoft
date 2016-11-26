package org.edsmsoft.utilidades;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.Years;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Creado por hadexexplade el 26/11/15.13:45
 */
public class ConvertidorFechas
{
    public ConvertidorFechas()
    {
    }

    public String fechaConvertir(Date fecha, String formato)
    {
        SimpleDateFormat format = new SimpleDateFormat(formato);

        return format.format(fecha);
    }

    public String horaConvertir(Date fecha, String formato)
    {
        SimpleDateFormat format = new SimpleDateFormat(formato);

        return format.format(fecha);
    }

    public int devolverA(String fecha1, String fecha2, String formato)
    {
        int dias=Integer.MAX_VALUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(fecha1);
            d2 = format.parse(fecha2);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

            dias=Years.yearsBetween(dt1, dt2).getYears();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;

    }


    public int devolverDias(String fecha1, String fecha2, String formato)
    {
        int dias=Integer.MAX_VALUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(fecha1);
            d2 = format.parse(fecha2);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            dias=Days.daysBetween(dt1, dt2).getDays();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;

    }

    public int devolverHoras(String fecha1,String fecha2,String formato)
    {
        int dias=Integer.MAX_VALUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(fecha1);
            d2 = format.parse(fecha2);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            dias=Hours.hoursBetween(dt1, dt2).getHours() % 24;

            System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
            System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;

    }

    public int devolverMinutos(String fecha1,String fecha2,String formato)
    {
        int dias=Integer.MAX_VALUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(fecha1);
            d2 = format.parse(fecha2);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            dias=Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 ;

            System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;

    }

    public int devolverSegundos(String fecha1,String fecha2,String formato)
    {
        int dias=Integer.MAX_VALUE;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(fecha1);
            d2 = format.parse(fecha2);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            dias=Seconds.secondsBetween(dt1, dt2).getSeconds() % 60  ;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;

    }


}
