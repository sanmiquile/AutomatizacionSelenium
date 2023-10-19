package steps;

import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StepDeleteObj {

    public StepDeleteObj(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }
    InjectionHome injectionHome;
    @When("lo elimino")
    public void lo_elimino() {
        injectionHome.objetivoPage.eliminarObjetivo(injectionHome.objetiveCode);

    }
    @Then("muestra mensaje de operación completada y objetivo no se encuentra en tabla")
    public void muestra_mensaje_de_operacion_completada_y_objetivo_no_se_encuentra_en_tabla() {
        String message = injectionHome.objetivoPage.registerMessage();
        injectionHome.objetivoPage.isDisplayeObjetivePage();
        assertEquals(  "Operación completada", message);
        assertFalse(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveCode));
    }
}

