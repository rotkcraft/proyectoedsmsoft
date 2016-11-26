package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        alumnos.setMaxWidth(Double.MAX_VALUE);
        alumnos.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });

        vbPanel.getChildren().add(alumnos);

        JFXButton maestros = new JFXButton();
        maestros.setText("Maestros");
        maestros.setMaxWidth(Double.MAX_VALUE);
        maestros.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });

        vbPanel.getChildren().add(maestros);

        JFXButton matricula = new JFXButton();
        matricula.setText("Matricula");
        matricula.setMaxWidth(Double.MAX_VALUE);

        vbPanel.getChildren().add(matricula);

        JFXButton academico = new JFXButton();
        academico.setText("Academico");
        academico.setMaxWidth(Double.MAX_VALUE);

        vbPanel.getChildren().add(academico);





    }
}
