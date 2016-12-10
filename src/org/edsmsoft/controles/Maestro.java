package org.edsmsoft.controles;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.edsmsoft.utilidades.Conexion;
import org.edsmsoft.utilidades.Valor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-09-16.
 */
public class Maestro extends VBox implements Initializable
{


    public JFXTextField txtNombre;
    public JFXTextField txtIdentidad;
    public JFXTextArea txtEnfermedades;
    public JFXTextField txtApellido;
    public JFXTextField txtCorreo;
    public JFXTextField txtTelefono;
    public JFXTextField txtAnosExperiencia;
    public JFXTextField txtDirecion;
    public JFXComboBox<Valor> cmbEstadoCivil;
    public JFXComboBox<Valor> cmbGenero;
    public JFXComboBox<Valor> cmbNacionalidad;
    public ImageView fotografia;
    public JFXDatePicker fechaNacimiento;
    public BotonesPanel botonesPanel;
    Conexion conexion;




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        conexion=new Conexion();
        conexion.llenarCombo("http://localhost:8080/TraerGen?tipo=nacionalidad",cmbNacionalidad);
        conexion.llenarCombo("http://localhost:8080/TraerGen?tipo=genero",cmbGenero);
        conexion.llenarCombo("http://localhost:8080/TraerGen?tipo=estadocivil",cmbEstadoCivil);

    }

    public void agregarBotones(BotonesPanel botonesPanel) {
        this.botonesPanel=botonesPanel;
    }
}
