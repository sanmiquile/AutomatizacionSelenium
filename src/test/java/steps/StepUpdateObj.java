package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepUpdateObj {
    WebDriver driver = Hook.getDriver();
    ObjetivoPage objetivoPage;
    String codigoObjetivo;
    String nuevoCod;
    String nuevaDesc;

    @When("busco el objetivo y acualizo su codigo y descripcion")
    public void busco_el_objetivo_y_acualizo_su_codigo_y_descripcion() throws InterruptedException {
        objetivoPage = new ObjetivoPage(driver);
        assertTrue(objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!objetivoPage.getTitleApp().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");
        }
        codigoObjetivo = "Stim";
        nuevoCod = "Stim2";
        nuevaDesc = "Description";
        objetivoPage.actualizarObjetivo(codigoObjetivo, nuevoCod, nuevaDesc);
    }
        @Then("muestra mensaje de operación completada y objetivo actualizado en tabla")
        public void muestra_mensaje_de_operación_completada_y_objetivo_actualizado_en_tabla() {
            String message = objetivoPage.registerMessage();
            objetivoPage.isDisplayeObjetivePage();
            assertEquals("Operación completada", message);
            assertTrue(objetivoPage.buscarObjetivo(nuevoCod));
        }
    }


