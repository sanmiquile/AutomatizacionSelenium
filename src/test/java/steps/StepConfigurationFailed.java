package steps;

import com.github.javafaker.Faker;
import dto.ConfigureRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ConfigurarSMSPage;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfigurationFailed {
    public StepConfigurationFailed(InjectionHome injectionHome) {

        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
    //ConfigurarSMSPage configurarSMSPage;
        Faker faker= new Faker();
        String nameProject ;
        String descProject ;
    @When("ingreso datos en campo codigo vacío y una descripcion del proyecto")
    public void ingreso_datos_en_campo_codigo_vacío_y_una_descripcion_del_proyecto() throws InterruptedException {
        nameProject = "";
        descProject = faker.lorem().sentence();
        injectionHome.configurarSMSPage = new ConfigurarSMSPage(driver);
        assertTrue(injectionHome.configurarSMSPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if(!injectionHome.configurarSMSPage.getTitleApp().contains("Configurar SMS")) {
            injectionHome.configurarSMSPage.goStep("Configurar SMS");
        }
        ConfigureRecord configureRecord = new ConfigureRecord(nameProject, descProject);
        injectionHome.configurarSMSPage.configurarsms(configureRecord.nameProject(), configureRecord.descProject());

    }
    @Then("muestra mensaje de campo faltante")
    public void muestra_mensaje_de_campo_faltante() {
        String message = injectionHome.objetivoPage.registerMessage();
        assertEquals(  "formulario:j_idt596: Error de validación: se necesita un valor.", message);
    }
}



