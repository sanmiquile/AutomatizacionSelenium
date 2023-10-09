package testsms;

import Page.SingInPage;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

public class TestHomeBase extends TestBase{
    Faker faker= new Faker();
    // Datos configura proyecto
    public String nameProject = faker.app().name();
    public String descProject = faker.lorem().sentence();

    // Datos Objetivo Proyecto

    public String objectiveCode = faker.code().asin();
    public String objectiveDescription = faker.lorem().sentence();

    SingInPage singInPage;

    public void login (){
        setUpDriver();
        singInPage = new SingInPage(getDriver());
        singInPage.sigIn(name, password);

    }

}
