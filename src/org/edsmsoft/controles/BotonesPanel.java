package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alexander on 09/12/2016.
 */
public class BotonesPanel extends HBox implements Initializable{
    public JFXButton btnGuardar;
    public JFXButton btnModificar;
    public JFXButton btnBuscar;
    public JFXButton btnEliminar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnGuardar.setMaxWidth(Double.MAX_VALUE);
        btnModificar.setMaxWidth(Double.MAX_VALUE);
        btnBuscar.setMaxWidth(Double.MAX_VALUE);
        btnEliminar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnBuscar, Priority.ALWAYS);

        HBox.setHgrow(btnEliminar, Priority.ALWAYS);
        HBox.setHgrow(btnModificar, Priority.ALWAYS);
        HBox.setHgrow(btnGuardar, Priority.ALWAYS);


    }
    public void setBtnGuardarAccion(EventHandler<ActionEvent> accion)
    {
        btnGuardar.setOnAction(accion);
    }
    public void setBtnBuscarAccion(EventHandler<ActionEvent> accion)
    {
        btnGuardar.setOnAction(accion);
    }
}
