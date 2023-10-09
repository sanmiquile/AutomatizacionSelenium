package testsms;

import Page.ConfigurarSMSPage;
import Page.HomeBasePage;
import Page.SingInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurarSMSTest extends TestBase {

    SingInPage singInPage;
    ConfigurarSMSPage configurarSMSPage;

    // Se ejecuta antes de cada prueba, para instanciar la clase de configurar SMS
    @BeforeEach
    public void setUp() throws InterruptedException {
        //Se llama el mètodo SetUpDriver que está en la clase padre testbase
        setUpDriver();
        singInPage = new SingInPage(getDriver());
        singInPage.sigIn(name, password);
        configurarSMSPage = new ConfigurarSMSPage(getDriver());
        assertTrue(configurarSMSPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if(!configurarSMSPage.getTitleApp().contains("Configurar SMS")) {
            configurarSMSPage.goStep("Configurar SMS");
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        configurarSMSPage.configurarsms(nameProject, descProject);
    }
}

