package aut.testcreation.testcases.testcasesvuelos;

import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC002Vuelos {
    private VuelosPage vuelosPage;
    private WebDriver driver;

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

    public void TC0002_BusquedaDeVuelosSinResultados() {
        vuelosPage.cerrarCookies();
        vuelosPage.esperarXSegundos(3);
        vuelosPage.clickSoloIda();
        vuelosPage.esperarXSegundos(3);
        vuelosPage.completarOrigen("Sao Paulo (SAO) - Todos los aeropuertos, Brasil");
        vuelosPage.esperarXSegundos(3);
        vuelosPage.ingresarFechaIda();
        vuelosPage.esperarXSegundos(3);
        vuelosPage.realizarBusqueda();
    }
}

//roro