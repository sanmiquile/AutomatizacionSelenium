package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeBasePage extends BasePage{
    //TODO localizar el boton de salida
    //TODO localizar la barra de navegación de pasos
    //TODO localizar el boton de menu izquierdo
    // y demas elementos comunes

    By goOutLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Salir']");
    By menuLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-bars'");
    By devolverLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-left'");
    By adelantarLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-right'");
    By barraNavegationLocator = By.xpath("//div[@class='card'");
    public HomeBasePage(WebDriver driver) {
        super(driver);
    }

    public void homeBasePage() throws InterruptedException{
        click(goOutLocator);
        click(menuLocator);
        click(devolverLocator);
        click(adelantarLocator);
    }


    public boolean isHomePageDisplayed(){
        return  true;

    }




}
