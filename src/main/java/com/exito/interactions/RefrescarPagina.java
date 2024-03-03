package com.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class RefrescarPagina implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
    }

    public static RefrescarPagina on(){

        return Instrumented.instanceOf(RefrescarPagina.class).withProperties();
    }
}
