package steps;

import com.github.javafaker.Faker;
import dto.RegisterRecord;
import injectionDependency.InjectionStart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegisterDuplicate {
    InjectionStart injectionStart;
    public StepRegisterDuplicate(InjectionStart injectionStart) {

        this.injectionStart = injectionStart;
    }

    //RegisterPage registerPage;
    String nameAll;
    String username ;
    String password ;
    @Given("soy un usuario que ya estaba registrado")
    public void soy_un_usuario_que_ya_estaba_registrado() {
        injectionStart.registerRecord = new RegisterRecord("Sandra Milena Quintero Leal", "sami", "1234");
    }
    @Then("muestra mensaje de que ya existe el registro")
    public void muestra_mensaje_de_que_ya_existe_el_registro() {
        String message = injectionStart.registerPage.registerMessage();
        assertEquals(  "Existing registration", message);

    }
}
