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
//                JSONArray jsonArray= (JSONArray) jsonObject.get("clientes");
////               if(getListAdapter()==null || getListAdapter().getCount()<jsonArray.length())
////               {
//
//                System.out.println(jsonObject.toString());
//                System.out.println(jsonArray.toString());
//
//                Iterator<JSONObject> it=jsonArray.iterator();
//                if(jsonArray.size()<clienteMovils.getCantidad())
//                {
//                    for(String idCliente:clienteMovils.llaves())
//                    {
//                        map.removeMarker(busMovils.obtenerValor(idCliente).getMarcador());
//                        busMovils.eliminarEntrada(idCliente);
//                    }
//                }
//                int i=0;
//                while (it.hasNext()){
//                    i++;
//                    JSONObject ruta= it.next();
//
//
//                    ClienteMovil cliente = new ClienteMovil(String.valueOf(ruta.get("idbitacoracliente")),String.valueOf(ruta.get("mac")) , String.valueOf(ruta.get("tiempo")), Double.parseDouble(String.valueOf(ruta.get("lat"))), Double.parseDouble(String.valueOf(ruta.get("lon"))));
//
//                    if(clienteMovils.obtenerValor(cliente.getMac())!=null)
//                    {
//                        clienteMovils.obtenerValor(cliente.getMac()).getMarcador().setTitle("Cliente N" + (i + 1));
//                        ;
//                        clienteMovils.obtenerValor(cliente.getMac()).getMarcador().setPosition(new LatLong(cliente.getLat(),cliente.getLon()));
//
//                    }
//                    else {
//                        clienteMovils.insertarEntrada(cliente.getMac(),cliente);
//                        MarkerOptions marcadorOpciones=new MarkerOptions();
////                        marcadorOpciones.icon(getClass().getResource("../imagenes/bus.png").toString());
//                        String titu="Cliente N" + (i );
//                        marcadorOpciones.position(new LatLong(clienteMovils.obtenerValor(cliente.getMac()).getLat(), clienteMovils.obtenerValor(cliente.getMac()).getLon())).title(titu);
//                        System.out.println("LLegamos ha crearlo aqui");
//
//                        clienteMovils.obtenerValor(cliente.getMac()).setMarcador(new Marker(marcadorOpciones));
//                        map.addMarker(clienteMovils.obtenerValor(cliente.getMac()).getMarcador());
//                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
//                        infoWindowOptions.content("<h2>"+titu+"</h2>"
//                                + "Ubicacion Actual<br>" );
//
//                        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
//                        fredWilkeInfoWindow.open(map, cliente.getMarcador());
//
//
//                    }
//                }



//               }
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
            connection.setRequestProperty("Content-Type","application/json");

            OutputStream outputStream=connection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
//                String info= URLEncoder.encode("trayendo","UTF-8")+" = "+params[1]+"&"+URLEncoder.encode("velocidad","UTF-8")+" = "+params[2];
            String info= URLEncoder.encode(object.toString(), "UTF-8");
            bufferedWriter.write(info);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=connection.getInputStream();
            inputStream.close();
            connection.disconnect();
//            return "Insertado Correctamente";

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
