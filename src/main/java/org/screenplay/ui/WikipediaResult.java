package org.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class WikipediaResult extends PageObject {

    public static final Target TEXT_RESUL = Target.the("Titulo de la pagina de busqueda")
            .locatedBy("//h1");

}
