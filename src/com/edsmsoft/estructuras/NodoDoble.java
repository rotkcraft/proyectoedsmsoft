package com.edsmsoft.estructuras;

/**
 * Creado por hadexexplade el 19/07/15.11:39
 */
public class NodoDoble<E>
{
    private E info;
    private NodoDoble<E> anterior;
    private NodoDoble<E> siguiente;

    public NodoDoble(E info, NodoDoble<E> anterior, NodoDoble<E> siguiente)
    {
        this.info = info;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public E getInfo()
    {
        return info;
    }

    public void setInfo(E info)
    {
        this.info = info;
    }

    public NodoDoble<E> getAnterior()
    {
        return anterior;
    }

    public void setAnterior(NodoDoble<E> anterior)
    {
        this.anterior = anterior;
    }

    public NodoDoble<E> getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<E> siguiente)
    {
        this.siguiente = siguiente;
    }
}
