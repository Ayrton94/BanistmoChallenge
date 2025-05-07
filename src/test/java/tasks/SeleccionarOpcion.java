package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.pages.BancolombiaHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Task {

    private final String opcion;

    public SeleccionarOpcion(String opcion) {
        this.opcion = opcion;
    }

    public static SeleccionarOpcion delMenu(String opcion) {
        return instrumented(SeleccionarOpcion.class, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(opcion.equals("Negocios")) {
            actor.attemptsTo(
                    Click.on(BancolombiaHomePage.MENU_NEGOCIOS)
            );
        }
    }
}