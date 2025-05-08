package userinterfaces.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BancolombiaHomePage extends PageObject {

    public static Target flechaDespliegueFinanzas() {
        return Target.the("Flecha de despliegue")
                .located(By.cssSelector("button.bc-fab-button i.bc-icon"));
    }

    public static Target opcionFinanzas(String nombreOpcion) {
        return Target.the("Opción '" + nombreOpcion + "'")
                .locatedBy("//div[contains(@class,'menu-item-link')]//a[contains(normalize-space(), '{0}')]")
                .of(nombreOpcion);
    }

    public static final Target MENU_FINANZAS = Target.the("Opción 'Gestionar finanzas'")
            .located(By.xpath("//div[contains(text(), 'Gestionar las finanzas de mi negocio')]"));


    public static Target herramientaPorNombre(String nombre) {
        return Target.the("Herramienta " + nombre)
                .locatedBy("//*[contains(text(),'" + nombre + "')]");
    }

    public static final Target CONVERTIDOR_TASAS =
            Target.the("Convertidor de tasas")
                    .locatedBy("//h3[contains(.,'Convertidor de tasas de interés')]");

    public static final Target BOTON_CALCULAR =
            Target.the("Botón Calcular")
                    .located(By.id("btntoolUno"));
}
