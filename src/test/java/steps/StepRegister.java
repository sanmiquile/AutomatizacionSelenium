package steps;

import com.github.javafaker.Faker;
import dto.RegisterRecord;
import injectionDependency.InjectionHome;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegister {

    InjectionStart injectionStart;
    WebDriver driver = Hook.getDriver();
    //RegisterPage registerPage;
    Faker faker= new Faker();

    public StepRegister(InjectionStart injectionStart) {

        this.injectionStart = injectionStart;
    }

    @Given("soy un usuario no registrado")
    public void soy_un_usuario_no_registrado() {
        injectionStart.registerRecord = new RegisterRecord(faker.name().fullName(),faker.name().username(), faker.internet().password() );
    }
    @When("ingreso mis datos de afiliacion y me registro")
    public void ingreso_mis_datos_de_afiliacion_y_me_registro() throws InterruptedException {
        injectionStart.registerPage = new RegisterPage(driver);
        RegisterRecord registerRecord = injectionStart.registerRecord;
        injectionStart.registerPage.registerUser(registerRecord.nameAll(), registerRecord.username(),
                registerRecord.passwordR(), registerRecord.passwordR());

    }
    @Then("muestra mensaje de operación completada")
    public void muestra_mensaje_de_operación_completada() {
        String message = injectionStart.registerPage.registerMessage();
        assertEquals(  "Operación completada", message);
    }




}
