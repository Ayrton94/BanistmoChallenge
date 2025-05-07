package userinterfaces.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConvertidorTasasPage extends PageObject {

    public static final Target OPCION_NOMINAL_A_EFECTIVA = Target.the("Opción Nominal a Efectiva")
            .located(By.xpath("//button[contains(text(),'nominal a efectiva')]"));

    public static final Target TASA_INTERES_INPUT = Target.the("Campo Tasa de Interés")
            .located(By.id("tasaInteres"));

    public static final Target PERIODICIDAD_DROPDOWN = Target.the("Dropdown Periodicidad")
            .located(By.name("periodicidad"));

    public static final Target CAPITALIZACION_DROPDOWN = Target.the("Dropdown Capitalización")
            .located(By.name("capitalizacion"));

    public static final Target BOTON_CALCULAR = Target.the("Botón Calcular")
            .located(By.xpath("//button[contains(text(),'Calcular')]"));

    public static final Target RESULTADO_TEXT = Target.the("Texto Resultado")
            .located(By.cssSelector(".resultado span"));
}