package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuestionPage extends HomeBasePage{
    By codQuestionLocator = By.id("formulario:j_idt705");
    By questionLocator = By.id("formulario:j_idt706");

    By checkboxLocator = By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'" +
                    "/span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
    By confirmQuestionBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By messageRegisterQ = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");


    public QuestionPage() {
        super();
    }

    public QuestionPage(WebDriver driver) {
        super(driver);
    }
    public void questionPage(String codigoQ, String question) throws InterruptedException{
        type(codigoQ, codQuestionLocator);
        type(question, questionLocator);
        click(checkboxLocator);
        click(confirmQuestionBtnLocator);
    }
    public String registerMessageQ(){
        // WaitforVisibleElement
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(messageRegisterQ));
        // Se manda el elemento para obtener el texto
        return getText(messageRegisterQ);

    }
}
