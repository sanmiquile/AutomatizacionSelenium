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

public class StepUpdateObj {

    public StepUpdateObj(InjectionHome injectionHome) {
        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
    //ObjetivoPage objetivoPage;
    Faker faker= new Faker();
    String codigoObjetivo;
    String nuevoCod;
    String nuevaDesc;

    @When("busco el objetivo y acualizo su codigo y descripcion")
    public void busco_el_objetivo_y_acualizo_su_codigo_y_descripcion() throws InterruptedException {
        injectionHome.objetivoPage = new ObjetivoPage(driver);
        assertTrue(injectionHome.objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!injectionHome.objetivoPage.getTitleApp().contains("Objetivo")) {
            injectionHome.objetivoPage.goStep("Objetivo");
        }
        codigoObjetivo = injectionHome.objetivoPage.seleccionarObjetivoAleatorio();
        nuevoCod = faker.code().asin();
        nuevaDesc = faker.lorem().sentence();
        ObjetiveRecord objetiveRecord = new ObjetiveRecord(nuevoCod, nuevaDesc);

        injectionHome.objetivoPage.actualizarObjetivo(codigoObjetivo,objetiveRecord.objectiveCode(), objetiveRecord.objectiveDescription());
    }
        @Then("muestra mensaje de operación completada y objetivo actualizado en tabla")
        public void muestra_mensaje_de_operación_completada_y_objetivo_actualizado_en_tabla() {
            String message = injectionHome.objetivoPage.registerMessage();
            injectionHome.objetivoPage.isDisplayeObjetivePage();
            assertEquals("Operación completada", message);
            assertTrue(injectionHome.objetivoPage.buscarObjetivo(nuevoCod));
        }
    }


