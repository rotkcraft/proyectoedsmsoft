package com.edsmsoft.utilidades;

import com.sun.javafx.scene.control.skin.TableViewSkin;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ColumnasAjustador
{
    private static Method ajustarColumnas;

    static
    {
        try
        {
            ajustarColumnas = TableViewSkin.class.getDeclaredMethod("resizeColumnToFitContent", TableColumn.class, int.class);
            ajustarColumnas.setAccessible(true);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }

    public static void autoFitTable(TableView tableView)
    {
        tableView.getItems().addListener(new ListChangeListener<Object>()
        {
            @Override
            public void onChanged(Change<?> c)
            {
                for (Object column : tableView.getColumns())
                {
                    try
                    {
                        ajustarColumnas.invoke(tableView.getSkin(), column, -1);
                    }
                    catch (IllegalAccessException | InvocationTargetException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}