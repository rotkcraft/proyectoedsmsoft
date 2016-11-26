package org.edsmsoft.controles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.edsmsoft.utilidades.Escalar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 11-25-16.
 */
public class Login implements Initializable
{

    public JFXTextField txtUsuario;
    public JFXPasswordField txtClave;
    public VBox contenedor;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnEntrar;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnEntrar.setMaxWidth(Double.MAX_VALUE);
        btnSalir.setMaxWidth(Double.MAX_VALUE);
        btnEntrar.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    Node raiz = (Node) event.getSource();
                    Stage vent = (Stage) raiz.getScene().getWindow();

                    FXMLLoader cargar = new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/menuprincipal.fxml"));
                    Node nodo = (Node) cargar.load();

                    MenuPrincipal menuPrincipal = cargar.<MenuPrincipal>getController();
                    // menuPrincipal.setUsuario(id);

                    Parent root = (Pane) nodo;
                    vent.setTitle("Menu Principal");
                    Scene scene = new Scene(root, 600, 400);
//                    scene.getStylesheets().add(getClass().getResource("/org/edsmsoft/estilos/estilos.css").toExternalForm());
                    scene.getStylesheets().add(getClass().getResource("/org/edsmsoft/estilos/estilos.css").toString());
                    adaptar(scene, (Pane) root);

                    vent.setScene(scene);
                    vent.setResizable(false);
//                    vent.setFullScreen(true);
                    vent.show();

                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        });
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
