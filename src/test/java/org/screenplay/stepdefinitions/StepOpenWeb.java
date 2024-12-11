//gestion los escenarios del feature
package org.screenplay.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.screenplay.questions.ValidateElementsTestBtn;
import org.screenplay.tasks.ChooseRandomTask;
import org.screenplay.tasks.FuntionsElementsTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.screenplay.helpers.Constants.ACTOR;
import static org.screenplay.helpers.Constants.REMEMBER_TEXT_BTN;
import static org.screenplay.helpers.DataFaker.fakerNumberOneAndNine;

@Slf4j
public class StepOpenWeb {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("desea validar la funcion de la carta de elementos")
    public void youWantToValidateTheFunctionOfTheElementChart() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                FuntionsElementsTask.choose()
        );
    }

    @When("selecciona aleatoriamente alguna de las subfunciones")
    public void randomlySelectAnyOfTheSubfunction() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                ChooseRandomTask.witchParams(fakerNumberOneAndNine())
        );
    }

    @Then("visualizara en la cabecera el nombre de la opcion elegida")
    public void theNameOfTheChosenOptionWillBeDisplayedInTheHeader() {
        String validaText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN);
        if (validaText != null) {
            log.info("NOMBRE BOTON: {}", validaText);
        }
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsTestBtn.witchParams(validaText))
        );
    }

}
