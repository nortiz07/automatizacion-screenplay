package org.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.screenplay.ui.WikipediaHome;

public class AbrirWebTask implements Task {

    //llama la clase de ui donde se tiene la url
    private WikipediaHome wikipediaHome;

    // crea un metodo de la clase para llamarla
    public static AbrirWebTask abrirWebTask() {
        return Tasks.instrumented(AbrirWebTask.class);
    }

    //el actor intenta abrir la web
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(wikipediaHome));
    }
}
