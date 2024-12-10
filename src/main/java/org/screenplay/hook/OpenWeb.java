package org.screenplay.hook;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.screenplay.helpers.Constants.WEB_URL;

@AllArgsConstructor
public class OpenWeb implements Task {

    private EnvironmentVariables enviromentVariables;
    private String webUrl;

    @Override
    @Step("{0} abre el navegador web")
    public <T extends Actor> void performAs(T actor) {
        //obtiene url
        String pathWebURL = EnvironmentSpecificConfiguration.from(enviromentVariables).getProperty(WEB_URL);
        //que intente abrir la url
        actor.attemptsTo(Open.url(pathWebURL));
    }

    public static Performable browserURL(String webUrl) {
        return instrumented(OpenWeb.class, webUrl);
    }
}
