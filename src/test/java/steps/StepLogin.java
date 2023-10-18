package steps;

import dto.SignInRecord;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomeBasePage;
import page.SingInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepLogin {
    WebDriver driver = Hook.getDriver();
    String username ;
    String password ;
    SingInPage singInPage;

    @Given("soy un usuario que ya está registrado")
    public void soy_un_usuario_que_ya_está_registrado() {
        username = Hook.getUsername();
        password = Hook.getPassword();

    }
        @When("accedo con mis credenciales de logueo")
        public void accedo_con_mis_credenciales_de_logueo () {
            singInPage = new SingInPage(driver);
            SignInRecord signInRecord = new SignInRecord(username, password);
            singInPage.sigIn(signInRecord.name(), signInRecord.password());

        }
        @Then("debo estar en el Home")
        public void debo_estar_en_el_home () throws InterruptedException {
            HomeBasePage homeBasePage = new HomeBasePage(driver);
            assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
        }
    }

