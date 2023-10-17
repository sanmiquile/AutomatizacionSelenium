package testsms;

import dto.RegisterRecord;
import dto.SignInRecord;
import page.HomeBasePage;
import page.SingInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        SignInRecord signInRecord = new SignInRecord(name, password);
        singInPage.sigIn(signInRecord.name(), signInRecord.password());
        //para leer las variables de entorno que seteamos en el IDE
        //singInPage.sigIn(System.getenv("NAME"), System.getenv("PASSWORD"));

        // Crear pagina interna
        // var inicioPage = new ParentInterPage(getDriver());
        HomeBasePage homeBasePage = new HomeBasePage(getDriver());
        assertTrue(homeBasePage.isHomePageDisplayed(), "No inició sesión correctamente");
        // Pedir a la pagina interna el texto del boton de salida o que exista



    }

}


