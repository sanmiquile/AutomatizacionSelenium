package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingInPage extends BasePage {

    By userLocator = By.name("nombreUsuario");
    By passLocator = By.id("clave");
    By signInBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Ingresar']");
    //div[@class='ui-growl-message']/span[@class='ui-growl-title']"
    By message = By.xpath("//div[@id='content']/span[contains(text(),'No tiene permiso para acceder a este recurso')]");
    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public void sigIn(String name, String password) {
        type(name, userLocator);
        type(password, passLocator);
        click(signInBtnLocator);

    }
    public String registerMessageSign(){
        // WaitforVisibleElement
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        // Se manda el elemento para obtener el texto
        return getText(message);

    }
}
