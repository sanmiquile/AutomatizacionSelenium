package steps;

import injectionDependency.InjectionStart;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hook {

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;


    private static String allname ="Sandra Milena Quintero Leal";
    private static String username ="sami";
    private static String password ="1234";

    public static String getAllname() {
        return allname;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setAllname(String allname) {
        Hook.allname = allname;
    }

    public static void setUsername(String username) {
        Hook.username = username;
    }

    public static void setPassword(String password) {
        Hook.password = password;
    }

    @Before
    public void setUpDriver() {

        driver = chromeDriverConnection();
        //Se usa para el tiempo de espera predeterminado en todo el programa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://189.50.209.188");
        driver.manage().window().maximize();
    }

    private WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup(); // Se le está diciendo que vamos a trabajar con el Navegador Chrome
        //vamos a crear el Driver de tipo webdriver, instancia del Driver
        driver = new ChromeDriver(); // Indica que abra el navegador y lo inicializa
        // Ahora vamos ingresar la url de la aplicación web del navegador
        return driver;
    }
    @After
    public void tearDown(){
        driver.quit();

    }

}
