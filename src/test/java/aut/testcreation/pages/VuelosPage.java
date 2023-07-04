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

    By selectorCalendario = By.xpath("//button[@aria-label='Fecha de ida']");
    By selectorCalendario2 = By.xpath("//button[@aria-label='Fecha de vuelta' and @class= 'd-1ol7ckz']");
    By selectorFechaIda = By.xpath("//button[.='15']");
    By selectorFechaVuelta = By.xpath("//button[.='20']");





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
        click(selectorCalendario);
        click(selectorFechaIda);
    }

    public void ingresarFechaVuelta() {
        click(selectorCalendario2);
        click(selectorFechaVuelta);
    }




}

