package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    //locators


    By campoOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By campoDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");

    By selectorCalendarioIda = By.xpath("//button[@aria-label='Fecha de ida']");
    By selectorFechaIda = By.xpath("//button[.='15']");

    By selectorCalendarioVuelta = By.xpath("//button[@aria-label='Fecha de vuelta']");

    By selectorFechaVuelta = By.xpath("//button[.='26']");



    //métodos


    public void completarOrigenDestino (String origen, String destino) {


        WebElement elementoCampoOrigen = driver.findElement(campoOrigen);
        WebElement elementoCampoDestino = driver.findElement(campoDestino);


        if (!elementoCampoOrigen.getAttribute("value").isEmpty()) {
            click(elementoCampoOrigen);
            write(origen,campoOrigen);
            write(destino,campoDestino);
        } else {
            elementoCampoOrigen.clear();
            elementoCampoDestino.clear();
            click(elementoCampoOrigen);
            write(origen,campoOrigen);
            click(elementoCampoDestino);
            write(destino,campoDestino);

        }
    }

    public void ingresarFechaIda() {
        click(selectorCalendarioIda);
        click(selectorFechaIda);
    }

    public void ingresarFechaVuelta() {
        click(selectorCalendarioVuelta);
        click(selectorFechaVuelta);
    }


 }











