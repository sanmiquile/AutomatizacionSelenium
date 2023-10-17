package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigurarSMSPage extends HomeBasePage{
    By nameProjectLocator = By.name("registro:nombre");
    By descriptionConfLocator = By.name("registro:descripcion");
    By configBtnLocator = By.xpath("//button/span[@class='ui-button-text ui-c' and text()='Aceptar']");

    public ConfigurarSMSPage(WebDriver driver) {
        super(driver);
    }

    public void configurarsms(String nameProject, String descProject) throws InterruptedException {

        type(nameProject,nameProjectLocator);
        type(descProject, descriptionConfLocator);
        click(configBtnLocator);

    }


}