package org.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consultawikipedia.feature",
        glue = "org.screenplay.stepdefinitions", //steps
        snippets = CucumberOptions.SnippetType.CAMELCASE//como se escriben los test
)
public class RunnerTaps {
}
