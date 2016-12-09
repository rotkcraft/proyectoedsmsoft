package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.edsmsoft.utilidades.Escalar;

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
                try
                {
                    Node raiz = (Node)  event.getSource();
//                    Stage vent=(Stage) raiz.getScene().getWindow();

                    FXMLLoader cargar=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/alumno.fxml"));
                    Node nodo=(Node) cargar.load();

                    //MenuPrincipal menuPrincipal=cargar.<MenuPrincipal>getController();
                    // menuPrincipal.setUsuario(enviar);

                    Parent root = (Pane)nodo;
                    raiz.getScene().setRoot(root);
//                    vent.setTitle("Menu Principal");
//                    Scene scene=new Scene(root,600,400);
//                    adaptar(scene, (Pane) root);
//                    vent.setScene(scene);
//                    vent.setFullScreen(true);
//                    vent.show();

                }catch (Exception ex){ex.printStackTrace();}

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
    private void adaptar(final Scene scene, final Pane contentPane)
    {
        final double ancho = scene.getWidth();
        final double alto = scene.getHeight();
        final double proporcion = ancho / alto;

        Escalar sizeListener = new Escalar(scene, proporcion, alto, ancho, contentPane);
        scene.widthProperty().addListener(sizeListener);
        scene.heightProperty().addListener(sizeListener);
    }

}
