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
    By vuelosBtnIdaVuelta = By.xpath("//div[contains(text(),'Ida y vuelta')]");
    By vuelosBtnSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");
    By vuelosBtnMultidestino = By.xpath("//a[contains(text(),'Multidestino')]");
    By btnClase = By.xpath("//button[.='Cualquier clase']");
    By btnMetodoMasEco = By.xpath("//a[contains(text(),'Multidestino')]");

    By origenVuelos = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By destinoVuelos = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");

    By fechaIdaVuelos = By.xpath("//button[@aria-label='Fecha de ida']");
    By fechaVueltaVuelos = By.xpath("//button[@aria-label='Fecha de vuelta']");
    By pasajeroVuelos = By.xpath("");
    By btnBuscar = By.xpath("//button[.='Buscar']");

    By btnTrenes = By.xpath("");

    By btnHoteles = By.xpath("");
    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");


    //métodos

    public void irATrenes() {
        click(esperarPorElemento(btnTrenes));
    }

    public void irAHoteles() {
        click(esperarPorElemento(btnHoteles));
    }


    public void cerrarCookies(){
        click(esperarPorElemento(locatorCerrarCookies));
    }
}
