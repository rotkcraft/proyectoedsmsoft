package org.edsmsoft.reportedic;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import org.edsmsoft.utilidades.Archivo;
import org.edsmsoft.utilidades.Encriptar;
import org.edsmsoft.utilidades.Transferencia;
import org.json.simple.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Entramos");
//        try{

            //create a temp file
//            File temp = File.createTempFile("alumno", ".json");
        Archivo archivo=new Archivo("archivo/configuraciondb");
        JSONObject objeto=new Transferencia().traerInfo(new Encriptar().desencriptar(archivo.traeArchivo())+"/TraerAlumno");
            System.out.println(objeto.toJSONString());
            InputStream stream = new ByteArrayInputStream(objeto.toString().getBytes(StandardCharsets.UTF_8));
            HashMap params=new HashMap();
        params.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, stream);


//            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
//            bw.write(objeto.toString());
//            bw.close();

//            JRDataSource jsonDataSource=new JsonDataSource(temp);
//
//
//            JasperDesign jasperDesign = JRXmlLoader
//                    .load(getClass().getResourceAsStream("/rcraft/reportedic/reporte/report.jrxml"));
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            Map parameters = new HashMap();
//            parameters.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM,new FileInputStream(temp) );
//            JasperPrint jasperPrint;
//
//             jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
//
//             JasperViewer.viewReport(jasperPrint);

            new Reporte("reporte/report.jrxml",primaryStage,"Reporte Alumnos",true,params);




//        }catch(IOException e){
//
//            e.printStackTrace();
//
//        }

     }


    public static void main(String[] args) {


        launch(args);
    }
}
