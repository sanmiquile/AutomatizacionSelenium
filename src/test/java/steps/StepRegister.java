package steps;

import com.github.javafaker.Faker;
import dto.RegisterRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegister {
    WebDriver driver = Hook.getDriver();
    RegisterPage registerPage;
    Faker faker= new Faker();
    String nameAll ;
    String username ;
    String passwordR;

    @Given("soy un usuario no registrado")
    public void soy_un_usuario_no_registrado() {
        nameAll = faker.name().fullName();
        username = faker.name().username();
        passwordR=faker.internet().password();
    }
    @When("ingreso mis datos de afiliacion y me registro")
    public void ingreso_mis_datos_de_afiliacion_y_me_registro() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        RegisterRecord registerRecord = new RegisterRecord(nameAll, username, passwordR);
        registerPage.registerUser(registerRecord.nameAll(), registerRecord.username(),
                registerRecord.passwordR(), registerRecord.passwordR());
    }
    @Then("muestra mensaje de operación completada")
    public void muestra_mensaje_de_operación_completada() {
        String message = registerPage.registerMessage();
        assertEquals(  "Operación completada", message);
    }




}
