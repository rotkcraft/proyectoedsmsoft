package org.edsmsoft.controles;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rcraft on 12-09-16.
 */
public class Alumno implements Initializable
{
    public JFXTextField txtNombre;
    public JFXTextField txtIdentidad;
    public JFXTextField txtNacionalidad;
    public JFXTextArea txtEnfermedades;
    public JFXTextField txtApellido;
    public JFXComboBox cmbGenero;
    public JFXTextField txtEncargado;
    public ImageView fotografia;
    public JFXDatePicker fechaNacimiento;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
