package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    By origenVuelos = By.xpath("//fieldset[@class='d-qv20lr']/div[.='Origen']");
    By destinoVuelos = By.xpath("//fieldset[@class='d-qv20lr']/div[.='Destino']");
    By fechaIdaVuelos = By.xpath("");
    By fechaVueltaVuelos = By.xpath("");
    By pasajeroVuelos = By.xpath("");
    By btnBuscar = By.xpath("//button[.='Buscar']");

    By btnTrenes = By.xpath("");

    By btnHoteles = By.xpath("");




    //métodos

    public void irATrenes() {
        click(esperarPorElemento(btnTrenes));
    }
    public void irAHoteles() {
        click(esperarPorElemento(btnHoteles));
    }


}
