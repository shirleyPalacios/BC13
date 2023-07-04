package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;


public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By btnLimpiar = By.xpath("//button[@class='d-1nmp0nm ed5mks90']");
    By locatorOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");
    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");
    By locatorPasajeros = By.xpath("");
    By locatorCalendario = By.xpath("//button[@aria-label='Fecha de ida']");
    By locatorFechaIda = By.xpath("//button[.='10']");
    By locatorFechaVuelta = By.xpath("//button[.='19']");
    By btnBuscar = By.xpath("//button[.='Buscar']");


//métodos
/*public void limpiarCampos(boolean deseaBorrarOrigen, boolean deseaBorrarDestino) {
        List<WebElement> limpiar = findElements(btnLimpiar);
        if (deseaBorrarOrigen) {
            limpiar.get(0).click();
        }
        if (deseaBorrarDestino) {
            limpiar.get(1).click();
        }
    }
public void agregarOrigen(String origen) throws InterruptedException {
    click(locatorOrigen);
    write(origen, locatorOrigen);
    Thread.sleep(1500);
    sendKeys(DOWN, locatorOrigen);
    Thread.sleep(1500);
    sendKeys(ENTER, locatorOrigen);
    click(locatorOrigen);
}

    public void agregarDestino(String destino) throws InterruptedException {
        click(locatorDestino);
        write(destino, locatorDestino);
        Thread.sleep(1500);
        sendKeys(DOWN, locatorDestino);
        Thread.sleep(1500);
        sendKeys(ENTER, locatorDestino);
        Thread.sleep(1500);
        click(locatorDestino);
    }*/

    /*public void completarOrigenDestino(String origen, String destino) {

        WebElement elementoCampoOrigen = driver.findElement(locatorOrigen);
        WebElement elementoCampoDestino = driver.findElement(locatorDestino);

        if (elementoCampoOrigen.getAttribute("value").isEmpty()) {
            click(elementoCampoOrigen);
            write(origen, locatorOrigen);
            write(destino, locatorDestino);
        } else {
            elementoCampoOrigen.clear();
            elementoCampoDestino.clear();

            click(elementoCampoOrigen);
            write(origen, locatorOrigen);

            click(elementoCampoDestino);
            write(destino, locatorDestino);
        }
    }*/
    public void completarOrigen(String origen) throws InterruptedException {

        WebElement elementoCampoOrigen = driver.findElement(locatorOrigen);

        elementoCampoOrigen.clear();
        Thread.sleep(1500);
        click(elementoCampoOrigen);
        Thread.sleep(1500);
        write(origen,locatorOrigen);
    }


    public void completarDestino (String destino) throws InterruptedException {
        WebElement elementoCampoDestino = driver.findElement(locatorDestino);

        elementoCampoDestino.clear();
        Thread.sleep(1500);
        click(elementoCampoDestino);
        Thread.sleep(1500);
        write(destino,locatorDestino);
        Thread.sleep(1500);
    }


    public void ingresarFechaIda() {
        click(locatorCalendario);
        click(locatorFechaIda);
        click(locatorFechaVuelta);
    }
    public void realizarBusqueda() {
        click(btnBuscar);
    }



}
