package steps;

import com.github.javafaker.Faker;
import dto.ObjetiveRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjective {

    public StepObjective(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();

   //ObjetivoPage objetivoPage;
    Faker faker= new Faker();

    @When("ingreso los datos del codigo y descripcion y creo el objetivo")
    public void ingreso_los_datos_del_codigo_y_descripcion_y_creo_el_objetivo() throws InterruptedException {
        injectionHome.objetiveRecord = new ObjetiveRecord(faker.code().asin(), faker.lorem().sentence());
        injectionHome.objetivoPage = new ObjetivoPage(driver);
        injectionHome.objetivoPage.objetivePage(injectionHome.objetiveRecord.objectiveCode(),
                injectionHome.objetiveRecord.objectiveDescription());
}

    @Then("muestra mensaje de operación completada y objetivo en tabla")
    public void muestra_mensaje_de_operación_completada() {
        String message = injectionHome.objetivoPage.registerMessage();
        assertEquals(  "Operación completada", message);
        assertTrue(injectionHome.objetivoPage.isDisplayeObjetivePage());
        assertTrue(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveRecord.objectiveCode()));
    }


    @When("busco el objetivo")
    public void buscoElObjetivo() {
        injectionHome.objetivoPage = new ObjetivoPage(driver);
        injectionHome.objetiveCode = injectionHome.objetivoPage.seleccionarObjetivoAleatorio();
    }
}
