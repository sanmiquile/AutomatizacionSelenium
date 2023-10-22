package steps;

import com.github.javafaker.Faker;
import dto.ObjetiveRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjective {

    @Shared
    InjectionHome injectionHome;

   //ObjetivoPage objetivoPage;
    Faker faker= new Faker();

    @When("ingreso los datos del codigo y descripcion y creo el objetivo")
    public void ingreso_los_datos_del_codigo_y_descripcion_y_creo_el_objetivo() throws InterruptedException {
        injectionHome.objetiveRecord = new ObjetiveRecord(faker.code().asin(), faker.lorem().sentence());
        injectionHome.objetivoPage.objetivePage(injectionHome.objetiveRecord.objectiveCode(),
                injectionHome.objetiveRecord.objectiveDescription());
}

    @Then("muestra mensaje de operación completada y objetivo en tabla")
    public void muestra_mensaje_de_operacion_completada() {
        String message = injectionHome.objetivoPage.registerMessage();
        assertEquals(  "Operación completada", message);
        assertTrue(injectionHome.objetivoPage.isDisplayeObjetivePage());
        assertTrue(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveRecord.objectiveCode()));
    }


    @When("busco el objetivo")
    public void buscoElObjetivo() {
        injectionHome.objetiveCode = injectionHome.objetivoPage.seleccionarObjetivoAleatorio();
    }
}
