package userinterfaces.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConvertidorTasasPage extends PageObject {

    public static final Target CALCULAR_BUTTON = Target.the("Botón Calcular")
            .located(By.id("btntoolUno"));
    public static final Target TASA_INPUT =
            Target.the("Campo tasa de interés")
                    .located(By.id("interes"));

    public static final Target PERIODICIDAD_SELECT =
            Target.the("Select periodicidad")
                    .located(By.id("periodicidad-deseada"));

    public static final Target CAPITALIZACION_SELECT =
            Target.the("Select capitalización")
                    .located(By.id("capitalizacion"));

    public static final Target RESULTADO =
            Target.the("Porcentaje resultado")
                    .located(By.id("respuesta"));
}