package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import org.edsmsoft.utilidades.Archivo;
import org.edsmsoft.utilidades.Encriptar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-12-16.
 */
public class ConfiguracionInicial implements Initializable
{
    public JFXTextField txtDireccion;
    public JFXButton btnContinuar;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnContinuar.setOnAction(event -> {
            Archivo archivo=new Archivo("archivo/configuraciondb");
            archivo.limpiarArchivo();
            archivo.guardar(new Encriptar().encriptar(txtDireccion.getText()));
        });
    }
}
