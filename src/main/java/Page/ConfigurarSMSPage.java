package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigurarSMSPage extends HomeBasePage{
    By configSMSLocator = By.xpath("//span[@class='ui-steps-number' and text()='1']");
    By nameProjectLocator = By.name("registro:nombre");
    By descriptionConfLocator = By.name("registro:descripcion");
    By configBtnLocator = By.id ("registro:j_idt84");

    public ConfigurarSMSPage(WebDriver driver) {
        super(driver);
    }

    public void configurarsms(String nameProject, String descProject) throws InterruptedException {
        click(configSMSLocator);
        type(nameProject,nameProjectLocator);
        type(descProject, descriptionConfLocator);
        click(configBtnLocator);
    }
    public boolean isHomePageDisplayed(){
        return  true;

    }
}
