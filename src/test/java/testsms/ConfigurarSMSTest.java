package testsms;

import Page.ConfigurarSMSPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurarSMSTest extends TestHomeBase {

    ConfigurarSMSPage configurarSMSPage;

    // Se ejecuta antes de cada prueba, para instanciar la clase de configurar SMS
    @BeforeEach
    public void setUp() throws InterruptedException {
        //Se llama el mètodo SetUpDriver que está en la clase padre testbase
        login();
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
        assertTrue(configurarSMSPage.getTitleApp().contains("Objetivo"));
    }
}

