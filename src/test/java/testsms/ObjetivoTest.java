package testsms;

import Page.ObjetivoPage;
import Page.SingInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjetivoTest extends TestHomeBase{
    SingInPage singInPage;
    ObjetivoPage objetivoPage;
    @BeforeEach
    public void setUp() {
        setUpDriver();
        singInPage = new SingInPage(getDriver());
        objetivoPage = new ObjetivoPage(getDriver());
    }
    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        singInPage.sigIn(name, password);
        objetivoPage.objetivoPage();

    }

}
