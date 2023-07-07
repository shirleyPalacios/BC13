package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelesPage extends SeleniumWrapper {
    public HotelesPage(WebDriver driver) {
        super(driver);
    }

    private VuelosPage vuelosPage;

    //locators
    By locatorLugarDestino = By.xpath("//input[@placeholder='¿Adónde quieres ir?']");
    By locatorCalendarioHoteles = By.xpath("//button[@aria-label='Fecha de entrada']");
    By locatorErrorDestinoIncompleto = By.xpath("//span[@role='alert']");
    By locatorVerLista = By.xpath("//button[.='Ver lista']");
    By locatorFiltroXPrecio = By.xpath("//div[.='Precio (más bajo primero)']");
    By locatorFiltroHotel = By.id("exp_elem_accomodation_type_1");
    By locatorFiltro4Estrellas = By.id("exp_elem_hotel_stars_4");
    By locatorFiltroValoracionExcelente = By.id("exp_elem_rating_excellent");
    By locatorFiltroWifiGratis = By.id("exp_elem_accomodation_facilities_0");
    By locatorLimpiarFiltros = By.xpath("//button[.='Limpiar todos']");
    By locatorMapa = By.id("view-mode");
    By locatorModificarDatosBusqueda = By.xpath("//span[contains(text(),'Modificar')]");
    By btnBuscar = By.xpath("//button[.='Buscar']");
    By locatorCalendarioDesplegado = By.xpath("//button[.='Calendario']");
    By locatorModificadorHuespedes = By.xpath("//div[contains(@class, 'Dropdown-styled-Dropdown')]");
    By locatorSumarHuespedes = By.xpath("//button[@aria-label='Aumentar el número de adultos']");


//métodos

    public void completaLugarAlojamiento(String lugarDestino, int numeroResultado) throws InterruptedException {

        WebElement elementoCampoOrigen = driver.findElement(locatorLugarDestino);

        elementoCampoOrigen.clear();
        esperarXSegundos(5);
        click(elementoCampoOrigen);
        esperarXSegundos(3);
        write(lugarDestino, locatorLugarDestino);
        esperarXSegundos(3);
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'option')]"));
        list.get((numeroResultado)-1).click();
        esperarXSegundos(3);
    }

    public void ingresarFechas(int mesEntrada, int diaEntrada, int mesSalida, int diaSalida) throws InterruptedException {
        mesEntrada = mesEntrada-1;
        mesSalida = mesSalida-1;
        WebElement fechasEntrada = driver.findElement(By.xpath("//div[@aria-labelledby='"+mesEntrada+"']//button[.='"+diaEntrada+"']"));
        WebElement fechasSalida = driver.findElement(By.xpath("//div[@aria-labelledby='"+mesSalida+"']//button[.='"+diaSalida+"']"));

        if (isDisplayed(locatorCalendarioDesplegado)){
            click(fechasEntrada);
            click(fechasSalida);
        }else{
            click(locatorCalendarioHoteles);
            click(fechasEntrada);
            click(fechasSalida);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

    }


    public String obtenerErrorDestinoVacio(){
        return getText(esperarPorElemento(locatorErrorDestinoIncompleto));
    }

    public void clickearVerLista(){
        click(locatorVerLista);
    }

    public void clickearFiltroPrecio(){
        click(locatorFiltroXPrecio);
    }

    public void hacerScrollHastaBoton(){
        scrolling(locatorMapa);
    }

    public void aplicarFiltros() throws InterruptedException {
        click(locatorFiltroHotel);
        click(locatorFiltro4Estrellas);
        Thread.sleep(2000);
        click(locatorFiltroValoracionExcelente);
        Thread.sleep(5000);
        click(locatorFiltroWifiGratis);
    }

    public void limpiarFiltros(){
        click(locatorLimpiarFiltros);
        esperarXSegundos(3);
    }

    public void seleccionarResultado(int numeroResultado){
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'card-gallery')]"));
        list.get((numeroResultado)-1).click();
        esperarXSegundos(6);
    }

    public void modificarDatosBusqueda() throws InterruptedException {
        Thread.sleep(20000);
        click(locatorModificarDatosBusqueda);
        click(locatorModificadorHuespedes);
        esperarXSegundos(10);
        click(locatorSumarHuespedes);
    }

    public void realizarBusqueda() throws InterruptedException {
        click(btnBuscar);
    }
}
