package steps;

import page.RegisterPage;
import page.SingInPage;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Duration;

public class StepsDefinitions {

    WebDriver driver = null;

    SingInPage singInPage;
    RegisterPage registerPage;

  @Given("estoy en la página de inicio de sesión del SMS Builder")
    public void estoy_en_la_página_de_inicio_de_sesión_del_sms_builder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("http://189.50.209.188");

    }
 /*
    @When("presiono el botón de Registrar")
    public void presiono_el_botón_de_registrar() {
        registerPage.registrar();
    }
    @When("ingresao datos válidos de nombre, usuario, contraseña y confirmación de contraseña")
    public void ingresao_datos_válidos_de_nombre_usuario_contraseña_y_confirmación_de_contraseña() {
        registerPage.registerUser("Luis Perez", "lucho", "1234", "1234");
    }
    @When("hago clic en el botón Aceptar")
    public void hago_clic_en_el_botón_aceptar() {
        registerPage.AceptBoton();
    }
    @Then("muestra mensaje de operación completada")
    public void muestra_mensaje_de_operación_completada() {
        registerPage.registerMessage();
    }

*/




}
