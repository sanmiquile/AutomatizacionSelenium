package steps;

import page.HomeBasePage;
import page.SingInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepLogin {
    WebDriver driver = null;
    String username = "sami";
    String password = "1234";

    SingInPage singInPage;


    @Given("soy un usuario que ya está registrado")
    public void soy_un_usuario_que_ya_está_registrado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
        @When("accedo con mis credenciales de logueo")
        public void accedo_con_mis_credenciales_de_logueo () {
            singInPage = new SingInPage(driver);
            singInPage.sigIn(username, password);
        }
        @Then("debería estar en el Home")
        public void debería_estar_en_el_home () throws InterruptedException {
            HomeBasePage homeBasePage = new HomeBasePage(driver);
            assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
        }
    }

