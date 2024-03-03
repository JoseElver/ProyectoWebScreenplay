package com.exito.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/agregarProductosCarrito.feature",
        glue = "com.exito.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty",
        tags = "@HU"
)

public class AgregarProductosCarritoRunner {
}
