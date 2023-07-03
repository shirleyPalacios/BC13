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
    // By origenVuelos= By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");

    // By destinoVuelos = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");

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


    public void completarFormularioBusqueda(String origen) {


        WebElement elementoCampoOrigen = driver.findElement(campoOrigen);
        // WebElement elementoCampoDestino = driver.findElement(campoDestino);


        if (!elementoCampoOrigen.getAttribute("value").isEmpty()) {
            click(elementoCampoOrigen);
            write(esperarPorElemento(campoOrigen),origen);
        } else {
            elementoCampoOrigen.clear();
            click(elementoCampoOrigen);
            write(String.valueOf(esperarPorElemento(campoOrigen)),origen);
        }
    }


}











