package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage extends BasePage {

    By userLocator = By.name("nombreUsuario");
    By passLocator = By.id("clave");
    By signInBtnLocator = By.name("j_idt74");

    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public void sigIn(String name, String password) {
        type(name, userLocator);
        type(password, passLocator);
        click(signInBtnLocator);
    }

    public boolean isHomePageDisplayed() {
        return true;
    }
}
