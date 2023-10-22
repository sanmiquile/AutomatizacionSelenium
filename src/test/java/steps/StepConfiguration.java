package steps;

import com.github.javafaker.Faker;
import dto.ConfigureRecord;
import injectionDependency.InjectionHome;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfiguration {


    @Shared
    InjectionHome injectionHome;
    //ConfigurarSMSPage configurarSMSPage;
    Faker faker = new Faker();

    @When("creo el codigo y descripcion del proyecto")
    public void creo_el_codigo_y_descripcion_del_proyecto() throws InterruptedException {
        injectionHome.configureRecord = new ConfigureRecord(faker.app().name(), faker.lorem().sentence());
//        injectionHome.configurarSMSPage = new ConfigurarSMSPage();
        injectionHome.configurarSMSPage.configurarsms(injectionHome.configureRecord.nameProject(),
                injectionHome.configureRecord.descProject());

    }

    @Then("debo pasar a la página de Objetivos")
    public void debo_pasar_a_la_pagina_de_objetivos() {

//        ObjetivoPage objetivoPage = new ObjetivoPage();

        assertTrue(injectionHome.objetivoPage.isDisplayeObjetivePage());
        assertTrue(injectionHome.objetivoPage.getTitleApp().contains("Objetivo"));
    }

}
