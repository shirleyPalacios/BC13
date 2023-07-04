package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By locatorOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");

    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");

    By locatorPasajeros = By.xpath("");
    By locatorBtnBuscar = By.xpath("//button[.='Buscar']");

    By locatorCalendario = By.xpath("//button[@aria-label='Fecha de ida']");

    By locatorFechaIda = By.xpath("//button[.='10']");

    By locatorFechaVuelta = By.xpath("//button[.='19']");



    //métodos

    public void completarOrigenDestino(String origen, String destino) {

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
    }

    public void ingresarFechaIda() {
        click(locatorCalendario);
        click(locatorFechaIda);
        click(locatorFechaVuelta);
    }




}











