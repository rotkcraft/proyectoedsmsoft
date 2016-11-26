package org.edsmsoft.controles;
/**
 * Created by rcraft on 11-25-16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        Parent root  = FXMLLoader.load(getClass().getResource("/org/edsmsoft/lienzos/login.fxml"));

        Scene scene=new Scene(root);
        primaryStage.setTitle("Login");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
