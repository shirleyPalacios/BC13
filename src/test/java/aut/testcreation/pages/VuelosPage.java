package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

//locators


    By campoOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By campoDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");
    By selectorCalendario = By.xpath("//button[@aria-label='Fecha de ida']");
    By selectorCalendario2 = By.xpath("//button[@aria-label='Fecha de vuelta' and @class= 'd-1ol7ckz']");
    By selectorFechaIda = By.xpath("//button[.='15']");
    By selectorFechaVuelta = By.xpath("//button[.='20']");
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
        }
    }

    public void ingresarFechaIda() {
        click(selectorCalendario);
        click(selectorFechaIda);
    }

    public void ingresarFechaVuelta() {
        click(selectorCalendario2);
        click(selectorFechaVuelta);
    }

}

