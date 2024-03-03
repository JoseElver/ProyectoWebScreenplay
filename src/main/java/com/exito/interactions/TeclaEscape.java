package com.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class TeclaEscape implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions acciones = new Actions(BrowseTheWeb.as(actor).getDriver());

        acciones.sendKeys(Keys.ESCAPE).build().perform();
    }
    public static TeclaEscape on(){

        return Instrumented.instanceOf(TeclaEscape.class).withProperties();
    }
}
