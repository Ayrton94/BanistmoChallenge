package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.pages.ConvertidorTasasPage;

public class TasaConvertida implements Question<String> {
    public static TasaConvertida valor() {
        return new TasaConvertida();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConvertidorTasasPage.RESULTADO)
                .asString()
                .answeredBy(actor)
                .trim(); // Elimina espacios alrededor
    }
}