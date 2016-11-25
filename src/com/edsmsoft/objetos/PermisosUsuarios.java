package com.edsmsoft.objetos;

/**
 * Creado por hadexexplade el 30/11/15.11:01
 */
public class PermisosUsuarios
{
    private String idPermisos;
    private String modulo;
    private String nivel;
    private boolean estado;

    public PermisosUsuarios(String idPermisos, String modulo, String nivel, boolean estado)
    {
        this.idPermisos = idPermisos;
        this.modulo = modulo;
        this.nivel = nivel;
        this.estado = estado;
    }

    public String getIdPermisos()
    {
        return idPermisos;
    }

    public void setIdPermisos(String idPermisos)
    {
        this.idPermisos = idPermisos;
    }

    public String getModulo()
    {
        return modulo;
    }

    public void setModulo(String modulo)
    {
        this.modulo = modulo;
    }

    public String getNivel()
    {
        return nivel;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }

    public boolean isEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }
}
