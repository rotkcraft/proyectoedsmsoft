package org.edsmsoft.utilidades;

/**
 * Creado por hadexexplade el 16/07/15.17:10
 */
public class Valor implements Comparable<Valor>
{
    private String id;
    private String valor;

    public Valor(String id, String valor)
    {
        this.id = id;
        this.valor = valor;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    public String toString()
    {
        return valor;
    }

    @Override
    public int compareTo(Valor o)
    {
        return valor.compareTo(o.getValor());
    }
}
