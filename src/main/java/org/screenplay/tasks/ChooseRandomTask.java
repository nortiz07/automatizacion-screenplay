package org.screenplay.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static org.screenplay.helpers.Constants.REMEMBER_TEXT_BTN;
import static org.screenplay.ui.Home.BTN_ELEMENTS;
import static org.screenplay.ui.Home.BTN_LIST_ELEMENT;

@AllArgsConstructor
public class ChooseRandomTask implements Task {

    private String numberRamdom;

    @Override
    @Step("{0} seleccion un elemento con un numero random")
    public <T extends Actor> void performAs(T actor) {
        String number = numberRamdom;
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS),
                Click.on(BTN_LIST_ELEMENT.of(number))
        );

        String textBtn = BTN_LIST_ELEMENT.of(
                number).resolveFor(actor).getText();
        actor.remember(REMEMBER_TEXT_BTN, textBtn);
    }

    public static ChooseRandomTask witchParams(String numberRamdom) {
        return Tasks.instrumented(ChooseRandomTask.class, numberRamdom);
    }
}
