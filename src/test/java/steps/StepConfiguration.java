package steps;

import com.github.javafaker.Faker;
import dto.ConfigureRecord;
import dto.RegisterRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ConfigurarSMSPage;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfiguration {
    public StepConfiguration(InjectionHome injectionHome) {

        this.injectionHome = injectionHome;
    }

    InjectionHome injectionHome;
    WebDriver driver = Hook.getDriver();
    //ConfigurarSMSPage configurarSMSPage;
        Faker faker= new Faker();

    @When("creo el codigo y descripcion del proyecto")
    public void creo_el_codigo_y_descripcion_del_proyecto() throws InterruptedException {
        injectionHome.configureRecord = new ConfigureRecord(faker.app().name(),faker.lorem().sentence());
        injectionHome.configurarSMSPage = new ConfigurarSMSPage(driver);
        injectionHome.configurarSMSPage.configurarsms(injectionHome.configureRecord.nameProject(),
                injectionHome.configureRecord.descProject());

    }
    @Then("debo pasar a la página de Objetivos")
    public void debo_pasar_a_la_página_de_objetivos() {

        ObjetivoPage objetivoPage = new ObjetivoPage(driver);
        assertTrue(objetivoPage.isDisplayeObjetivePage());
        assertTrue(objetivoPage.getTitleApp().contains("Objetivo"));
    }

}
