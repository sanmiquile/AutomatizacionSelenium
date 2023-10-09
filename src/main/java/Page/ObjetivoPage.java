package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjetivoPage extends HomeBasePage{
    By codObjectLocator = By.id("formulario:j_idt596");
    By descriObjectLocator = By.id("formulario:j_idt598");
    By confirmObjBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By messageRegister = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");


    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void objetivePage(String objetive, String description) throws InterruptedException{
        type(objetive, codObjectLocator);
        type(description, descriObjectLocator);
        click(confirmObjBtnLocator);
    }
    public String registerMessage(){
        // WaitforVisibleElement
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(messageRegister));
        // Se manda el elemento para obtener el texto
        return getText(messageRegister);

    }
}
