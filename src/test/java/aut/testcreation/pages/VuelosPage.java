package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import static org.openqa.selenium.Keys.TAB;


public class VuelosPage extends SeleniumWrapper {
    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");
    By locatorOrigen = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@placeholder='Ciudad o aeropuerto' and @aria-label='Destino']");
    By locatorCalendario = By.xpath("//button[@aria-label='Fecha de ida']");
    By locatorFechaIda = By.xpath("//button[.='13']");
    By btnBuscar = By.xpath("//button[.='Buscar']");
    By btnVueloSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");
    By btnClickPrimerBusqueda = By.xpath("//div[@class='FullTransportPrices__SelectedPriceContainer-sc-1qck0l5-1 knGmgC']");
    By btnFlexible = By.xpath("//button[.='Elegir Flexible']");
    By locatorNombre = By.xpath("//input[@name='name']");
    By locatorApellido = By.xpath("//input[@name='surname']");
    By locatorEmail = By.xpath("//input[@data-testid='input-input' and @name='email']");
    By locatorTelefono = By.xpath("//input[@name='phone']");
    By checkBox = By.xpath("//span[@class= 'check']");
    By locatorPasajero = By.id("radio-groups.1.travellers.1.title-MALE-label");
    By locatorDiaNacimiento = By.xpath("//input[@data-testid='input-input' and @maxlength='2']");
    By locatorMesNacimiento = By.xpath("//span[contains(text(), 'Mes')]");
    By locatorAnioNacimiento = By.xpath("//input[@data-testid='input-input' and @maxlength='4']");
    By btnSiguiente = By.xpath("//button[contains(text(),'Siguiente')]");
    By btnNoElegirAsiento = By.xpath("//button[contains(text(),'Continuar sin elegir asiento')]");
    By locatorTitular = By.xpath("//input[@name='creditCard.cardHolder']");
    By locatorNumTarjeta = By.xpath("//input[@name='creditCard.cardNumber']");
    By locatorFechaVencimientoMM = By.xpath("//input[@name='creditCard.expirationDate' and @placeholder='MM']");
    By locatorFechaVencimientoAA = By.xpath("//input[@name='creditCard.expirationDate' and @placeholder='AA']");
    By locatorCVV = By.xpath("//input[@name='creditCard.cvv']");
    By btnReservar = By.xpath("//span[ @class='submit__button-label']");
    By btnTranferencia = By.xpath("//label[@id='radio-paymentGroups-trustly-label']");
    By btnContinuarSinFullFlex = By.xpath("//p[.='Continuar sin FullFlex']");
    By locatorHoteles = By.xpath("//a[@title='Hoteles']");


    public void cerrarCookies() {
        click(locatorCerrarCookies);
    }

    public void completarOrigen(String origen) throws InterruptedException {

        WebElement elementoCampoOrigen = driver.findElement(locatorOrigen);

        elementoCampoOrigen.clear();
        Thread.sleep(2000);
        click(elementoCampoOrigen);
        Thread.sleep(2000);
        write(origen, locatorOrigen);
    }

    public void completarDestino(String destino) throws InterruptedException {

        WebElement elementoCampoDestino = driver.findElement(locatorDestino);

        elementoCampoDestino.clear();
        Thread.sleep(2000);
        click(elementoCampoDestino);
        Thread.sleep(2000);
        write(destino, locatorDestino);
        Thread.sleep(2000);
    }

    public void ingresarFechaIda() throws InterruptedException {
        click(locatorCalendario);
        Thread.sleep(2000);
        click(locatorFechaIda);
    }

    public void realizarBusqueda(){
        click(btnBuscar);
    }
    public void clickSoloIda() {
        click(btnVueloSoloIda);
    }
    public void clickPrimerBusqueda (){
        click(btnClickPrimerBusqueda);
    }
    public void clickElegirFlexible(){
        click(btnFlexible);
    }
    public void clickSiguiente(){
        click(btnSiguiente);
    }
    public void completarDatosContacto(String nombre, String apellido, String email, String telefono) throws InterruptedException {
        WebElement elementoNombre = driver.findElement(locatorNombre);
        WebElement elementoApellido = driver.findElement(locatorApellido);
        WebElement elementoEmail = driver.findElement(locatorEmail);
        WebElement elementoTelefono = driver.findElement(locatorTelefono);

        click(elementoNombre);
        Thread.sleep(2000);
        write(nombre, locatorNombre);
        Thread.sleep(2000);

        click(elementoApellido);
        Thread.sleep(2000);
        write(apellido, locatorApellido);
        Thread.sleep(1000);

        click(elementoEmail);
        Thread.sleep(3000);
        write(email, locatorEmail);
        Thread.sleep(2000);

        click(elementoTelefono);
        Thread.sleep(1000);
        write(telefono, locatorTelefono);
        Thread.sleep(1000);
    }

    public void seleccionGenero (boolean deseaSerLlamadoSr) {
        scrolling(locatorPasajero);
        List<WebElement> checks = findElements(checkBox);
        if (deseaSerLlamadoSr) {
            checks.get(1).click();
        } else {
            checks.get(2).click();
        }
    }

    public void fechaNacimiento(String dia, int mes, String annio) throws InterruptedException {

        write(dia, locatorDiaNacimiento);
        Thread.sleep(3000);

        click(locatorMesNacimiento);
        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root')]"));
        list.get((mes)-1).click();

        Thread.sleep(3000);
        write(annio, locatorAnioNacimiento);
    }

    public void checksEquipaje(boolean deseaProtegerSuEquipaje, boolean deseaAsistenciaEspecial) {
        List<WebElement> checks = findElements(checkBox);
        scrolling(btnSiguiente);
        if (deseaProtegerSuEquipaje) {
            checks.get(3).click();
        }
        if (deseaAsistenciaEspecial) {
            checks.get(4).click();
        }
    }

    public void clickContinuarSinAsiento (){
        click(btnNoElegirAsiento);
    }

    public void completarDatosTarjeta(String titular, String numTarjeta, String vencMM, String vencAA, String cvv) throws InterruptedException {
        write(titular, locatorTitular);
        Thread.sleep(3000);
        write(numTarjeta, locatorNumTarjeta);
        Thread.sleep(3000);
        write(vencMM, locatorFechaVencimientoMM);
        Thread.sleep(3000);
        write(vencAA,locatorFechaVencimientoAA);
        Thread.sleep(3000);
        write(cvv,locatorCVV);
    }

    public void checkTranferenciaBancaria() {
        click(btnTranferencia);
    }

    public void clickBtnReservar (){
        click(btnReservar);
    }

    public void clickSinFullFlex (){
        click(btnContinuarSinFullFlex);
    }

    public void esperarXSegundos ( int segundos){
        try {
            driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void irAHoteles(){
        click(locatorHoteles);
        esperarXSegundos(3);
    }

    }






