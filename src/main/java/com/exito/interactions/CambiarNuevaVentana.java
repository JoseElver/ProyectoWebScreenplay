package com.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class CambiarNuevaVentana implements Interaction {

    private String currentlyWindowHandle;

    public CambiarNuevaVentana(String currentlyWindowHandle) {
        this.currentlyWindowHandle = currentlyWindowHandle;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Set<String> allHandles = driver.getWindowHandles();
        Iterator<String> Il = allHandles.iterator();
        while(Il.hasNext()) {
            String child_windows = Il.next();
            if (!currentlyWindowHandle.equals(child_windows)) {
                driver.switchTo().window(child_windows);
            }
        }
    }
    public static CambiarNuevaVentana change(String currentlyWindowHandle) {
        return Instrumented.instanceOf(CambiarNuevaVentana.class).withProperties(currentlyWindowHandle);
    }
}



