package testsms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DriverManager;

import java.time.Duration;

public class TestBase {

    //Inicio Sesiòn
    public String name = "sami";
    public String password = "1234";


    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    // Este método inicializa el navegador

    public void setUpDriver() {
        driver = chromeDriverConnection();
        //Se usa para el tiempo de espera predeterminado en todo el programa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://189.50.209.188");
        driver.manage().window().maximize();
        DriverManager.INSTANCE.setDriver(driver);
    }


    // Se crea el mètodo para la conexiòn con el navegador
        private WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup(); // Se le está diciendo que vamos a trabajar con el Navegador Chrome
        //vamos a crear el Driver de tipo webdriver, instancia del Driver
        driver = new ChromeDriver(); // Indica que abra el navegador y lo inicializa
        // Ahora vamos ingresar la url de la aplicación web del navegador
        return driver;
    }
}