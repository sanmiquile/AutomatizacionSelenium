package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// Esta clase contendrá los elementos bases para el modelo POM, donde se realiza la conexiòn
// al navegador y se realiza el envoltorio (Wrajpper) donde estarán los comandos de Selenium
public class BasePage {
// Se crea la variable de tipo webdriver
    private WebDriver driver;

    public WebDriverWait getEwait() {
        return ewait;
    }

    private WebDriverWait ewait ;

    // Se crea el constructor de la clase
    public BasePage (WebDriver driver){
        this.driver = driver;
        // Se crea Explicit Wait ejecutando un tiempo dependiendo de la condiciòn que se establezca
        ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // Este método crea el envoltorio Wrapper para los comandos de Selenium WebDriver

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    // este metodo nos devuelve una lista de elementos

    public List<WebElement> findElements(By locator){

        return driver.findElements(locator);
    }
    // Este metodo devulve el texto del elemento que se pasa por parametro
    public String getText(WebElement element){
        return  element.getText();
    }

    //Este metodo nos devuelve el texto del elemento que estamos buscando por medio del locator
    public  String getText(By locator){
        return  driver.findElement(locator).getText();
    }
    // Este metodo nos permite escribir texto en la prueba con el comando sendkeys o type(teclear)
    public void type(String inputText,By locator){
        //Localiza el elemento y limpia lo que halla en èl
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }
    //
    public  void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }
    // Este metodo nos dice si el elemento esta listo para ser utilizado, en caso que no
    // exista devuelve una excepción si el elemento no existe, no ha cargado o fue modificado

    public Boolean isDisplayed(By locator){
        try{

            return  driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return  false;
        }
    }



}
