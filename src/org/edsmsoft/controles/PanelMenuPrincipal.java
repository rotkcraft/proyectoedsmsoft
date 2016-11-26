package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 11-25-16.
 */
public class PanelMenuPrincipal implements Initializable
{

    public VBox vbPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        JFXButton alumnos = new JFXButton();
        alumnos.setText("Alumnos");

        JFXButton maestros = new JFXButton();
        maestros.setText("Alumnos");

        JFXButton matricula = new JFXButton();
        matricula.setText("Alumnos");

        JFXButton academico = new JFXButton();
        academico.setText("Alumnos");


    }
}
