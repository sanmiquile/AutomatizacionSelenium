package steps;


import com.github.javafaker.Faker;
import dto.SignInRecord;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.SingInPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepSignInFailed {
    public StepSignInFailed(InjectionStart injectionStart) {

        this.injectionStart = injectionStart;
    }

    InjectionStart injectionStart;
    WebDriver driver = Hook.getDriver();
    Faker faker= new Faker();

    @Given("soy un usuario que no está registrado")
    public void soy_un_usuario_que_no_está_registrado() {
        injectionStart.signInRecord = new SignInRecord(faker.name().username(), faker.internet().password());
    }

    @When("accedo con credenciales invalidas")
    public void accedo_con_credenciales_invalidas()
    {
        injectionStart.singInPage = new SingInPage(driver);
        injectionStart.singInPage.sigIn(injectionStart.signInRecord.name(), injectionStart.signInRecord.password());
    }
    @Then("muestra mensaje de fallo")
    public void muestra_mensaje_de_fallo() {
        String messageNoExist = injectionStart.singInPage.registerMessageSign();
        assertEquals(  "No tiene permiso para acceder a este recurso, ingrese al sistema " +
                "con sus datos de acceso, o regístrese en caso de que no tenga un usuario " +
                "registrado.", messageNoExist);
    }
}
