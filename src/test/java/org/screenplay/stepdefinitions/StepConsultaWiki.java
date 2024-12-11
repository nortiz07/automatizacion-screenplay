package org.screenplay.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.hamcrest.Matchers.equalTo;

import org.screenplay.questions.RespuestaElementBusqueda;
import org.screenplay.tasks.AbrirWebTask;
import org.screenplay.tasks.BuscarTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

@Slf4j
public class StepConsultaWiki {

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    @Given("que Oscar quiere buscar en wikipedia")
    public void whatOscarWantsToSearchOnWikipedia() {
        theActorCalled("Oscar").wasAbleTo(AbrirWebTask.abrirWebTask());
    }

    @When("el ingresa la palabra (.*) en el buscador$")
    public void heEntersTheWordTestIntoTheSearchEngine(String palabra) {
        log.info("METODO PALABRAA: {}", palabra);
        theActorInTheSpotlight().attemptsTo(BuscarTask.buscarTask(palabra));
    }

    @Then("el deberia ver la palabra {string} en la pantalla")
    public void theShouldSeeTheWordTestOnTheScreen(String palabraEsperada) {
        //String palabraEsperada = "Test";
        log.info("Encontro: {}", RespuestaElementBusqueda.respuestaElementBusqueda().answeredBy(theActorInTheSpotlight()));
        log.info("Esperada: {}", palabraEsperada);
        theActorInTheSpotlight().should(seeThat(
                RespuestaElementBusqueda.respuestaElementBusqueda(), equalTo(palabraEsperada)));
    }


}
