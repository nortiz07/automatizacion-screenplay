package org.screenplay.tasks;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.screenplay.ui.WikipediaHome.BTN_BUSQUEDA;
import static org.screenplay.ui.WikipediaHome.CAMPO_BUSQUEDA;

@Slf4j
public class BuscarTask implements Task {

    public BuscarTask(String palabra) {
        this.palabra = palabra;
    }

    private String palabra;

    public static BuscarTask buscarTask(String palabra) {
        return Tasks.instrumented(BuscarTask.class, palabra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        log.info("CUAL ES TEST LA PALABRA: {}", palabra);
        actor.attemptsTo(WaitUntil.the(CAMPO_BUSQUEDA, isEnabled()),
                Enter.theValue(palabra).into(CAMPO_BUSQUEDA));
        actor.attemptsTo(Click.on(BTN_BUSQUEDA));
    }
}
