package org.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://es.wikipedia.org/wiki/Wikipedia:Portada")
public class WikipediaHome extends PageObject {

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo texto busqueda")
            .locatedBy("//*[@id='searchInput']");

    public static final Target BTN_BUSQUEDA = Target.the("Boton buscador")
            .locatedBy("//*[@id='searchform']//button");

}
