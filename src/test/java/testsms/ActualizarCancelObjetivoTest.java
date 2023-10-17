package testsms;

import Page.ObjetivoPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActualizarCancelObjetivoTest extends TestHomeBase{
    ObjetivoPage objetivoPage;


    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        objetivoPage = new ObjetivoPage(getDriver());
        assertTrue(objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!objetivoPage.getTitleApp().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");
        }
    }

    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        String codigoObjetivo= "Treeflex";
        String nuevoCod = "New";
        String nuevaDesc = "Description";
        objetivoPage.actualizarCancelObjetivo(codigoObjetivo, nuevoCod, nuevaDesc);
        String message = objetivoPage.registerMessage();
        assertEquals(  "Operación cancelada", message);
        assertTrue(objetivoPage.buscarObjetivo(codigoObjetivo));

    }

}
