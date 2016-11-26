package org.edsmsoft.utilidades;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;

/**
 * Created by rcraft on 11-25-16.
 */
public class Escalar implements ChangeListener<Number>
{
    private final Scene scene;
    private final double proporcion;
    private final double altoInicial;
    private final double anchoInicial;
    private final Pane raiz;

    public Escalar(Scene scene, double proporcion, double altoInicial, double anchoInicial, Pane raiz) {
        this.scene = scene;
        this.proporcion = proporcion;
        this.altoInicial = altoInicial;
        this.anchoInicial = anchoInicial;
        this.raiz = raiz;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
        final double anchoNuevo  = scene.getWidth();
        final double altoNuevo = scene.getHeight();

        double escala =
                anchoNuevo / altoNuevo > proporcion
                        ? altoNuevo / altoInicial
                        : anchoNuevo / anchoInicial;

        if (escala >= 1) {
            Scale scale = new Scale(escala, escala);
            scale.setPivotX(0);
            scale.setPivotY(0);
            scene.getRoot().getTransforms().setAll(scale);

            raiz.setPrefHeight(altoNuevo / escala);
        } else {
            raiz.setPrefWidth(Math.max(anchoInicial, anchoNuevo));
            raiz.setPrefHeight(Math.max(altoInicial, altoNuevo));
        }
    }
}
