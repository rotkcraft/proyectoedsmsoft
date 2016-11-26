package org.edsmsoft.utilidades;

import org.edsmsoft.estructuras.ListaDoble;
import org.edsmsoft.objetos.PermisosUsuarios;
import org.edsmsoft.objetos.Usuario;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;



/**
 * Created by rcraft on 11-25-16.
 */
public class Conexion
{
    private String url;
    private String usuario;
    private String clave;

    public Conexion()
    {
     //   Archivo archivo = new Archivo("archivo/configuraciondb");
      //  String[] s = new Encriptar().desencriptar(archivo.traeArchivo()).split(",|;");
        
        this.usuario = "root";
        this.clave = "root";
        this.url ="jdbc:mysql://192.168.0.164:3306/bdhorarios";
    }

    public Conexion(String url, String usuario, String clave)
    {
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }
/*
    public static void main(String args[])
    {

        String usuario = "root";
        String pass = "";
        String conn = "jdbc:mysql://localhost:3306/bdhorarios";
        Archivo archivo=new Archivo("archivo/configuraciondb");
        archivo.limpiarArchivo();
        archivo.guardar(new Encriptar().encriptar(conn+","+usuario+","+pass+";"));
//        Conexion conexion = new Conexion();
//        Conexion bd = new Conexion(conn, usuario, pass);
//  }*/
    
    public int cantidadFilas(String sql)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int retonar=0;
        try
        {

             conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next())
            {
            	retonar++;
            }
            
            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return retonar;
    }

    public boolean isNotExists(String sql)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int c=0;
        Encriptar encriptar=new Encriptar();

        try
        {

            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
               c++;
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return c>0?false:true;
    }
    
    public boolean siExiste(String sql,String a,String b ,Valor dato)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ListaDoble<Valor> listaD=new ListaDoble<Valor>();
        Encriptar encriptar=new Encriptar();

        try
        {

            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
                listaD.insFinal(new Valor(encriptar.desencriptar(rs.getString(a)),encriptar.desencriptar(rs.getString(b))));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=1;i<=listaD.getCantidad();i++)
        {
        	if(listaD.ret_Elemento(i).getId().compareToIgnoreCase(dato.getId())==0)
        	{
        		return true;
        	}
        }
        return false;
    }

    
  
    
    public boolean existeDato(String sql,String a,String b ,Valor dato)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ListaDoble<Valor> listaD=new ListaDoble<Valor>();
        Encriptar encriptar=new Encriptar();

        try
        {

           Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
                listaD.insFinal(new Valor(encriptar.desencriptar(rs.getString(a)),encriptar.desencriptar(rs.getString(b))));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=1;i<=listaD.getCantidad();i++)
        {
        	if(listaD.ret_Elemento(i).getId().compareToIgnoreCase(dato.getId())==0 && listaD.ret_Elemento(i).getValor().compareToIgnoreCase(dato.getValor())==0 )
        	{
        		return true;
        	}
        }
        return false;
    }

    public int insertar(String sql)
    {
        int llave = -1;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            while (rs.next())
            {
                llave = rs.getInt(1);
            }
            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return llave;
    }



    public ObservableList<PermisosUsuarios> traerPermisosUsu(String sql)
    {
        ObservableList<PermisosUsuarios> permisoUsuarios= FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
                permisoUsuarios.add(new PermisosUsuarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBoolean(4)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return permisoUsuarios;
    }
    public LinkedList<String> traerLista(String sql)
    {
        LinkedList<String> permisoUsuarios= new LinkedList<String>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
                permisoUsuarios.add((rs.getString(2)+","+rs.getString(1)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return permisoUsuarios;
    }



//    public ObservableList<DatosPermisoUsuario> traerPermisos(String sql)
//    {
//        ObservableList<DatosPermisoUsuario> permisoUsuarios= FXCollections.observableArrayList();
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        try
//        {
//            conn = DriverManager.getConnection(url, usuario, clave);
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//
//
//            while (rs.next())
//            {
//                permisoUsuarios.add(new DatosPermisoUsuario(rs.getString(1),rs.getString(2),rs.getString(3)));
//            }
//
//            rs.close();
//            st.close();
//            conn.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return permisoUsuarios;
//    }


    public int aumentarId(String sql,String a,String b,Valor dato)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ListaDoble<Valor> listaD=new ListaDoble<Valor>();
        Encriptar encriptar=new Encriptar();

        try
        {

          //  Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next())
            {
                listaD.insFinal(new Valor(encriptar.desencriptar(rs.getString(a)),encriptar.desencriptar(rs.getString(b))));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        for(int i=1;i<=listaD.getCantidad();i++)
        {
        	if(listaD.ret_Elemento(i).getId().compareToIgnoreCase(dato.getId())==0 && listaD.ret_Elemento(i).getValor().compareToIgnoreCase(dato.getValor())==0 )
        	{
        		return i;
        	}
        }
        return 0;
    }

    
    public void llenarModeloLista(String sql, String id, String campo, DefaultListModel<Valor> cm)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
       cm.removeAllElements();
        try
        {

        //    Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next())
            {
                cm.addElement(new Valor(rs.getString(id), rs.getString(campo)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public void llenarmodelComboCampos(String sql, DefaultComboBoxModel<Valor> cm)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData rd=null;
        cm.removeAllElements();
        try
        {
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            rd=rs.getMetaData();

             for(int i=1;i<=rd.getColumnCount();i++)
             {
            	 cm.addElement(new Valor(rd.getColumnName(i),rd.getColumnLabel(i)));
             }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    

    public void llenarmodelCombo(String sql, String id, String campo, DefaultComboBoxModel<Valor> cm)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        cm.removeAllElements();
        try
        {
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next())
            {
                cm.addElement(new Valor(rs.getString(id), rs.getString(campo)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int ingresarArchivo(String sql, String rutaArchivo)
    {
        InputStream entrada = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs;
        int ingresados = 0;
        try
        {

            File archivo;

            conexion = DriverManager.getConnection(url, usuario, clave);
            conexion.setAutoCommit(false);


            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            archivo = new File(rutaArchivo);

            entrada = new FileInputStream(archivo);
            ps.setBinaryStream(1, entrada, (int) archivo.length());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next())
            {
                ingresados = rs.getInt(1);
            }
            conexion.commit();
            entrada.close();
            ps.close();
            conexion.close();
        }
        catch (SQLException ignored)
        {
            ignored.printStackTrace();

        }
        catch (IOException ignored)
        {
            ignored.printStackTrace();

        }
        return ingresados;
    }

    public void ajustarAnchoTabla(JTable tabla)
    {
        final TableColumnModel modelo = tabla.getColumnModel();
        int ancho;
        for (int columna = 0; columna < tabla.getColumnCount(); columna++)
        {
            TableCellRenderer renderizar = modelo.getColumn(columna).getHeaderRenderer();
            if (renderizar == null)
            {
                renderizar = tabla.getTableHeader().getDefaultRenderer();
            }
            Component comp = renderizar.getTableCellRendererComponent(tabla, modelo.getColumn(columna).getHeaderValue(), false, false, 0, 0);
            ancho = comp.getPreferredSize().width;
            for (int fila = 0; fila < tabla.getRowCount(); fila++)
            {
                renderizar = tabla.getCellRenderer(fila, columna);
                Object valor = tabla.getValueAt(fila, columna);
                comp = renderizar.getTableCellRendererComponent(tabla, valor, false, false, fila, columna);
                ancho = Math.max(comp.getPreferredSize().width, ancho);
            }
            ancho += 4;
            modelo.getColumn(columna).setPreferredWidth(ancho);
        }
    }

    public void llenarCombo(String sql, ComboBox<Valor> valorComboBox)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData rd=null;
        valorComboBox.getItems().clear();
        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            rd=rs.getMetaData();

            for (int i=1;i<=rd.getColumnCount();i++)
            {
                valorComboBox.getItems().addAll(new Valor(rd.getColumnName(i),rd.getColumnLabel(i)));

            }


            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void llenarCombo(String sql, String codigo, String campo, ChoiceBox<Valor> valorComboBox)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        valorComboBox.getItems().clear();
        try
        {
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next())
            {
                valorComboBox.getItems().add(new Valor(rs.getString(codigo), rs.getString(campo)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void llenarCombo(String sql, String codigo, String campo, ComboBox<Valor> valorComboBox)
    {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        valorComboBox.getItems().clear();
        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next())
            {
                valorComboBox.getItems().add(new Valor(rs.getString(codigo), rs.getString(campo)));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int obtenerValor(String sql)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int valor = 0;

        try
        {
            con = DriverManager.getConnection(url, usuario, clave);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next())
            {
                valor = rs.getInt(1);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e)
        {

        }

        return valor;
    }



    private ObservableList <ObservableList> datos(String sql)
    {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rmd;
        Blob blob;

        ObservableList <ObservableList> datos = FXCollections.observableArrayList();

        try
        {
            con = DriverManager.getConnection(url, usuario, clave);

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            rmd = rs.getMetaData();

            while (rs.next())
            {

                ObservableList<Object> fila = FXCollections.observableArrayList();

                for (int x = 1; x <= rmd.getColumnCount(); x++)
                {
                    if (rmd.getColumnTypeName(x).equalsIgnoreCase("blob") || rmd.getColumnTypeName(x).equalsIgnoreCase("longblob"))
                    {
                        blob = rs.getBlob(x);

                        byte[] archivo = null;

                        if (blob.length() > 0)
                        {
                            archivo = blob.getBytes(1, (int) blob.length());

                            Image imagen = new Image(new ByteArrayInputStream(archivo), 50, 50, true, true);

                            ImageView imag = new ImageView();
                            imag.setFitHeight(50);
                            imag.setFitWidth(50);
                            imag.setImage(imagen);
                            fila.add(imag);



                        }

                    } else
                    {
                        fila.add(rs.getString(x));
                    }

                }

                datos.add(fila);
            }


            rs.close();
            ps.close();
            con.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return datos;
    }




    public void llenarTabla(String sql, TableView tabla)
    {


        ObservableList <ObservableList> datos = FXCollections.observableArrayList();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData md;
        Blob blob;
        tabla.getColumns().clear();
        tabla.getItems().clear();

        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    url, usuario, clave);
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            md = rs.getMetaData();
            int columnasContador = md.getColumnCount();
            int alto = 0;
            for (int i = 1; i <= columnasContador; i++)
            {

                final int x = i-1;
                TableColumn columna=new TableColumn(md.getColumnLabel(i));
                columna.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,Object>,ObservableValue>(){

                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<ObservableList,Object> param) {
                        return new SimpleObjectProperty<Object>(param.getValue ().get (x));
                    }
                });
                tabla.getColumns().add(columna);
            }


            while (rs.next())
            {

                ObservableList<Object> fila = FXCollections.observableArrayList();

                for (int x = 1; x <= md.getColumnCount(); x++)
                {
                    if (md.getColumnTypeName(x).equalsIgnoreCase("blob") || md.getColumnTypeName(x).equalsIgnoreCase("longblob"))
                    {
                        blob = rs.getBlob(x);

                        byte[] archivo = null;

                        if (blob.length() > 0)
                        {
                            archivo = blob.getBytes(1, (int) blob.length());

                            Image imagen = new Image(new ByteArrayInputStream(archivo), 50, 50, true, true);

                            ImageView imag = new ImageView();
                            imag.setFitHeight(50);
                            imag.setFitWidth(50);
                            imag.setImage(imagen);
                            fila.add(imag);



                        }

                    } else
                    {
                        fila.add(rs.getString(x));
                    }

                }

                datos.add(fila);
            }


            tabla.getItems().addAll(datos);
            rs.close();
            ps.close();
            conexion.close();

        }
        catch (Exception ignored)
        {
              ignored.printStackTrace();
        }


    }


    public String devolverFecha(String sql,String formato)
    {
        Timestamp fecha=null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
         try
        {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next())
            {
             fecha=   rs.getTimestamp(1);
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Date fech=fecha;
       return new ConvertidorFechas().fechaConvertir(fech,formato);
    }


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

    public ObservableList<Usuario> traerUsuarios(String sql1, String sql2, String orden)
    {
        ObservableList<Usuario> permisoUsuarios= FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try
        {
           // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            st = conn.createStatement();
            rs = st.executeQuery(sql1);
            Encriptar encriptar=new Encriptar();


            while (rs.next())
            {
                Usuario usuario=new Usuario(rs.getString(1),encriptar.desencriptar(rs.getString(2)),encriptar.desencriptar(rs.getString(3)));
                 usuario.setPermisosUsuarioses( traerPermisosUsu(sql2+usuario.getIdUsuario()));
                permisoUsuarios.add(usuario);

            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return permisoUsuarios;
    }
}

        