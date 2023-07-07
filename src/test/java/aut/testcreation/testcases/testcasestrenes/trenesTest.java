package aut.testcreation.testcases.testcasestrenes;

import aut.testcreation.pages.HotelesPage;
import aut.testcreation.pages.TrenesPage;
import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class trenesTest {
    private VuelosPage vuelosPage;
    private TrenesPage trenesPage;
    private HotelesPage hotelesPage;
    private WebDriver driver;

    @BeforeEach
    public void preTests() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setear el driver
        driver = new ChromeDriver();
        vuelosPage = new VuelosPage(driver);
        trenesPage = new TrenesPage(vuelosPage.getDriver());
        hotelesPage = new HotelesPage(vuelosPage.getDriver());
        vuelosPage.navigateTo("https://www.rumbo.es/");
        Thread.sleep(1000);
        trenesPage.cerrarCookies();
        Thread.sleep(1000);
        trenesPage.navigateTo("https://www.rumbo.es/trenes/");

    }

    @AfterEach
    public void closeu(){trenesPage.getDriver().close();
    }

    @SneakyThrows
    @Test


    public void CP001_ModificarCantidadPasajeros () throws InterruptedException {
        trenesPage.clickSoloIda();
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        Thread.sleep(2000);
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.seleccioarUnpasajero();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(2000);
        trenesPage.modificar();
        Thread.sleep(2000);
        trenesPage.seleccionarDosPasajeros();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
    }
    @Test

    public void CP002_SeleccionarFiltroMasBarato () throws InterruptedException {
        trenesPage.clickSoloIda();
        Thread.sleep(2000);
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        Thread.sleep(2000);
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(2000);
        trenesPage.filtroMasBarato();
        Thread.sleep(2000);


    }

    @Test
    public void CP003_ReservaConNumerosNombreApellido () throws InterruptedException {
        trenesPage.clickSoloIda();
        Thread.sleep(2000);
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(6000);
        trenesPage.seleccionarBoleto(1);
        Thread.sleep(6000);
        trenesPage.completarContacto("Juan45","Rodriguez799","JuanRodriguez123@gmail.com","3803892540");
        Thread.sleep(3000);
        trenesPage.datosPasajero1("14",1,"1996");
        Thread.sleep(3000);
        trenesPage.botonSiguiente();
    }

    @Test
    public void CP004_BusquedaBoletoMenor () throws InterruptedException {
        trenesPage.clickSoloIda();
        Thread.sleep(2000);
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        Thread.sleep(2000);
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(5000);
        trenesPage.seleccionarBoleto(3);
        Thread.sleep(2000);
        trenesPage.completarContacto("Juan","Rodriguez","JuanRodriguez123@gmail.com","3803892540");
        Thread.sleep(2000);
        trenesPage.datosPasajero1("14",1,"2018");
        Thread.sleep(2000);
        trenesPage.botonSiguiente();

    }

    @Test
    public void CP005_BusquedaBoletosMovilidadReducida () throws InterruptedException {
        trenesPage.clickSoloIda();
        Thread.sleep(2000);
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        Thread.sleep(2000);
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(5000);
        trenesPage.seleccionarBoleto(3);
        Thread.sleep(2000);
        trenesPage.completarContacto("Juan","Rodriguez","JuanRodriguez123@gmail.com","3803892540");
        Thread.sleep(2000);
        trenesPage.datosPasajero1("14",1,"1996");
        Thread.sleep(2000);
        trenesPage.botonSiguiente();

    }


    @Test
    public void CP006_CompraBoletoConCuponDescuentoIncorrecto () throws InterruptedException {
        trenesPage.clickSoloIda();
        Thread.sleep(2000);
        trenesPage.completarOrigen("Barcelona");
        Thread.sleep(2000);
        trenesPage.completarDestino("Madrid");
        Thread.sleep(2000);
        trenesPage.ingresarFechaIda();
        Thread.sleep(2000);
        trenesPage.realizarBusqueda();
        Thread.sleep(5000);
        trenesPage.seleccionarBoleto(3);
        Thread.sleep(2000);
        trenesPage.completarContacto(
                "Juan",
                "Rodriguez",
                "JuanRodriguez123@gmail.com",
                "3803892540");
        Thread.sleep(2000);
        trenesPage.datosPasajero1("14",1,"1996");
        Thread.sleep(2000);
        trenesPage.botonSiguiente();
        Thread.sleep(2000);
        trenesPage.completarTarjetaCredito("Juan Rodriguez","5258 5517 8032 8076 ","03","28");



    }


}
