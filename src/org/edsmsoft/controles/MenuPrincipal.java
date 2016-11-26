package org.edsmsoft.controles;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 11-25-16.
 */
public class MenuPrincipal extends AnchorPane implements Initializable
{
    public JFXHamburger btnMenuPrincipal;
    public JFXDrawer menuDraw;
    public AnchorPane contenedorMPrincipal;
    private Pane panelMenuParent;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
             panelMenuParent = FXMLLoader.load(getClass().getResource("/org/edsmsoft/lienzos/panelmenuprincipal.fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        ;
        menuDraw.setDirection(JFXDrawer.DrawerDirection.LEFT);
        menuDraw.setOverLayVisible(false);
        menuDraw.setSidePane(panelMenuParent);
        menuDraw.setId("MenuDraw");
        HamburgerBackArrowBasicTransition flecha=new HamburgerBackArrowBasicTransition(btnMenuPrincipal);
        flecha.setRate(-1);

        btnMenuPrincipal.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                flecha.setRate(flecha.getRate()*-1);
                flecha.play();
                if(menuDraw.isHidden())
                {
                     menuDraw.open();
                }
                else {
                        menuDraw.close();
                    }

            }
        });
    }
}
