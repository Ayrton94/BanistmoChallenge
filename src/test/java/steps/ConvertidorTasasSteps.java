package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import questions.TasaConvertida;
import userinterfaces.pages.BancolombiaHomePage;
import userinterfaces.pages.ConvertidorTasasPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;
import static userinterfaces.pages.ConvertidorTasasPage.CAPITALIZACION_SELECT;
import static userinterfaces.pages.ConvertidorTasasPage.PERIODICIDAD_SELECT;

public class ConvertidorTasasSteps {

    @Managed
    private WebDriver driver;
    private Actor usuario;

    @Given("se ingresa a la pagina de Negocios con la opcion Herramientas")
    public void ingresarAHerramientas() {
        usuario = Actor.named("Cliente Bancolombia")
                .whoCan(BrowseTheWeb.with(driver));

        usuario.attemptsTo(
                Open.url("https://www.bancolombia.com/negocios/herramientas")
                //WaitUntil.the(MENU_FINANZAS, isClickable())
        );
    }

    @When("se selecciona la opcion {string}")
    public void seleccionarOpcionFinanzas(String nombreOpcion) {
        usuario.attemptsTo(
                // 1. Click en la flecha
                Click.on(BancolombiaHomePage.flechaDespliegueFinanzas()),

                // 2. Espera para la opción
                WaitUntil.the(
                        BancolombiaHomePage.opcionFinanzas(nombreOpcion),
                        isVisible() // Solo verifica visibilidad
                ).forNoMoreThan(15).seconds(),

                // 3. Scroll + Click
                Scroll.to(BancolombiaHomePage.opcionFinanzas(nombreOpcion)),
                Click.on(BancolombiaHomePage.opcionFinanzas(nombreOpcion))
        );
    }

    @And("se selecciona la herramienta {string}")
    public void seleccionarHerramienta(String herramienta) {
        usuario.attemptsTo(
                Click.on(BancolombiaHomePage.herramientaPorNombre(herramienta)),
                Switch.toNewWindow()
        );
    }

    @And("se realiza la conversión con tasa {string}, periodicidad {string} y capitalización {string}")
    public void realizarConversion(String tasa, String periodicidad, String capitalizacion) {
        usuario.attemptsTo(
                Click.on(BancolombiaHomePage.BOTON_CALCULAR),
                Enter.theValue(tasa).into(ConvertidorTasasPage.TASA_INPUT),
                SelectFromOptions.byVisibleText("Semestral").from(PERIODICIDAD_SELECT),
                SelectFromOptions.byVisibleText("Anual").from(CAPITALIZACION_SELECT),
                WaitUntil.the(ConvertidorTasasPage.RESULTADO, isVisible()).forNoMoreThan(5).seconds()        );
    }


    @Then("se debe visualizar el resultado {string}")
    public void verificarResultado(String resultadoEsperado) {
        usuario.should(
                seeThat(
                        "El porcentaje mostrado",
                        TasaConvertida.valor(),
                        equalTo(resultadoEsperado)
                )
        );
    }
}