package testsms;

import Page.RegisterPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterDuplicateTest extends TestBase{
    RegisterPage registerPage;

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
        String nameAll = "Sandra Milena Quintero Leal";
        String username = "sami";
        String passwordR="1234";

        registerPage.registerUser(nameAll, username, passwordR, passwordR);
        String message = registerPage.registerMessage();
        assertEquals(  "Existing registration", message);

    }

}
