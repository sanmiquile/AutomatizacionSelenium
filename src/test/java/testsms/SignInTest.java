package testsms;

import Page.HomeBasePage;
import Page.SingInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SignInTest extends TestBase {

    SingInPage singInPage;

    @BeforeEach
    public void setUp() {
        setUpDriver();
        singInPage = new SingInPage(getDriver());
    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        singInPage.sigIn(name, password);
        //para leer las variables de entorno que seteamos en el IDE
        //singInPage.sigIn(System.getenv("NAME"), System.getenv("PASSWORD"));

        // Crear pagina interna
        // var inicioPage = new ParentInterPage(getDriver());
        HomeBasePage homeBasePage = new HomeBasePage(getDriver());
        assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
        // Pedir a la pagina interna el texto del boton de salida o que exista



    }

}


