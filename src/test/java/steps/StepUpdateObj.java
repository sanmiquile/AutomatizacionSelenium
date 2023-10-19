package steps;

import com.github.javafaker.Faker;
import dto.ObjetiveRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepUpdateObj {

    public StepUpdateObj(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;

    //ObjetivoPage objetivoPage;
    Faker faker= new Faker();

    @When("acualizo su codigo y descripcion")
    public void acualizo_su_codigo_y_descripcion() throws InterruptedException {

        injectionHome.objetiveRecord = new ObjetiveRecord(faker.code().asin(),faker.lorem().sentence());

    }
    @And("confirmo la actualización")
    public void confirmoLaActualización() {
        injectionHome.objetivoPage.actualizarObjetivo(injectionHome.objetiveCode,injectionHome.objetiveRecord.objectiveCode(),
                injectionHome.objetiveRecord.objectiveDescription());
    }
    @Then("muestra mensaje de operación completada y objetivo actualizado en tabla")
        public void muestra_mensaje_de_operación_completada_y_objetivo_actualizado_en_tabla() {
            String message = injectionHome.objetivoPage.registerMessage();
            injectionHome.objetivoPage.isDisplayeObjetivePage();
            assertEquals("Operación completada", message);
            assertTrue(injectionHome.objetivoPage.buscarObjetivo(injectionHome.objetiveRecord.objectiveCode()));
        }


}


