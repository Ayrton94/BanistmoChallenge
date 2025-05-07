package steps;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import tasks.NavegarA;
import userinterfaces.pages.BancolombiaHomePage;
import userinterfaces.pages.ConvertidorTasasPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

public class ConvertidorTasasSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {string} accede a la página de herramientas de Bancolombia")
    public void accederAPagina(String nombreActor) {
        theActorCalled(nombreActor).attemptsTo(
                NavegarA.laPaginaDeHerramientas()
        );
    }

    @Cuando("selecciona la opción {string} del menú principal")
    public void seleccionarOpcionMenu(String opcion) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BancolombiaHomePage.MENU_NEGOCIOS)
        );
    }

    @Cuando("accede a la sección {string}")
    public void accederASeccion(String seccion) {
        // Implementación simple sin task específica
        theActorInTheSpotlight().attemptsTo(
                Click.on(BancolombiaHomePage.SECCION_HERRAMIENTAS)
        );
    }

    @Cuando("selecciona la herramienta {string}")
    public void seleccionarHerramienta(String herramienta) {
        // Implementación directa sin task específica
        theActorInTheSpotlight().attemptsTo(
                Click.on(BancolombiaHomePage.CONVERTIDOR_TASAS)
        );
    }

    @Cuando("realiza la conversión con tasa {string}, periodicidad {string} y capitalización {string}")
    public void realizarConversion(String tasa, String periodicidad, String capitalizacion) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ConvertidorTasasPage.OPCION_NOMINAL_A_EFECTIVA),
                Enter.theValue(tasa).into(ConvertidorTasasPage.TASA_INTERES_INPUT),
                SelectFromOptions.byVisibleText(periodicidad).from(ConvertidorTasasPage.PERIODICIDAD_DROPDOWN),
                SelectFromOptions.byVisibleText(capitalizacion).from(ConvertidorTasasPage.CAPITALIZACION_DROPDOWN),
                Click.on(ConvertidorTasasPage.BOTON_CALCULAR)
        );
    }

    @Entonces("debe visualizar el resultado {string}")
    public void verificarResultado(String resultadoEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El resultado de la conversión",
                        Text.of(ConvertidorTasasPage.RESULTADO_TEXT).asString(),
                        containsString(resultadoEsperado))
        );
    }
}