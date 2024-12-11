package org.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.screenplay.ui.WikipediaResult.TEXT_RESUL;

public class RespuestaElementBusqueda implements Question<String> {

    public static RespuestaElementBusqueda respuestaElementBusqueda() {
        return new RespuestaElementBusqueda();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TEXT_RESUL).answeredBy(actor);
    }


}
