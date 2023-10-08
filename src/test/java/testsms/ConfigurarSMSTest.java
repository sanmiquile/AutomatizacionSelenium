package testsms;

import Page.ConfigurarSMSPage;
import Page.SingInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ConfigurarSMSTest extends TestBase {

    SingInPage singInPage;
    ConfigurarSMSPage configurarSMSPage;
   // SingInPage singInPage;

    // Se ejecuta antes de cada prueba, para instanciar la clase de configurar SMS
    @BeforeEach
    public void setUp() {
        //Se llama el mètodo SetUpDriver que está en la clase padre testbase
        setUpDriver();
        singInPage = new SingInPage(getDriver());
        configurarSMSPage = new ConfigurarSMSPage(getDriver());
    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        singInPage.sigIn(name, password);
        configurarSMSPage.configurarsms(nameProject, descProject);
    }
}

