package org.edsmsoft.controles;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.edsmsoft.utilidades.Archivo;
import org.edsmsoft.utilidades.Conexion;
import org.edsmsoft.utilidades.Encriptar;
import org.edsmsoft.utilidades.Valor;
import org.json.simple.JSONObject;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-09-16.
 */
public class Maestro extends VBox implements Initializable
{


    public JFXTextField txtNombre;
    public JFXTextField txtIdentidad;
    public JFXTextField txtApellido;
    public JFXTextField txtCorreo;
    public JFXTextField txtTelefono;
    public JFXTextField txtDirecion;
    public JFXComboBox<Valor> cmbEstadoCivil;
    public JFXComboBox<Valor> cmbGenero;
    public JFXComboBox<Valor> cmbNacionalidad;
    public ImageView fotografia;
    public JFXDatePicker fechaNacimiento;
    public BotonesPanel botonesPanel;
    public JFXDatePicker fechaEperiencia;
    Conexion conexion;




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Archivo archivo=new Archivo("archivo/configuraciondb");
        conexion=new Conexion();
        conexion.llenarCombo(new Encriptar().desencriptar(archivo.traeArchivo())+"/TraerGen?tipo=nacionalidad",cmbNacionalidad);
        conexion.llenarCombo(new Encriptar().desencriptar(archivo.traeArchivo())+"/TraerGen?tipo=genero",cmbGenero);
        conexion.llenarCombo(new Encriptar().desencriptar(archivo.traeArchivo())+"/TraerGen?tipo=estadocivil",cmbEstadoCivil);


    }

    public void agregarBotones(BotonesPanel botonesPanel) {


        this.botonesPanel=botonesPanel;

        botonesPanel.setBtnGuardarAccion(event -> {

            JSONObject maestro=new JSONObject();

                if(txtNombre.getText().isEmpty()){}

            maestro.put("nombre", txtNombre.getText());
            maestro.put("identidad",txtIdentidad.getText());
            maestro.put("apellido",txtApellido.getText());
            maestro.put("correo",txtCorreo.getText());
            maestro.put("telefono",txtTelefono.getText());
            maestro.put("direcion",txtDirecion.getText());
            maestro.put("estado",cmbEstadoCivil.getSelectionModel().getSelectedItem().getId());
            maestro.put("genero",cmbGenero.getSelectionModel().getSelectedItem().getId());
            maestro.put("nacionalidad",cmbNacionalidad.getSelectionModel().getSelectedItem().getId());
            maestro.put("fechanac",fechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            maestro.put("fechadeinicioexp",fechaEperiencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));


            conexion.insertar("http://localhost:8080/InsertarMaestro",maestro);

        });





    }
}
