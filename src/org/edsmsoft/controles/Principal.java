package org.edsmsoft.controles;
/**
 * Created by rcraft on 11-25-16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.edsmsoft.utilidades.Archivo;

import java.io.IOException;

public class Principal extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Archivo archivo=new Archivo("archivo/configuraciondb");
        Parent root =null;
        if(archivo.contarRegistros()==0)
        {
            root = FXMLLoader.load(getClass().getResource("/org/edsmsoft/lienzos/configuracioninicial.fxml"));
            primaryStage.setTitle("Configuracion Inicial");
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("/org/edsmsoft/lienzos/login.fxml"));
            primaryStage.setTitle("Login");
        }

        Scene scene = new Scene(root);



        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
