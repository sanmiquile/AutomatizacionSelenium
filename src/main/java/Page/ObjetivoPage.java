package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjetivoPage extends HomeBasePage{
    By objSMSLocator = By.xpath("//span[@class='ui-steps-number' and text()='2']");
    By codObjectLocator = By.id("formulario:j_idt173");
    By descriObjectLocator = By.id("formulario:j_idt175");
    By confirmObjBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void objetivoPage() throws InterruptedException{
        click(objSMSLocator);
        type("Objetivo1", codObjectLocator);
        type("Prueba descripción objetivo", descriObjectLocator);
        click(confirmObjBtnLocator);
    }
    public boolean isHomePageDisplayed(){
        return  true;

    }
}
