package userinterfaces.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BancolombiaHomePage extends PageObject {

    public static final Target MENU_NEGOCIOS = Target.the("Menú Negocios")
            .located(By.xpath("//a[contains(text(),'Negocios')]"));

    public static final Target SECCION_HERRAMIENTAS = Target.the("Sección Herramientas")
            .located(By.xpath("//section[contains(@class,'herramientas')]"));

    public static final Target CONVERTIDOR_TASAS = Target.the("Convertidor de Tasas")
            .located(By.xpath("//h3[contains(text(),'Convertidor de tasas de interés')]"));
}