package steps;

import dto.SignInRecord;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import page.HomeBasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepLogin {

    @Shared
    InjectionStart injectionStart;
    HomeBasePage homeBasePage;


    @Given("soy un usuario que ya está registrado")
    public void soy_un_usuario_que_ya_esta_registrado() {
        injectionStart.signInRecord = new SignInRecord("sami", "1234");

    }

    @When("accedo con mis credenciales de logueo")
    public void accedo_con_mis_credenciales_de_logueo() {
        SignInRecord signInRecord = injectionStart.signInRecord;
        injectionStart.singInPage.sigIn(signInRecord.name(), signInRecord.password());
    }

    @Then("debo estar en el Home")
    public void debo_estar_en_el_home() throws InterruptedException {
//        HomeBasePage homeBasePage = new HomeBasePage();
        assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
    }
}

