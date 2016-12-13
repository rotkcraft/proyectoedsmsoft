package org.edsmsoft.controles;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.edsmsoft.objetos.CuadroTextoLis;
import org.edsmsoft.utilidades.Conexion;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-12-16.
 */
public class Clase implements Initializable
{
    public CuadroTextoLis txtClase;
    public Button btnGuardar;
    public Button btnSalir;
    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        conexion=new Conexion();




    }
}
