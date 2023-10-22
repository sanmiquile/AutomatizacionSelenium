package steps;

import dto.SignInRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Shared;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepsCommon {


    @Shared
    private InjectionHome injectionHome;
    //SingInPage singInPage;
    @Given("soy un usuario autenticado")
    public void soy_un_usuario_autenticado() throws InterruptedException {
        injectionHome.signInRecord = new SignInRecord("sami", "1234");
        injectionHome.singInPage.sigIn(injectionHome.signInRecord.name(), injectionHome.signInRecord.password());
        assertTrue(injectionHome.homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");


    }

    @And("estoy en el paso de {string}")
    public void estoyEnElPasoDe(String paso)  {
       if(!injectionHome.homeBasePage.getTitleApp().contains(paso)) {
            injectionHome.homeBasePage.goStep(paso);
        }
    }
}
