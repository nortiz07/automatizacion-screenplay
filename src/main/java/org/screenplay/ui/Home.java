package org.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Home extends PageObject {

    public static final Target ID_CARD_ELEMENTS = Target.the("Boton de elementos")
            .locatedBy("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]");

    public static final Target BTN_ELEMENTS = Target.the("Boton elementos")
            .locatedBy("//div[@class='header-wrapper']//div[contains(text(),'Elements')]");

    //parametrizable porque se puede cambiar el cero del final y encuentra cualquier elemento de la lista
    public static final Target BTN_LIST_ELEMENT = Target.the("Lista elemento")
            .locatedBy("//div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[{0}]");

    public static final Target TXT_RANDOM_NAME_BTN = Target.the("Text random del titulo")
            .locatedBy("//h1");

}
