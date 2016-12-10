package org.edsmsoft.utilidades;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by rcraft on 12-09-16.
 */
public class Transferencia
{
    public JSONObject traerInfo(String dir)
    {
        JSONObject objeto = null;
        try
        {
            URL url=new URL(dir);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            InputStream inputStream=connection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String linea="";
            StringBuilder respuesta=new StringBuilder();

            while ((linea=bufferedReader.readLine())!=null){
                respuesta.append(linea+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
            String sDatos=respuesta.toString();
            System.out.println("Termino Conexion");

            JSONParser jsonParser=new JSONParser();
            try
            {

                JSONObject jsonObject= (JSONObject) jsonParser.parse(sDatos);
                objeto=jsonObject;

            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }


        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return objeto;
    }


    public void enviarInfo(String dir,JSONObject object)
    {
        try
        {
            URL url=new URL(dir);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);


            OutputStream outputStream=connection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            String sinfo=URLEncoder.encode("info","UTF-8")+" = "+ URLEncoder.encode(object.toString(), "UTF-8");
            bufferedWriter.write(sinfo);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=connection.getInputStream();

             BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String linea="";
            StringBuilder respuesta=new StringBuilder();

            while ((linea=bufferedReader.readLine())!=null){
                respuesta.append(linea+"\n");
            }
            bufferedReader.close();
            System.out.println(respuesta.toString());

            inputStream.close();
            connection.disconnect();

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
