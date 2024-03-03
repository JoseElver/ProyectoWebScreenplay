package com.exito.tasks;

import com.exito.interactions.AgregarCantidadRandom;
import com.exito.interactions.SeleccionProductoRandom;
import com.exito.userInterfaces.PaginaPrincipalUI;
import com.exito.userInterfaces.ProductosUI;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

@Slf4j
public class AgregarProductosAleatorios implements Task {

    PaginaPrincipalUI paginaPrincipalUI = new PaginaPrincipalUI();
    ProductosUI productosUI = new ProductosUI();

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (paginaPrincipalUI.POPUP_PROMOCION.resolveFor(actor).isClickable()) {
            actor.attemptsTo(
                    Click.on(paginaPrincipalUI.POPUP_PROMOCION)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(paginaPrincipalUI.BTN_MENU, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(paginaPrincipalUI.BTN_MENU),
                WaitUntil.the(paginaPrincipalUI.BTN_CATEGORIA, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(paginaPrincipalUI.BTN_CATEGORIA),
                WaitUntil.the(paginaPrincipalUI.BTN_SUBCATEGORIA, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(paginaPrincipalUI.BTN_SUBCATEGORIA),
                WaitUntil.the(productosUI.LBL_RESULTADOS, isVisible()).forNoMoreThan(30).seconds()
        );
        log.info("Selecciona categoria y subcategoria");
        for (int i = 1; i <= 5; i++) {
            actor.attemptsTo(
                    SeleccionProductoRandom.seleccionar(),
                    WaitUntil.the(productosUI.BTN_AGREGAR, isVisible()).forNoMoreThan(30).seconds()
            );
            log.info("Agrega el " + i + " producto");
            if (!productosUI.BTN_AGREGAR.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        WaitUntil.the(productosUI.BTN_CONTINUAR_COMPRANDO, isClickable()).forNoMoreThan(60).seconds(),
                        WaitUntil.the(productosUI.LBL_ELEMENTO_INTERCEPTADO, isNotPresent()).forNoMoreThan(20).seconds(),
                        Click.on(productosUI.BTN_CONTINUAR_COMPRANDO),
                        WaitUntil.the(productosUI.BTN_PRODUCTOS, isClickable()).forNoMoreThan(60).seconds(),
                        SeleccionProductoRandom.seleccionar()
                );
                log.info("Agrega el " + i + " producto");
            }
            actor.attemptsTo(
                    Click.on(productosUI.BTN_AGREGAR),
                    AgregarCantidadRandom.agregar()
            );
            actor.remember("nombreProducto" + (i), (productosUI.LBL_NOMBRE_PRODUCTO).resolveFor(actor).getText());
            actor.remember("precioProducto" + (i), (productosUI.LBL_PRECIO_PRODUCTO).resolveFor(actor).getText());
            actor.remember("cantidadProducto" + (i), (productosUI.LBL_CANTIDAD_PRODUCTOS).resolveFor(actor).getText());
            actor.attemptsTo(
                    WaitUntil.the(productosUI.BTN_CONTINUAR_COMPRANDO, isClickable()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(productosUI.LBL_ELEMENTO_INTERCEPTADO, isNotPresent()).forNoMoreThan(20).seconds(),
                    Click.on(productosUI.BTN_CONTINUAR_COMPRANDO),
                    WaitUntil.the(productosUI.BTN_PRODUCTOS, isClickable()).forNoMoreThan(60).seconds()
            );

         /*  if (productosUI.POPUP_PRODUCTO_AGREGADO.resolveFor(actor).isClickable()) {
                actor.attemptsTo(
                        WaitUntil.the(productosUI.POPUP_PRODUCTO_AGREGADO, isNotCurrentlyVisible()).forNoMoreThan(5).seconds()
                );
            }*/
        }
        actor.attemptsTo(
                WaitUntil.the(productosUI.BTN_CARRITO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(productosUI.BTN_CARRITO)
        );

    }

    public static Performable alCarrito() {
        return Instrumented.instanceOf(AgregarProductosAleatorios.class).withProperties();
    }
}
