package org.aureum;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"org.aureum"},
        plugin = {"pretty", "json:target/TestRunner-report.json"},
        tags = "@AureumChallenge and not @NoRun"
)

public class TestRunner {
}
