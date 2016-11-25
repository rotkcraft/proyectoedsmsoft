package com.edsmsoft.utilidades;

import javafx.stage.Stage;
import org.rcraft.visor.JasperViewerFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class Reporte
{
    private String url;
    private String usuario ;
    private String clave ;
    private HashMap<String, Object> param;
    public Reporte()
    {
        Archivo archivo = new Archivo("archivo/configuraciondb");
        String[] s = new Encriptar().desencriptar(archivo.traeArchivo()).split(",|;");

        this.usuario = s[1];
        this.clave = s[2];
        this.url = s[0];

    }
    public Reporte(String reporte,Stage ventanap,String titulo)
    {
        this();
        try
        {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);

            param= new HashMap<String, Object>();


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo,conexion, reporte, param,false);
            viewer.show();

            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public Reporte(String reporte,Stage ventanap,String titulo,HashMap<String, Object> param)
    {
        this();

        try
        {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            this.param=param;


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo,conexion, reporte, this.param,false);
            viewer.show();

            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
