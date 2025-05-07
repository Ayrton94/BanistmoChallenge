package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarA implements Task {

    public static NavegarA laPaginaDeHerramientas() {
        return instrumented(NavegarA.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.bancolombia.com/negocios/herramientas")
        );
    }
}