package tasks;

import models.TasasData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userinterfaces.pages.ConvertidorTasasPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConvertirTasa implements Task {
    private TasasData tasasData;

    public ConvertirTasa(TasasData tasasData) {
        this.tasasData = tasasData;
    }

    public static ConvertirTasa conLosDatos(TasasData tasasData) {
        return instrumented(ConvertirTasa.class, tasasData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(tasasData.getTasaInteres())
                        .into(ConvertidorTasasPage.TASA_INTERES_INPUT),

                SelectFromOptions.byVisibleText(tasasData.getPeriodicidad())
                        .from(ConvertidorTasasPage.PERIODICIDAD_DROPDOWN),

                SelectFromOptions.byVisibleText(tasasData.getCapitalizacion())
                        .from(ConvertidorTasasPage.CAPITALIZACION_DROPDOWN),

                Click.on(ConvertidorTasasPage.BOTON_CALCULAR)
        );
    }
}