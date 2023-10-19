package steps;

import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepCancelDeleteObj {
    public StepCancelDeleteObj(InjectionHome injectionHome) {

        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;


    @When("presiono en eliminar y cancelo operacion")
    public void presiono_en_eliminar_y_cancelo_operacion()  {

        injectionHome.objetivoPage.cancelarEliminarObjetivo(injectionHome.objetiveCode);

    }
    @Then("el objetivo sigue en la tabla")
    public void el_objetivo_sigue_en_la_tabla() {
        assertTrue(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveCode));
    }
}
