package testsms;

import Page.SingInPage;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

public class TestHomeBase extends TestBase{

    // Datos configura proyecto
    Faker faker= new Faker();
   // public String nameProject = "Proyecto1";
    public String nameProject = faker.app().name();
    //public String descProject = "Proyecto de prueba";
    // Genera una descripción corta de proyecto
    public String descProject = faker.lorem().sentence();

    // Datos Objetivo Proyecto
    SingInPage singInPage;

    public void login (){
        setUpDriver();
        singInPage = new SingInPage(getDriver());
        singInPage.sigIn(name, password);

    }

}
