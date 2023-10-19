package steps;

import dto.SignInRecord;
import injectionDependency.InjectionStart;
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
    public StepLogin(InjectionStart injectionStart) {
        this.injectionStart = injectionStart;
    }

    InjectionStart injectionStart;
    WebDriver driver = Hook.getDriver();

    @Given("soy un usuario que ya está registrado")
    public void soy_un_usuario_que_ya_está_registrado() {
        injectionStart.signInRecord = new SignInRecord("sami", "1234");

    }
        @When("accedo con mis credenciales de logueo")
        public void accedo_con_mis_credenciales_de_logueo () {
            injectionStart.singInPage = new SingInPage(driver);
            SignInRecord signInRecord = injectionStart.signInRecord;
            injectionStart.singInPage.sigIn(signInRecord.name(), signInRecord.password());

        }
        @Then("debo estar en el Home")
        public void debo_estar_en_el_home () throws InterruptedException {
            HomeBasePage homeBasePage = new HomeBasePage(driver);
            assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
        }
    }

