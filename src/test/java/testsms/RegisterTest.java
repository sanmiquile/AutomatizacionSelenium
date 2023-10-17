package testsms;

import dto.RegisterRecord;
import page.RegisterPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        RegisterRecord registerRecord = new RegisterRecord(nameAll, username, passwordR);
        registerPage.registerUser(registerRecord.nameAll(), registerRecord.username(),
                registerRecord.passwordR(), registerRecord.passwordR());
        //registerPage.registerUser(nameAll, username, passwordR, passwordR);
        String message = registerPage.registerMessage();
        assertEquals(  "Operación completada", message);

    }

}