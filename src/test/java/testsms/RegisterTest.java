package testsms;

import Page.RegisterPage;
import com.github.javafaker.Bool;
import com.github.javafaker.Faker;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest extends TestBase{
    RegisterPage registerPage;
    Faker faker= new Faker();

    @BeforeEach
    public void setUp() {
        setUpDriver();
        registerPage = new RegisterPage(getDriver());
    }
    @AfterEach
    public void tearDown() throws Exception {
    //driver.quit();
    }

    @Test
    public void test() throws InterruptedException{
        //Asignación aleatoria de datos
        String nameAll = faker.name().fullName();
        String username = faker.name().username();
        String passwordR=faker.internet().password();

        registerPage.registerUser(nameAll, username, passwordR, passwordR);
        String message = registerPage.registerMessage();
        assertEquals(  "Operación completada", message);

    }

}
