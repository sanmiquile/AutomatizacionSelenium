package steps;

import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.*;

public class StepDeleteObj {

    public StepDeleteObj(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
     //ObjetivoPage objetivoPage;

     String codigoObjetivo;

    @When("busco el objetivo y lo elimino")
    public void busco_el_objetivo_y_lo_elimino() throws InterruptedException {
        injectionHome.objetivoPage = new ObjetivoPage(driver);
        assertTrue(injectionHome.objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!injectionHome.objetivoPage.getTitleApp().contains("Objetivo")) {
            injectionHome.objetivoPage.goStep("Objetivo");
        }
        String codigoObjetivo= "New";
        injectionHome.objetivoPage.eliminarObjetivo(codigoObjetivo);

    }
    @Then("muestra mensaje de operación completada y objetivo no se encuentra en tabla")
    public void muestra_mensaje_de_operación_completada_y_objetivo_no_se_encuentra_en_tabla() {
        String message = injectionHome.objetivoPage.registerMessage();
        injectionHome.objetivoPage.isDisplayeObjetivePage();
        assertEquals(  "Operación completada", message);
        assertFalse(injectionHome.objetivoPage.buscarObjetivo(codigoObjetivo));
    }
}

