package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.pages.ConvertidorTasasPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InteraccionesTasks implements Task {

    private final String tasa;
    private final String periodicidad;
    private final String capitalizacion;

    public InteraccionesTasks(String tasa, String periodicidad, String capitalizacion) {
        this.tasa = tasa;
        this.periodicidad = periodicidad;
        this.capitalizacion = capitalizacion;
    }

    public static InteraccionesTasks conLosDatos(String tasa, String periodicidad, String capitalizacion) {
        return instrumented(InteraccionesTasks.class, tasa, periodicidad, capitalizacion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConvertidorTasasPage.OPCION_NOMINAL_A_EFECTIVA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConvertidorTasasPage.OPCION_NOMINAL_A_EFECTIVA),

                WaitUntil.the(ConvertidorTasasPage.TASA_INTERES_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(tasa).into(ConvertidorTasasPage.TASA_INTERES_INPUT),

                WaitUntil.the(ConvertidorTasasPage.PERIODICIDAD_DROPDOWN, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(periodicidad).from(ConvertidorTasasPage.PERIODICIDAD_DROPDOWN),

                WaitUntil.the(ConvertidorTasasPage.CAPITALIZACION_DROPDOWN, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(capitalizacion).from(ConvertidorTasasPage.CAPITALIZACION_DROPDOWN),

                WaitUntil.the(ConvertidorTasasPage.BOTON_CALCULAR, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ConvertidorTasasPage.BOTON_CALCULAR),

                WaitUntil.the(ConvertidorTasasPage.RESULTADO_TEXT, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}