package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "userinterfaces"},
        plugin = {
                "pretty",
                "html:target/serenity-reports/html",
                "json:target/serenity-reports/json/cucumber.json"
        },
        stepNotifications = true
        )
public class ConvertidorTasasRunner {
}