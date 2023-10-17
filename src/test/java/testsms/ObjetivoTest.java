package testsms;

import page.ObjetivoPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjetivoTest extends TestHomeBase{
    ObjetivoPage objetivoPage;
    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        objetivoPage = new ObjetivoPage(getDriver());
        assertTrue(objetivoPage.isHomePageDisplayed(),"No inició sesión correctamente");
        if(!objetivoPage.getTitleApp().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");
        }
    }
    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        objetivoPage.objetivePage(objectiveCode, objectiveDescription);
        String message = objetivoPage.registerMessage();
        assertEquals(  "Operación completada", message);
    }

    //Eliminar o editar


    // Editar <span class="ui-icon ui-icon-pencil"></span>
    // Eliminar ui-button-icon-left ui-icon ui-c pi pi-trash
    // Editar còdigo
    // Editar Descripcion
    // Actualizar <span class="ui-icon ui-icon-check ui-c"></span>
    // Modal Eliminar Div class ui-confirm-dialog ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container
    // span class ui-confirm-dialog-message 'Está seguro de eliminar este registro'
    // NO <span class="ui-button-text ui-c">No</span>
    // SI <span class="ui-button-text ui-c">Si</span>
    // X <span class="ui-icon ui-icon-closethick"></span>
}
