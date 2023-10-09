package testsms;

import Page.SingInPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInFailedTest extends TestBase {

    SingInPage singInPage;
    Faker faker= new Faker();

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
        String name = faker.name().username();
        String password=faker.internet().password();
        singInPage.sigIn(name, password);
        String messageNoExist = singInPage.registerMessageSign();
        assertEquals(  "No tiene permiso para acceder a este recurso, ingrese al sistema " +
                "con sus datos de acceso, o regístrese en caso de que no tenga un usuario " +
                "registrado.", messageNoExist);






    }

}


