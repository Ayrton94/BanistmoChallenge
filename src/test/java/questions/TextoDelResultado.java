package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.pages.ConvertidorTasasPage;

public class TextoDelResultado implements Question<String> {

    public static Question<String> deConversion() {
        return new TextoDelResultado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConvertidorTasasPage.RESULTADO_TEXT)
                .answeredBy(actor);
    };
}