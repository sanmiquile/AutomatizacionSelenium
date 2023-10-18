package steps;

import injectionDependency.InjectionHome;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.SingInPage;


public class StepsCommon {


    public StepsCommon(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    private InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
    //SingInPage singInPage;
    String username ;
    String password ;
    @Given("soy un usuario autenticado")
    public void soy_un_usuario_autenticado() {
        username = Hook.getUsername();
        password = Hook.getPassword();
        injectionHome.singInPage = new SingInPage(driver);
        injectionHome.singInPage.sigIn(username, password);
    }
}
