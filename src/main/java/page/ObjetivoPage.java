package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ObjetivoPage extends HomeBasePage {
    By codObjectLocator = By.id("formulario:j_idt596");
    By descriObjectLocator = By.id("formulario:j_idt598");
    By confirmObjBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By messageRegister = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By tableObjetive = By.id("tabla:j_idt602_data");
    By tableEditObjetiveBtn = By.xpath("//*[@id='tabla:j_idt602_data']//tr/td[3]/div//span[@class='ui-icon ui-icon-pencil']");
    By newCodeLocator = By.cssSelector(".ui-row-editing > td:nth-child(1) input");
    By newDescriptionLocator = By.cssSelector(".ui-row-editing > td:nth-child(2) textarea");
    By actualizarBtnLocator = By.cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-check");
    By cancelarActualizarLocator = By. cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-close");
    By eliminarObjetivoLocator = By.xpath("//*[@id='tabla:j_idt602_data']//tr/td[3]/button//span[@class='ui-button-icon-left ui-icon ui-c pi pi-trash']");
    By alertDeleteObjLocator = By.cssSelector(".ui-confirm-dialog");
    By confirmDeleteObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Si']");
    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void objetivePage(String objetive, String description) throws InterruptedException {
        type(objetive, codObjectLocator);
        type(description, descriObjectLocator);
        click(confirmObjBtnLocator);
    }

    public String registerMessage() {
        // WaitforVisibleElement
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(messageRegister));
        // Se manda el elemento para obtener el texto
        return getText(messageRegister);

    }

    public boolean buscarObjetivo(String codigoObjetivo) {
        // Espera a que la tabla esté presente en la página
        if (buscarPosObjetivo(codigoObjetivo)>=0){
            return true;
        } else{
            return false;
        }

    }

    public int buscarPosObjetivo(String codigoObjetivo) {
        // Espera a que la tabla esté presente en la página
        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableObjetive));

        List<WebElement> filas = findElements(By.cssSelector("#tabla\\:j_idt602_data tr"));
        System.out.println("Cant filas: " + filas.size());
        if (filas.size() == 1 && filas.get(0).getText().contains("No se encontraron registros")) {
            // Si la tabla está vacía y muestra el mensaje "No se encontraron registros"
            System.out.println("La tabla está vacía. No se encontraron registros.");
            return 0;
        }

        for (WebElement fila : filas) {
            List<WebElement> celdas = fila.findElements(By.tagName("td"));

            if (celdas.size() >= 2) {  // Verifica si hay al menos 2 celdas (código y descripción)
                String codigo = getText(celdas.get(0));
                String descripcion = getText(celdas.get(1));

                if (codigo.equalsIgnoreCase(codigoObjetivo) || descripcion.equalsIgnoreCase(codigoObjetivo)) {
                    // Encontrar el objetivo en la tabla
                    System.out.println("Objetivo encontrado en la tabla: " + codigoObjetivo);
                    // Puedes agregar aquí cualquier acción adicional que desees realizar
                    return Integer.parseInt(fila.getAttribute("data-ri"));
                }
            }
        }

        return -1;
    }

    public void actualizarObjetivo (String codigoObjetivo, String newCod, String newDescription){

        int pos = buscarPosObjetivo(codigoObjetivo);
        List<WebElement> botonesEditar = findElements(tableEditObjetiveBtn);
        //presiona el botón para actualizar los datos
        botonesEditar.get(pos).click();
        type(newCod, newCodeLocator);
        type(newDescription, newDescriptionLocator);
        click(actualizarBtnLocator);
    }

    public void actualizarCancelObjetivo (String codigoObjetivo, String newCod, String newDescription){

        int pos = buscarPosObjetivo(codigoObjetivo);

        List<WebElement> botonesEditar = findElements(tableEditObjetiveBtn);
        //presiona el botón para actualizar los datos
        botonesEditar.get(pos).click();
        type(newCod, newCodeLocator);
        type(newDescription, newDescriptionLocator);
        click(cancelarActualizarLocator);

    }

    public void eliminarObjetivo (String codigoObjetivo){
        int pos = buscarPosObjetivo(codigoObjetivo);
        List<WebElement> botonesEliminar = findElements(eliminarObjetivoLocator);
        //presiona el botón para actualizar los datos
        botonesEliminar.get(pos).click();
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(alertDeleteObjLocator));
        click(confirmDeleteObjLocator);

    }

    // Eliminar ui-button-icon-left ui-icon ui-c pi pi-trash
    // Modal Eliminar Div class ui-confirm-dialog ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container
    // span class ui-confirm-dialog-message 'Está seguro de eliminar este registro'
    // NO <span class="ui-button-text ui-c">No</span>
    // SI <span class="ui-button-text ui-c">Si</span>
    // X <span class="ui-icon ui-icon-closethick"></span>

    // Mensajes fallidos "Ocurrio un error inesperado en el sistema"

}



