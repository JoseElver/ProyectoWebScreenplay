package com.exito.interactions;

import com.exito.userInterfaces.ProductosUI;
import com.exito.utils.Esperas;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

@Slf4j
public class AgregarCantidadRandom implements Interaction {

    Random random = new Random();
    ProductosUI productosUI=new ProductosUI();

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Esperas.esperarPor(2);
        int cantidadRandom = random.nextInt(10) + 1;
        for (int i = 1; i < cantidadRandom; i++) {
            actor.attemptsTo(
                    WaitUntil.the(productosUI.BTN_AGREGAR_MAS, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(productosUI.BTN_AGREGAR_MAS)
            );
        }
        log.info("Agrega una total de " + cantidadRandom + " unidades");
    }
    public static Performable agregar (){
        return Instrumented.instanceOf(AgregarCantidadRandom.class).withProperties();
    }
}