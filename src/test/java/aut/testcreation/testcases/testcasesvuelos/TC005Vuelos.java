package aut.testcreation.testcases.testcasesvuelos;
import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TC005Vuelos {
    private VuelosPage vuelosPage;
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeEach
    public void preTests() {
        WebDriverManager.chromedriver().setup(); //setear el driver
        driver = new ChromeDriver();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.navigateTo("https://www.rumbo.es/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void postTests() {

        driver.close();
    }

    @SneakyThrows
    @Test

    public void TC0005_CompraPasaje_TarjetaCredito_datosInvalidos() {
        vuelosPage.cerrarCookies();
        vuelosPage.clickSoloIda();
        Thread.sleep(3000);
        vuelosPage.completarOrigen("Sao Paulo (SAO) - Todos los aeropuertos, Brasil");
        Thread.sleep(3000);
        vuelosPage.completarDestino("Barcelona (BCN) - Todos los aeropuertos, España");
        Thread.sleep(3000);
        vuelosPage.ingresarFechaIda();
        Thread.sleep(3000);
        vuelosPage.realizarBusqueda();
        Thread.sleep(3000);
        vuelosPage.clickPrimerBusqueda();
        Thread.sleep(3000);
        vuelosPage.clickElegirFlexible();
        Thread.sleep(3000);
        vuelosPage.completarDatosContacto("Belen", "Celada", "cynthiacelada2016@gmail.com", "432342");
        Thread.sleep(3000);
        vuelosPage.seleccionGenero(false);
        Thread.sleep(3000);
        vuelosPage.fechaNacimiento("23", 3,"2000");
        Thread.sleep(3000);
        vuelosPage.checksEquipaje(true, false);
        vuelosPage.clickSiguiente();
        Thread.sleep(1000);
        vuelosPage.clickSiguiente();
        Thread.sleep(1000);
        vuelosPage.clickContinuarSinAsiento();
        Thread.sleep(1000);
        vuelosPage.completarDatosTarjeta("Rodriguez Rocio", "3287 8987 3089 7893 789", "09", "25","934");
        Thread.sleep(1000);
        vuelosPage.clickBtnReservar();

    }

}

//roro
