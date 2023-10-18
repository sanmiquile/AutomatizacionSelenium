package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjective {
    WebDriver driver = Hook.getDriver();

   ObjetivoPage objetivoPage;
    Faker faker= new Faker();
    String objectiveCode;
    String objectiveDescription ;

    @When("ingreso los datos del codigo y descripcion y creo el objetivo")
    public void ingreso_los_datos_del_codigo_y_descripcion_y_creo_el_objetivo() throws InterruptedException {
        objectiveCode = faker.code().asin();
        objectiveDescription = faker.lorem().sentence();
        objetivoPage = new ObjetivoPage(driver);
        assertTrue(objetivoPage.isHomePageDisplayed(),"No inició sesión correctamente");
        if(!objetivoPage.getTitleApp().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");

        }
        objetivoPage.objetivePage(objectiveCode, objectiveDescription);
}

    @Then("muestra mensaje de operación completada y objetivo en tabla")
    public void muestra_mensaje_de_operación_completada() {
        String message = objetivoPage.registerMessage();
        assertEquals(  "Operación completada", message);
        assertTrue(objetivoPage.isDisplayeObjetivePage());
        assertTrue(objetivoPage.buscarObjetivo(objectiveCode));
    }



}
