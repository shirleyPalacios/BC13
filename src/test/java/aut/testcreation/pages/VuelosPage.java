package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    //locators


    By campoOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By campoDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");


    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");


    By vuelosBtnIdaVuelta = By.xpath("//div[contains(text(),'Ida y vuelta')]");
    By vuelosBtnSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");  //
    By vuelosBtnMultidestino = By.xpath("//a[contains(text(),'Multidestino')]"); //
    By btnClase = By.xpath("//button[.='Cualquier clase']");
    By btnMetodoMasEco = By.xpath("//a[contains(text(),'Multidestino')]");


    By fechaIdaVuelos = By.xpath("");
    By fechaVueltaVuelos = By.xpath("");
    By pasajeroVuelos = By.xpath("");
    By btnBuscar = By.xpath("//button[.='Buscar']");

    By btnTrenes = By.xpath("");

    By btnHoteles = By.xpath("");


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
            write(origen,campoDestino);

        }
    }





}











