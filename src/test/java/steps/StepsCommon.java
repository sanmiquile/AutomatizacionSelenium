package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.SingInPage;


public class StepsCommon {
    WebDriver driver = Hook.getDriver();
    SingInPage singInPage;
    String username ;
    String password ;
    @Given("soy un usuario autenticado")
    public void soy_un_usuario_autenticado() {
        username = Hook.getUsername();
        password = Hook.getPassword();
        singInPage = new SingInPage(driver);
        singInPage.sigIn(username, password);
    }
}
