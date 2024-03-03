package com.exito.interactions;


import com.exito.tasks.AgregarProductosAleatorios;
import com.exito.userInterfaces.ProductosUI;
import com.exito.utils.Esperas;
import lombok.SneakyThrows;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class SeleccionProductoRandom implements Interaction {

    ProductosUI productosUI=new ProductosUI();
    Random random = new Random();

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Esperas.esperarPor(2);
        List<WebElementFacade> listaProductos = (productosUI.BTN_PRODUCTOS).resolveAllFor(actor);
        int productoRandom = random.nextInt(listaProductos.size());
        actor.attemptsTo(
                WaitUntil.the(productosUI.BTN_PRODUCTOS, isClickable()).forNoMoreThan(60).seconds(),
                Scroll.to(productosUI.LBL_RESULTADOS)
        );
        listaProductos.get(productoRandom).click();
        listaProductos.remove(productoRandom);
        Esperas.esperarPor(2);
    }
    public static Performable seleccionar (){
        return Instrumented.instanceOf(SeleccionProductoRandom.class).withProperties();
    }
}