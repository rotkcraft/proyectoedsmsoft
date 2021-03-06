package org.edsmsoft.controles;

import application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.edsmsoft.objetos.PermisosUsuarios;
import org.edsmsoft.objetos.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 11-25-16.
 */
public class MenuPrincipal extends AnchorPane implements Initializable
{
    public VBox vbPanel;
    private Usuario usuario;

    public void initialize(URL location, ResourceBundle resources)
    {
        {
            TabTitle opcion = new TabTitle(new MaterialText("Alumno"));
            opcion.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    try
                    {
                        Node raiz = (Node) event.getSource();
                        Stage vent = (Stage) raiz.getScene().getWindow();
                        ActionBar barraMenu = new ActionBar("Inicio");
                        DrawerLayout drawerLayout = new DrawerLayout();
                        Color blanco = Color.WHITE;

                        FXMLLoader cargarM=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/menuprincipal.fxml"));
                        Node nodo=(Node) cargarM.load();
                        drawerLayout.getChildren().add(nodo);

                        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/alumno.fxml"));
                        VBox panel= fxmlLoader.load();
                        Alumno alumno=fxmlLoader.<Alumno>getController();

                        FXMLLoader fxmlBoton=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/botonesPanel.fxml"));
                        HBox bpanel= fxmlBoton.load();
                        BotonesPanel botonesPanel=fxmlBoton.<BotonesPanel>getController();
                        panel.getChildren().add(bpanel);


//                        FXMLLoader botones=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/alumno.fxml"));
//                        Pane botonesPanel= (Pane) botones.load();
                         alumno.agregarBotones(botonesPanel);


                        barraMenu.addTab(new TabTitle(new MaterialText("Alumno", blanco)),panel);



                        MaterialRootLayout root = new MaterialRootLayout(barraMenu, drawerLayout);
                        vent.setScene(new Scene(root,600,500));
                        vent.setFullScreen(true);

                    }catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            });
            opcion.setPrefSize(240, 50);
            opcion.setPadding(new Insets(20));
            opcion.setTextFill(Color.WHITE);
            opcion.setAlignment(Pos.CENTER_LEFT);
            vbPanel.getChildren().add(opcion);
        }

        {
            TabTitle opcion = new TabTitle(new MaterialText("Catedratico"));
            opcion.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    try
                    {
                        Node raiz = (Node) event.getSource();
                        Stage vent = (Stage) raiz.getScene().getWindow();
                        ActionBar barraMenu = new ActionBar("Inicio");
                        DrawerLayout drawerLayout = new DrawerLayout();
                        Color blanco = Color.WHITE;


                        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/Maestro.fxml"));
                        Pane panel= (Pane) fxmlLoader.load();
                        Maestro maestro=fxmlLoader.<Maestro>getController();


                        FXMLLoader fxmlBoton=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/botonesPanel.fxml"));
                        HBox bpanel= fxmlBoton.load();
                        BotonesPanel botonesPanel=fxmlBoton.<BotonesPanel>getController();
                        maestro.agregarBotones(botonesPanel);


                        panel.getChildren().add(bpanel);

                        barraMenu.addTab(new TabTitle(new MaterialText("Empleado", blanco)), panel);


                        FXMLLoader cargarM=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/menuprincipal.fxml"));
                        Node nodo=(Node) cargarM.load();
                        drawerLayout.getChildren().add(nodo);


                        MaterialRootLayout root = new MaterialRootLayout(barraMenu, drawerLayout);
                        vent.setScene(new Scene(root, 600, 650));
                        vent.setFullScreen(true);
                    }catch (Exception ex)
                    {
                         ex.printStackTrace();
                    }
                }
            });
            opcion.setPrefSize(240, 50);
            opcion.setPadding(new Insets(20));
            opcion.setTextFill(Color.WHITE);
            opcion.setAlignment(Pos.CENTER_LEFT);
            vbPanel.getChildren().add(opcion);
        }
        {
            TabTitle opcion = new TabTitle(new MaterialText("Academico"));
            opcion.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    try
                    {
                        Node raiz = (Node) event.getSource();
                        Stage vent = (Stage) raiz.getScene().getWindow();
                        vent.setTitle("Academico");

                        ActionBar barraMenu = new ActionBar("Inicio");
                        DrawerLayout drawerLayout = new DrawerLayout();
                        Color blanco = Color.WHITE;


                        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/asignarclase.fxml"));
                        Pane panel= (Pane) fxmlLoader.load();
                        barraMenu.addTab(new TabTitle(new MaterialText("Carga Academica", blanco)), panel);

                        FXMLLoader fxmlLoaderD=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/curso.fxml"));
                        Pane panelD= (Pane) fxmlLoaderD.load();
                        barraMenu.addTab(new TabTitle(new MaterialText("Curso", blanco)), panelD);

                        FXMLLoader fxmlLoaderT=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/clase.fxml"));
                        Pane panelT= (Pane) fxmlLoaderT.load();
                        barraMenu.addTab(new TabTitle(new MaterialText("Clase", blanco)), panelT);

                        FXMLLoader fxmlLoaderJ=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/jornada.fxml"));
                        Pane panelJ= (Pane) fxmlLoaderJ.load();
                        barraMenu.addTab(new TabTitle(new MaterialText("Jornada", blanco)), panelJ);

                        FXMLLoader fxmlLoaderAx=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/anualidad.fxml"));
                        Pane panelAx= (Pane) fxmlLoaderAx.load();
                        barraMenu.addTab(new TabTitle(new MaterialText("Anualidad", blanco)), panelAx);





                        FXMLLoader cargarM=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/menuprincipal.fxml"));
                        Node nodo=(Node) cargarM.load();
                        drawerLayout.getChildren().add(nodo);


                        MaterialRootLayout root = new MaterialRootLayout(barraMenu, drawerLayout);
                        vent.setScene(new Scene(root, 600, 650));

                        vent.setFullScreen(true);
                    }catch (Exception ex)
                    {
                        ex.printStackTrace();


                    }
                }
            });
            opcion.setPrefSize(240, 50);
            opcion.setPadding(new Insets(20));
            opcion.setTextFill(Color.WHITE);
            opcion.setAlignment(Pos.CENTER_LEFT);
            vbPanel.getChildren().add(opcion);
        }


//        {
//            TabTitle opcion = new TabTitle(new MaterialText("Encargado"));
//            opcion.setOnAction(new EventHandler<ActionEvent>()
//            {
//                public void handle(ActionEvent event)
//                {
//                    try
//                    {
//                        Node raiz = (Node) event.getSource();
//                        Stage vent = (Stage) raiz.getScene().getWindow();
//                        vent.setTitle("Autor");
//
//                        ActionBar barraMenu = new ActionBar("Inicio");
//                        DrawerLayout drawerLayout = new DrawerLayout();
//                        Color blanco = Color.WHITE;
//
//                        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/Encargado.fxml"));
//                        Pane panel= (Pane) fxmlLoader.load();
//                        barraMenu.addTab(new TabTitle(new MaterialText("Agregar Autor", blanco)), panel);
//
//
//                        FXMLLoader cargarM=new FXMLLoader(getClass().getResource("/org/edsmsoft/lienzos/menuprincipal.fxml"));
//                        Node nodo=(Node) cargarM.load();
//                        MenuPrincipal menuPrincipal=cargarM.<MenuPrincipal>getController();
//                        menuPrincipal.setUsuario(usuario);
//                        drawerLayout.getChildren().add(nodo);
//
//                        MaterialRootLayout root = new MaterialRootLayout(barraMenu, drawerLayout);
//                        vent.setScene(new Scene(root, 600, 650));
//
//                        vent.setFullScreen(true);
//                    }catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//
//                    }
//                }
//            });
//            opcion.setPrefSize(240, 50);
//            opcion.setPadding(new Insets(20));
//            opcion.setTextFill(Color.WHITE);
//            opcion.setAlignment(Pos.CENTER_LEFT);
//            vbPanel.getChildren().add(opcion);
//        }



        {
            TabTitle opcion = new TabTitle(new MaterialText("Salir"));
            opcion.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {


                }
            });
            opcion.setPrefSize(240, 50);
            opcion.setPadding(new Insets(20));
            opcion.setTextFill(Color.WHITE);
            opcion.setAlignment(Pos.CENTER_LEFT);
            vbPanel.getChildren().add(opcion);
        }



    }

    public boolean verificarPanel(String modulo)
    {
        for(int i=0;i<vbPanel.getChildren().size();i++)
        {
            if(vbPanel.getChildren().get(i) instanceof TabTitle && ((MaterialText)((TabTitle) vbPanel.getChildren().get(i)).getGraphic()).getText().equalsIgnoreCase(modulo) )
            {
                return true;
            }
        }
        return false;
    }

    public TabTitle traerTab(String modulo)
    {
        for(int i=0;i<vbPanel.getChildren().size();i++)
        {
            if(vbPanel.getChildren().get(i) instanceof TabTitle && ((MaterialText)((TabTitle) vbPanel.getChildren().get(i)).getGraphic()).getText().equalsIgnoreCase(modulo) )
            {
                return  ((TabTitle) vbPanel.getChildren().get(i));
            }
        }
        return null;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
        for (PermisosUsuarios permisos :
                usuario.getPermisosUsuarioses() )
        {
            System.out.println(permisos.getModulo()+"\t"+permisos.getNivel()+"\t"+permisos.getModulo().equalsIgnoreCase("usuario")+"\t"+verificarPanel(permisos.getModulo())+"\t"+ permisos.isEstado());
            if(permisos.getModulo().equalsIgnoreCase("alumno") && verificarPanel(permisos.getModulo()) && !permisos.isEstado())
            {

                traerTab("alumno").setDisable(true);

            }
            if(permisos.getModulo().equalsIgnoreCase("encargado") && verificarPanel(permisos.getModulo()) && !permisos.isEstado())
            {

                traerTab("encargado").setDisable(true);

            }
            if(permisos.getModulo().equalsIgnoreCase("academico") && verificarPanel(permisos.getModulo()) && !permisos.isEstado())
            {

                traerTab("academico").setDisable(true);

            }


        }
    }
}


