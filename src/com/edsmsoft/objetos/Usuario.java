package com.edsmsoft.objetos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Creado por hadexexplade el 30/11/15.10:58
 */
public class Usuario
{
    private String idUsuario;
    private String usuario;
    private String clave;
    private ObservableList <PermisosUsuarios>permisosUsuarioses;

    public Usuario(String idUsuario, String usuario, String clave)
    {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.permisosUsuarioses= FXCollections.emptyObservableList();
    }

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public ObservableList<PermisosUsuarios> getPermisosUsuarioses()
    {
        return permisosUsuarioses;
    }

    public void setPermisosUsuarioses(ObservableList<PermisosUsuarios> permisosUsuarioses)
    {
        this.permisosUsuarioses = permisosUsuarioses;
    }

    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Usuario))
        {
            return false;
        }

        Usuario usuario1 = (Usuario) o;

        if (!usuario.equals(usuario1.getUsuario()))
        {
            return false;
        }
        return clave.equals(usuario1.getClave());

    }

    public String toString()
    {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

}
