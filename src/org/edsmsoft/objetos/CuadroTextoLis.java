package org.edsmsoft.objetos;


import org.edsmsoft.utilidades.EnviarInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by rcraft on 11-25-16.
 */

public class CuadroTextoLis extends TextField
{
  /** The existing autocomplete contenido. */
  private final SortedSet<String> contenido;
  /** The popup used to select an entry. */
  private ContextMenu mostrarEntradas;
  private EnviarInfo enviarInfo;
  private String texto;

  /** Construct a new CuadroTextoLis. */
  public CuadroTextoLis() {
    super();
    contenido = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    mostrarEntradas = new ContextMenu();
    textProperty().addListener(new ChangeListener<String>()
    {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
      {
        if (getText().length() == 0)
        {
          mostrarEntradas.hide();
        } else
        {
          LinkedList<String> busqueda = new LinkedList<String>();
          busqueda.addAll(contenido.subSet(getText(), getText() + Character.MAX_VALUE));
          if (contenido.size() > 0)
          {
            llenarMenu(busqueda);
            if (!mostrarEntradas.isShowing())
            {
              mostrarEntradas.show(CuadroTextoLis.this, Side.BOTTOM, 0, 0);
            }
          } else
          {
            mostrarEntradas.hide();
          }
        }

      }
    });

    focusedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean aBoolean2) {
        mostrarEntradas.hide();
      }
    });

  }

  /**
   * se asigna el enviarInfo , el texto
   * @param enviarInfo
   * @param texto
   */
  public void setEnviarInfo(EnviarInfo enviarInfo,String texto)
  {
    this.enviarInfo=enviarInfo;
    this.texto=texto;
  }

  /**
   * Obtenemos el contenido del autocompletar.
   * @return El contenido existente.
   */
  public SortedSet<String> getContenido() { return contenido; }

  /**
   *Llenar el menu con los resultados y mostrarlos
   * @param busqueda son los string que coinciden.
   */
  private void llenarMenu(List<String> busqueda) {
    List<CustomMenuItem> menuItems = new LinkedList<>();

    int maximo = 10;
    int count = Math.min(busqueda.size(), maximo);
    for (int i = 0; i < count; i++)
    {
      final String result = busqueda.get(i);
      Label entryLabel = new Label(result);
      CustomMenuItem item = new CustomMenuItem(entryLabel, true);
      item.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent actionEvent) {
          setText(result);
          if(enviarInfo!=null)
          {
            ObservableList vec= FXCollections.observableArrayList();
            vec.add(result.split(",")[1]);
            vec.add(result.split(",")[0]);
            enviarInfo.enviarDatos(vec,texto);

          }
          mostrarEntradas.hide();
        }
      });
      menuItems.add(item);
    }
    mostrarEntradas.getItems().clear();
    mostrarEntradas.getItems().addAll(menuItems);

  }
}