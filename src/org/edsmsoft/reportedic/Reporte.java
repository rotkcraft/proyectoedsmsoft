package org.edsmsoft.reportedic;

import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import org.rcraft.visor.JasperViewerFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 * Created by rcraft on 11-25-16.
 */
public class Reporte
{
    private String url;
    private String usuario;
    private String clave;
    private HashMap<String, Object> param;

    public Reporte()
    {

        this.usuario = "postgres";
        this.clave = "root";
        this.url = "jdbc:postgresql://localhost:5432/edsmsoft";

    }

    public Reporte(String reporte, Stage ventanap, String titulo,boolean jrxml)
    {
        this.usuario = "postgres";
        this.clave = "root";
        this.url = "jdbc:postgresql://localhost:5432/edsmsoft";

        try
        {
//            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conexion = DriverManager.getConnection(url, usuario, clave);

            param = new HashMap<String, Object>();


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo, conexion, reporte, param, jrxml);
            viewer.show();

            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public Reporte(String reporte, Stage ventanap, String titulo, HashMap<String, Object> param,boolean jrxml)
    {
        this();
        this.usuario = "postgres";
        this.clave = "root";
        this.url = "jdbc:postgresql://localhost:5432/edsmsoft";

        try
        {
//            DriverManager.registerDriver(new org.postgresql.Driver());

            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            this.param = param;


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo, conexion, reporte, this.param, jrxml);
            viewer.show();

            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public Reporte(String reporte, Stage ventanap, String titulo, HashMap<String, Object> param, JRDataSource contenido, boolean jrxml)
    {
        this();
        this.usuario = "postgres";
        this.clave = "root";
        this.url = "jdbc:postgresql://localhost:5432/edsmsoft";

        try
        {
//            DriverManager.registerDriver(new org.postgresql.Driver());

//            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            this.param = param;


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo, reporte, this.param,contenido, jrxml);
            viewer.show();

//            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public Reporte(String reporte, Stage ventanap, String titulo, boolean jrxml,HashMap<String, Object> param)
    {
        this();


        try
        {
//            DriverManager.registerDriver(new org.postgresql.Driver());

//            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            this.param = param;


            JasperViewerFX viewer = new JasperViewerFX(ventanap, titulo, reporte, this.param, jrxml);
            viewer.show();

//            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
