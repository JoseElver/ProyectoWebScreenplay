package com.exito.stepDefinitions.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hook {

    @Before
    public void configureBaseUrl() {
        setTheStage(new OnlineCast());
    }

    @After
    public void closeDriver() {
                getDriver().close();
    }
}
