package org.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.screenplay.helpers.Constants.TIME_SHORT;
import static org.screenplay.ui.Home.ID_CARD_ELEMENTS;

public class FuntionsElementsTask implements Task {

    @Override
    @Step("{0} seleccion de la ID card elements")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(ID_CARD_ELEMENTS));
        actor.attemptsTo(WaitUntil.the(ID_CARD_ELEMENTS, isEnabled())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(ID_CARD_ELEMENTS));
    }

    public static FuntionsElementsTask choose() {
        return Tasks.instrumented(FuntionsElementsTask.class);
    }
}
