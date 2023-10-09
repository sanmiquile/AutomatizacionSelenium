package steps;

import Page.HomeBasePage;
import Page.SingInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Duration;

public class StepsDefinitions {

    WebDriver driver = null;
    String username = "sami";
    String password = "1234";

    SingInPage singInPage;
    @Given("estoy en la página de inicio de sesión del SMS Builder")
    public void estoy_en_la_página_de_inicio_de_sesión_del_sms_builder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("http://189.50.209.188");

    }
    @When("mi nombre de usuario válido y mi contraseña válida")
    public void mi_nombre_de_usuario_válido_y_mi_contraseña_válida() {
        singInPage= new SingInPage(driver);
        singInPage.sigIn(username, password);
    }
    @And("hago clic en el botón Ingresar")
    public void hago_clic_en_el_botón() {
        singInPage.ingresar();
    }
    @Then("debería estar en el Home")
    public void debería_estar_en_el_home() throws InterruptedException {
        HomeBasePage homeBasePage = new HomeBasePage(driver);
        assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
    }
}
