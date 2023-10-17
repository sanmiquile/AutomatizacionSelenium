package testsms;

import page.QuestionPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionTest extends TestHomeBase{
    QuestionPage questionPage;
    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        questionPage = new QuestionPage(getDriver());
            assertTrue(questionPage.isHomePageDisplayed(),"No inició sesión correctamente");
            if(!questionPage.getTitleApp().contains("Pregunta de Investigación")) {
                questionPage.goStep("Pregunta de Investigación");
        }
    }
    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        questionPage.questionPage(objectiveCode, objectiveDescription);
        String message = questionPage.registerMessageQ();
        assertEquals(  "Operación completada", message);
    }


}
