package org.screenplay.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.screenplay.ui.Home.TXT_RANDOM_NAME_BTN;

@AllArgsConstructor
@Slf4j
public class ValidateElementsTestBtn implements Question<Boolean> {

    private String validText;

    @Override
    @Subject("{0} se realiza validacion de los elementos capturados")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String textValidateHeader = TXT_RANDOM_NAME_BTN.resolveFor(actor).getText();
        if (textValidateHeader != null && validText.equals(textValidateHeader)) {
            log.info("BOTTON AQUI HEADER: {}", textValidateHeader);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static ValidateElementsTestBtn witchParams(String validText) {
        return new ValidateElementsTestBtn(validText);
    }
}
