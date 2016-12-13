package org.edsmsoft.controles;

import javafx.fxml.Initializable;
import org.edsmsoft.objetos.CuadroTextoLis;
import org.edsmsoft.utilidades.Archivo;
import org.edsmsoft.utilidades.Conexion;
import org.edsmsoft.utilidades.Encriptar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alexander on 13/12/2016.
 */
public class AsignarClase implements Initializable
{
    public CuadroTextoLis txtCatedratico;
    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Archivo archivo=new Archivo("archivo/configuraciondb");
        conexion=new Conexion();
        txtCatedratico.getContenido().addAll(conexion.traerLista(new Encriptar().desencriptar(archivo.traeArchivo())+"/TraerMaestro","maestro"));
    }
}
