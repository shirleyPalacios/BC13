package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class TrenesPage extends SeleniumWrapper {
    public TrenesPage(WebDriver driver) {

        super(driver);

    }

//locators


    By locatorCerrarCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");
    By locatorOrigen = By.xpath("//input[@aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@aria-label='Destino']");
    By locatorCalendario = By.xpath("//label[.='Fecha de ida']");

//By.xpath("//label[.='Fecha de ida']");
    By locatorFechaIda = By.xpath("//button[.='22']");
    By locatorCalendario2 = By.xpath("//label[.='Fecha de vuelta']");
    By locatorFechaVuelta = By.xpath("//button[25]");
    By locatorPasajeros = By.xpath("//label[.='Pasajero']");
    By locatorAumentarPasajeros = By.xpath("//button[@aria-label='Aumentar el número de adultos']");
    By btnBuscar = By.xpath("//button[.='Buscar']");
    By btnVueloSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");
    By btnVueloIdaVuelta = By.xpath("//div[contains(text(),'Ida y vuelta')]");
    By locatorModificar = By.xpath("//span[@class='search-summary__section-icon search-summary__search-icon icon icon-edit']");
    By locatorFiltroMasBarato = By.xpath("//div[contains(text(),'Más barato']");
    By locatorBotonSeleccionBoleto = By.xpath("//span[contains(text(),'Modificar búsqueda']");
    By locatorNombre = By.xpath("//input[@name='name']");
    By locatorApellido = By.xpath("//input[@name='surname']");
    By locatorEmail = By.xpath("//input[@data-testid='input-input' and @name='email']");
    By locatorTelefono = By.xpath("//input[@name='phone']");
    By btnSiguiente = By.xpath("//button[contains(text(),'Siguiente')]");


//pasajero1
    By locatorSexo = By.xpath("//span[.='Sr.']");
    By locatorDiaNacimiento = By.xpath("//input[@data-testid='input-input' and @maxlength='2']");
    By locatorMesNacimiento = By.xpath("//span[contains(text(), 'Mes')]");
    By locatorAnioNacimiento = By.xpath("//input[@data-testid='input-input' and @maxlength='4']");

//tarjeta de credito

    By locatorTitularTarjeta= By.xpath("//input[@name='creditCard.cardHolder']");
    By locatorNumeroTarjeta= By.xpath("//input[@name='creditCard.cardNumber']");
    By locatorMesCaducidad= By.xpath("//input[@placeholder='MM']");
    By locatorAnoCaducidad= By.xpath("//input[@placeholder='AA']");
    By locatorTipoDocumento= By.xpath("//span[.='Pasaporte']");
    By locatorDni= By.xpath("//span[.='Introduce nº de documento']");

    public void cerrarCookies() {

        click(locatorCerrarCookies);

    }

    public void completarOrigen(String origen) throws InterruptedException {

        WebElement elementoCampoOrigen = driver.findElement(locatorOrigen);

        elementoCampoOrigen.clear();

        Thread.sleep(3000);

        click(elementoCampoOrigen);

        Thread.sleep(3000);

        write(origen, locatorOrigen);

    }

    public void completarDestino(String destino) throws InterruptedException {

        WebElement elementoCampoDestino = driver.findElement(locatorDestino);

        elementoCampoDestino.clear();

        Thread.sleep(3000);

        click(elementoCampoDestino);

        Thread.sleep(3000);

        write(destino, locatorDestino);

        Thread.sleep(3000);

    }

    public void ingresarFechaIda() throws InterruptedException {

        click(locatorCalendario);

        Thread.sleep(3000);

        click(locatorFechaIda);

    }

    public void ingresarFechaVuelta() throws InterruptedException {

        click(locatorCalendario2);

        Thread.sleep(3000);

        click(locatorFechaVuelta);

        Thread.sleep(3000);

    }

    public void realizarBusqueda() {

        esperarXSegundos (30);

        click(btnBuscar);

    }

    public void clickSoloIda() throws InterruptedException {

        Thread.sleep(2000);

        click(btnVueloSoloIda);

    }

    public void clickIdaVuelta() throws InterruptedException{

        Thread.sleep(3000);

        click(btnVueloIdaVuelta);

    }

    public void modificar () throws InterruptedException {

        Thread.sleep(3000);

        click(locatorModificar);
    }

    public void filtroMasBarato () throws InterruptedException {

        Thread.sleep(2000);

        click(locatorFiltroMasBarato);
    }


    public void seleccionarBoleto (int numeroResultado) throws InterruptedException {

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'FullTransportPrices__Payment')]"));

        list.get((numeroResultado)-1).click();

        Thread.sleep(3000);

    }

    public void seleccioarUnpasajero()throws InterruptedException {

        Thread.sleep(3000);

        click(locatorPasajeros);

        Thread.sleep(3000);

    }

    public void seleccionarDosPasajeros () throws InterruptedException {

        Thread.sleep(2000);

        click(locatorPasajeros);

        Thread.sleep(2000);

        click(locatorAumentarPasajeros);
    }

    public void completarContacto (String nombre,String apellido, String email, String telefono) throws InterruptedException {

        WebElement elementoNombre = driver.findElement(locatorNombre);

        WebElement elementoApellido = driver.findElement(locatorApellido);

        WebElement elementoEmail = driver.findElement(locatorEmail);

        WebElement elementoTelefono = driver.findElement(locatorTelefono);


        elementoNombre.clear();

        Thread.sleep(3000);

        click(elementoNombre);

        Thread.sleep(3000);

        write(nombre, locatorNombre);

        click(elementoApellido);

        Thread.sleep(2000);


        write(apellido, locatorApellido);

        Thread.sleep(2000);


        click(elementoEmail);

        Thread.sleep(3000);

        write(email, locatorEmail);

        Thread.sleep(2000);


        click(elementoTelefono);

        write(telefono, locatorTelefono);

        Thread.sleep(1000);


    }


    public void datosPasajero1 (String dia, int mes, String annio)throws InterruptedException{

        click(locatorSexo);

        Thread.sleep(3000);

        write(dia, locatorDiaNacimiento);

        Thread.sleep(3000);

        click(locatorMesNacimiento);

        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'MuiButtonBase-root')]"));

        list.get((mes)-1).click();

        Thread.sleep(3000);

        write(annio, locatorAnioNacimiento);

        Thread.sleep(3000);

        click(locatorTipoDocumento);

        Thread.sleep(3000);

        click(locatorDni);

        Thread.sleep(3000);

    }


    public void botonSiguiente()throws InterruptedException{


        Thread.sleep(3000);

        click(btnSiguiente);

    }

    public void completarTarjetaCredito (String titular,String numeroTarjeta,String mesCaducidad,String anoCaducidad)throws InterruptedException{

        WebElement elementoTitular = driver.findElement(locatorTitularTarjeta);

        WebElement elementoNumeroTarjeta = driver.findElement(locatorNumeroTarjeta);

        WebElement elementoMesCaducidad = driver.findElement(locatorMesCaducidad);

        WebElement elementoAnoCaducidad = driver.findElement(locatorAnoCaducidad);



        elementoTitular.clear();

        Thread.sleep(3000);

        click(elementoTitular);

        Thread.sleep(3000);

        write(titular, locatorTelefono);



        elementoNumeroTarjeta.clear();

        Thread.sleep(3000);

        click(elementoNumeroTarjeta);

        Thread.sleep(3000);

        write(numeroTarjeta, locatorNumeroTarjeta);


        elementoMesCaducidad.clear();

        Thread.sleep(3000);

        click(elementoMesCaducidad);

        Thread.sleep(3000);

        write(mesCaducidad, locatorMesCaducidad);


        elementoAnoCaducidad.clear();

        Thread.sleep(3000);

        click(elementoAnoCaducidad);

        Thread.sleep(3000);

        write(anoCaducidad, locatorAnoCaducidad);


    }


}
