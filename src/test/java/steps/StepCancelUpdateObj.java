package steps;

import injectionDependency.InjectionHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StepCancelUpdateObj {

    @Shared
    InjectionHome injectionHome;
    @And("cancelo la actualización")
    public void cancelo() {
        injectionHome.objetivoPage.actualizarCancelObjetivo(injectionHome.objetiveCode,
                injectionHome.objetiveRecord.objectiveCode(), injectionHome.objetiveRecord.objectiveDescription());
    }

    @Then("muestra mensaje de operación cancelada y objetivo no se actualiza")
    public void muestra_mensaje_de_operacion_cancelada_y_objetivo_no_se_actualiza() {
        String message = injectionHome.objetivoPage.registerMessage();
        injectionHome.objetivoPage.isDisplayeObjetivePage();
        assertEquals("Operación cancelada", message);
        assertFalse(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveRecord.objectiveCode()));
    }
}
