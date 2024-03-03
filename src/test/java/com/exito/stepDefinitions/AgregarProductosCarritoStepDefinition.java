package com.exito.stepDefinitions;

import com.exito.tasks.AgregarProductosAleatorios;
import com.exito.tasks.ValidarProductosCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class AgregarProductosCarritoStepDefinition {

    private static EnvironmentVariables environmentVariables;

    @Dado("^que el usuario se encuentre en la pagina principal de exito$")
    public void queElUsuarioSeEncuentreEnLaPaginaPrincipalDeExito() {
        String baseUrl = environmentVariables.optionalProperty("environments.qa.base.url").get();
        theActorCalled("user").wasAbleTo(
                Open.url(baseUrl)
        );
    }

    @Cuando("^el usuario selecciona los productos$")
    public void elUsuarioSeleccionaLosProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProductosAleatorios.alCarrito());
    }

    @Entonces("^se valida que los valores de los productos correspondan a los que estan en el carrito$")
    public void seValidaQueLosValoresDeLosProductosCorrespondanALosQueEstanEnElCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidarProductosCarrito.validar());
    }
}
