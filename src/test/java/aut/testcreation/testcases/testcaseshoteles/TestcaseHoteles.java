package aut.testcreation.testcases.testcaseshoteles;

import aut.testcreation.pages.HotelesPage;
import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestcaseHoteles {

    //esta clase tiene que llamar a las Pages
    private VuelosPage vuelosPage;
    private HotelesPage hotelesPage;

    //instanciar el driver
    private WebDriver driver;

    @BeforeEach
    public void preTests() {
        WebDriverManager.chromedriver().setup(); //setear el driver
        driver = new ChromeDriver();
        vuelosPage = new VuelosPage(driver);
        hotelesPage = new HotelesPage(vuelosPage.getDriver());
        vuelosPage.navigateTo("https://www.rumbo.es/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void postTests() {
        driver.close();
    }

    @Test
    public void CP001_busqueda_hotel_sinAlojamiento() throws InterruptedException {
        vuelosPage.cerrarCookies();
        vuelosPage.irAHoteles();
        hotelesPage.ingresarFechas(8, 15,8,19);
        hotelesPage.realizarBusqueda();
        String resultadoEsperado = "Introduce, por ejemplo, una ciudad, una isla, una región...";
        Assertions.assertEquals(resultadoEsperado, hotelesPage.obtenerErrorDestinoVacio());
    }

    @Test
    public void CP002_busqueda_aplicar_filtro_precio() throws InterruptedException {
        vuelosPage.cerrarCookies();
        vuelosPage.irAHoteles();
        hotelesPage.completaLugarAlojamiento("Madrid, España", 3);
        hotelesPage.ingresarFechas(8, 15,8,19);
        hotelesPage.realizarBusqueda();
        hotelesPage.clickearVerLista();
        hotelesPage.clickearFiltroPrecio();
    }

    @Test
    public void CP003_busqueda_hoteles_aplicar_filtros() throws InterruptedException {
        vuelosPage.cerrarCookies();
        vuelosPage.irAHoteles();
        hotelesPage.completaLugarAlojamiento("Madrid, España", 3);
        hotelesPage.ingresarFechas(8, 15,8,19);
        hotelesPage.realizarBusqueda();
        hotelesPage.clickearVerLista();
        hotelesPage.aplicarFiltros();
        hotelesPage.hacerScrollHastaBoton();
        hotelesPage.limpiarFiltros();
    }

    @Test
    public void CP004_busqueda_hoteles_modificar_huespedes() throws InterruptedException {
        vuelosPage.cerrarCookies();
        vuelosPage.irAHoteles();
        hotelesPage.completaLugarAlojamiento("Madrid, España", 3);
        hotelesPage.ingresarFechas(8, 15,8,20);
        hotelesPage.realizarBusqueda();
        hotelesPage.seleccionarResultado(2);
        hotelesPage.modificarDatosBusqueda();
    }
}

