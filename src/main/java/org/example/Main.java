package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // Se le está diciendo que vamos a trabajar con el Navegador Chrome
        //vamos a crear el Driver de tipo webdriver, instancia del Driver
        WebDriver driver = new ChromeDriver(); // Indica que abra el navegador y lo inicializa
        // Ahora vamos ingresar la url de la aplicación web del navegador
        driver.navigate().to("http://189.50.209.188");
        // Maximizamos la ventana del navegador
        driver.manage().window().maximize();
        //si se desea que espere un tiempo forzoso la prueba
        // (ojo no es recomendable sino los implicitos y explicitos de selenium, investigar)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Para matar la sesión del Driver (Finalizar la prueba automática)
        driver.quit();

           }
}