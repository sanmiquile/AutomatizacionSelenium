package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomeBasePage extends BasePage{
    //TODO localizar el boton de salida
    //TODO localizar la barra de navegación de pasos
    //TODO localizar el boton de menu izquierdo
    // y demas elementos comunes

    By goOutLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Salir']");
    By menuLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-bars'");
    By devolverLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-left'");
    By adelantarLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-right'");
    //By barraNavegationLocator = By.xpath("//div[@class='card'");
    By titleAppLocator = By.id("tituloApp");


    String stepLocator = "//span[@class='ui-steps-title' and text()='%s']";

    public HomeBasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() throws InterruptedException{
        boolean existe = false;
        List <By>  elementos = new ArrayList<>();
        elementos.add((goOutLocator));
        elementos.add((menuLocator));
        elementos.add((devolverLocator));
        elementos.add((adelantarLocator));

        for (By elemento: elementos) {
            if(isDisplayed(elemento)) {
                existe=true;
                break;
            }

        }
        return existe;
    }

public String getTitleApp (){
        return getText(titleAppLocator);
}

public void goStep ( String title){
        String newStep = String.format(stepLocator,title);
    System.out.println(newStep);
        click(By.xpath(newStep));
}


    }
