package steps;

import dto.SignInRecord;
import injectionDependency.InjectionHome;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.HomeBasePage;
import page.SingInPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepsCommon {


    public StepsCommon(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    private final InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
    //SingInPage singInPage;
    @Given("soy un usuario autenticado")
    public void soy_un_usuario_autenticado() throws InterruptedException {
        injectionHome.signInRecord = new SignInRecord("sami", "1234");
        injectionHome.singInPage = new SingInPage(driver);
        injectionHome.singInPage.sigIn(injectionHome.signInRecord.name(), injectionHome.signInRecord.password());
        injectionHome.homeBasePage = new HomeBasePage(driver);
        assertTrue(injectionHome.homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");


    }

    @And("estoy en el paso de {string}")
    public void estoyEnElPasoDe(String paso)  {
       if(!injectionHome.homeBasePage.getTitleApp().contains(paso)) {
            injectionHome.homeBasePage.goStep(paso);
        }
    }
}
