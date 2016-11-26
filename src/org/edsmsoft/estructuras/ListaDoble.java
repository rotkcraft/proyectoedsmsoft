package org.edsmsoft.estructuras;

import java.util.Random;

/**
 * Created by rcraft on 11-25-16.
 */
public class ListaDoble<E> implements Cloneable
{
    private NodoDoble<E> primero;
    private NodoDoble<E> ultimo;
    private int cantidad;


    public ListaDoble()
    {
        primero = new NodoDoble<E>(null, null, null);
        ultimo = new NodoDoble<E>(null, primero, null);
        primero.setSiguiente(ultimo);
        this.cantidad = 0;

    }

    public int getCantidad()
    {
        return cantidad;
    }

    public boolean esVacia()
    {

        return getCantidad() == 0;
    }

    public void vaciar()
    {

        primero = new NodoDoble<E>(null, null, null);
        ultimo = new NodoDoble<E>(null, primero, null);
        primero.setSiguiente(ultimo);
        cantidad = 0;
    }

    public void insInicio(E info)
    {
        agregar(info, primero, primero.getSiguiente());

    }

    private void agregar(E info, NodoDoble<E> anterior, NodoDoble<E> siguiente)
    {
        NodoDoble<E> temp = new NodoDoble<E>(info, anterior, siguiente);
        anterior.setSiguiente(temp);
        siguiente.setAnterior(temp);
        cantidad++;
    }

    public void insFinal(E info)
    {
        agregar(info, ultimo.getAnterior(), ultimo);

    }

    public void insPos(E info, int pos)
    {
        if (esVacia() || (pos > cantidad + 2 && pos < 1))
        {

            return;
        }
        else if (pos == 1)
        {
            insInicio(info);
        }
        else if (pos == cantidad + 1)
        {
            insFinal(info);
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();
            NodoDoble<E> anterior = primero;
            int c = 0;
            while (actual != ultimo && (c != pos - 1))
            {

                anterior = actual;
                actual = actual.getSiguiente();
                c++;
            }
            agregar(info, anterior, actual);

        }
    }

    public void insOrdenadoDesc(E info)
    {
        if (esVacia())
        {
            insFinal(info);

        }
        else if (((Comparable<E>) primero.getSiguiente().getInfo()).compareTo(info) <= 0)
        {
            insInicio(info);
        }
        else if (((Comparable<E>) ultimo.getAnterior().getInfo()).compareTo(info) >= 0)
        {
            insFinal(info);
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();
            NodoDoble<E> anterior = primero;
            int c = 0;
            while (actual != ultimo && ((Comparable<E>) actual.getInfo()).compareTo(info) >= 0)
            {

                anterior = actual;
                actual = actual.getSiguiente();
                c++;
            }
            agregar(info, anterior, actual);

        }

    }

    public void insOrdenadoAsc(E info)
    {
        if (esVacia())
        {
            insFinal(info);

        }
        else if (((Comparable<E>) primero.getSiguiente().getInfo()).compareTo(info) >= 0)
        {
            insInicio(info);
        }
        else if (((Comparable<E>) ultimo.getAnterior().getInfo()).compareTo(info) <= 0)
        {
            insFinal(info);
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();
            NodoDoble<E> anterior = primero;
            int c = 0;
            while (actual != ultimo && ((Comparable<E>) actual.getInfo()).compareTo(info) <= 0)
            {

                anterior = actual;
                actual = actual.getSiguiente();
                c++;
            }
            agregar(info, anterior, actual);

        }

    }

    public NodoDoble<E> getPrimero()
    {

        return primero.getSiguiente();
    }

    public NodoDoble<E> getUltimo()
    {
        return ultimo.getAnterior();
    }

    public NodoDoble<E> ret_Nodo(int pos)
    {
        NodoDoble<E> dato = null;
        if (esVacia() || (pos > cantidad && pos < 1))
        {

            return dato;
        }
        else if (pos == 1)
        {
            return getPrimero();
        }
        else if (pos == cantidad)
        {
            return getUltimo();
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();
            int c = 0;
            while (actual != ultimo && (c != pos - 1))
            {

                actual = actual.getSiguiente();
                c++;
            }

            dato = actual;

        }
        return dato;


    }

    public E primero()
    {
        return primero.getSiguiente().getInfo();
    }

    public E ultimo()
    {
        return ultimo.getAnterior().getInfo();
    }


    public E ret_Elemento(int pos)
    {
        E dato = null;
        if (esVacia() || (pos > cantidad && pos < 1))
        {

            return dato;
        }
        else if (pos == 1)
        {
            return primero();
        }
        else if (pos == cantidad)
        {
            return ultimo();
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();
            NodoDoble<E> anterior = primero;
            int c = 0;
            while (actual != ultimo && (c != pos - 1))
            {

                anterior = actual;
                actual = actual.getSiguiente();
                c++;
            }

            dato = actual.getInfo();

        }
        return dato;


    }

    public int veces(E info)
    {
        int c = 0;
        for (NodoDoble<E> a = primero.getSiguiente(); a != ultimo; a.getSiguiente())
        {
            if (a.getInfo().equals(info))
            {
                c++;

            }

        }
        return c;

    }

    public E elimPrimero()
    {
        if (esVacia())
        {
            return null;
        }
        return eliminar(primero.getSiguiente());
    }

    public E elimUltimo()
    {
        if (esVacia())
        {
            return null;
        }
        return eliminar(ultimo.getSiguiente());
    }

    private E eliminar(NodoDoble<E> nodoD)
    {

        NodoDoble<E> anterior = nodoD.getAnterior();
        NodoDoble<E> actual = nodoD.getSiguiente();
        anterior.setSiguiente(actual);
        actual.setAnterior(anterior);
        cantidad--;
        return nodoD.getInfo();

    }

    public E eliminarPos(int pos)
    {
        E dato = null;
        if (esVacia() || (pos > cantidad && pos < 1))
        {

            return dato;
        }
        else if (pos == 1)
        {
            return elimPrimero();
        }
        else if (pos == cantidad)
        {
            return elimUltimo();
        }
        else
        {
            NodoDoble<E> actual = primero.getSiguiente();

            int c = 0;
            while (actual != ultimo && (c != pos - 1))
            {


                actual = actual.getSiguiente();
                c++;
            }
            dato = eliminar(actual);


        }
        return dato;


    }

    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodoDoble<E> ac = primero.getSiguiente();
        while (ac != ultimo)
        {

            sb.append(ac.getInfo() + ((ac.getSiguiente() != ultimo) ? "," : ""));
            ac = ac.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }

    public void revolver()
    {

        Random r = new Random();
        for (int x = getCantidad(); x > 1; x--)
        {
            intercambiar(x - 1, 1 + r.nextInt(x));

        }
    }

    private void intercambiar(int posa, int posb)
    {
        NodoDoble<E> a = ret_Nodo(posa);
        NodoDoble<E> b = ret_Nodo(posb);

        E t = a.getInfo();
        a.setInfo(b.getInfo());
        b.setInfo(t);

    }

    public String inverso()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodoDoble<E> ac = ultimo.getAnterior();
        while (ac != primero)
        {

            sb.append(ac.getInfo() + ((ac.getAnterior() != primero) ? "," : ""));
            ac = ac.getAnterior();
        }
        sb.append("]");
        return sb.toString();
    }

    public ListaDoble<E> clone()
    {
        ListaDoble<E> listaDoble = new ListaDoble<E>();
        for (int i = 1; i <= cantidad; i++)
        {
            listaDoble.insFinal(ret_Elemento(i));
        }
        return listaDoble;
    }

}



