package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Esta clase hereda de la clase Base Page
public class RegisterPage extends SingInPage{

    // Elementos de la página Registrarse - Localizadores
    By registerBtnLocator = By.xpath("//span[text()='Registrarse']");
    By userNameCompleteLocator = By.name("registro:nombre");
    By usernameLocator = By.id("registro:nombreUsuario");
    By passwordLocator = By.id("registro:clave");
    By confirmPasswordLocator = By.name("registro:verificacionClave");
    By acceptBtnLocator = By.name("registro:j_idt88");
    By messageRegister = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser(String nameAll, String username, String password, String confirmPass ) throws InterruptedException {
    click(registerBtnLocator);
    type(nameAll,userNameCompleteLocator);
    type(username, usernameLocator);
    type(password,passwordLocator);
    type(confirmPass, confirmPasswordLocator);
    click(acceptBtnLocator);

    }
     public String registerMessage(){
    // WaitforVisibleElement
    getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(messageRegister));
         // Se manda el elemento para obtener el texto
        return getText(messageRegister);
       // return elemento -> GetMessage;
    }
}
