package steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userinterfaces.pages.ConvertidorTasasPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConvertirTasa implements Task {

    private final String tasa;
    private final String periodicidad;
    private final String capitalizacion;

    public ConvertirTasa(String tasa, String periodicidad, String capitalizacion) {
        this.tasa = tasa;
        this.periodicidad = periodicidad;
        this.capitalizacion = capitalizacion;
    }

    public static ConvertirTasa conLosDatos(String tasa, String periodicidad, String capitalizacion) {
        return instrumented(ConvertirTasa.class, tasa, periodicidad, capitalizacion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConvertidorTasasPage.OPCION_NOMINAL_A_EFECTIVA),
                Enter.theValue(tasa).into(ConvertidorTasasPage.TASA_INTERES_INPUT),
                SelectFromOptions.byVisibleText(periodicidad).from(ConvertidorTasasPage.PERIODICIDAD_DROPDOWN),
                SelectFromOptions.byVisibleText(capitalizacion).from(ConvertidorTasasPage.CAPITALIZACION_DROPDOWN),
                Click.on(ConvertidorTasasPage.BOTON_CALCULAR)
        );
    }
}