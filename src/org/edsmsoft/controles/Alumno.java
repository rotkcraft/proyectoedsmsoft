package org.edsmsoft.controles;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.edsmsoft.utilidades.Conexion;
import org.edsmsoft.utilidades.Valor;
import org.json.simple.JSONObject;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-09-16.
 */
public class Alumno extends VBox implements Initializable
{
    public JFXTextField txtNombre;
    public JFXTextField txtIdentidad;
    public JFXTextArea txtEnfermedades;
    public JFXTextField txtApellido;
    public JFXComboBox<Valor> cmbGenero;
    public JFXTextField txtEncargado;
    public ImageView fotografia;
    public JFXDatePicker fechaNacimiento;
    public JFXComboBox<Valor> cmbNacionalidad;
    public BotonesPanel botonesPanel;
    Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        conexion=new Conexion();
        conexion.llenarCombo("http://localhost:8080/TraerGen?tipo=nacionalidad",cmbNacionalidad);
        conexion.llenarCombo("http://localhost:8080/TraerGen?tipo=genero",cmbGenero);
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Ingrese Informacion en Campo");
        txtNombre.getValidators().add(validator);
         ;


    }


    public void agregarBotones(BotonesPanel botonesPanel) {
        this.botonesPanel=botonesPanel;
        botonesPanel.setBtnGuardarAccion(event -> {
            System.out.println("Entro aqui");
            JSONObject alumno=new JSONObject();


            alumno.put("alnombre",txtNombre.getText());

           if(txtNombre.getText().isEmpty()){}

            alumno.put("nombre",txtNombre.getText());

            alumno.put("apellido",txtApellido.getText());
            alumno.put("identidad",txtIdentidad.getText());
           alumno.put("nacionalidad",cmbNacionalidad.getSelectionModel().getSelectedItem().getId());
            alumno.put("genero",cmbGenero.getSelectionModel().getSelectedItem().getId());
            alumno.put("fechanac",fechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            conexion.insertar("http://localhost:8080/InsertarAlumno",alumno);

        });

    }
}
