package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;
import util.DriverManager;

public class Hook {

//    public static WebDriver getDriver() {
//        return driver;
//    }

    @Managed
    private WebDriver driver;

    @Before
    public void setUpDriver() {
        //driver = chromeDriverConnection();
        //Se usa para el tiempo de espera predeterminado en todo el programa
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://189.50.209.188");
//        driver.manage().window().maximize();
        DriverManager.INSTANCE.setDriver(driver);
    }

    @After
    public void tearDown(){
        driver.quit();

    }




}
