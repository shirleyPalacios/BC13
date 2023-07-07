package aut.testcreation.testcases;

import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Tests {

    //esta clase tiene que llamar a las Pages
    private VuelosPage vuelosPage;
    private TrenesPage trenesPage;
    private HotelesPage hotelesPage;

    //instanciar el driver
    private WebDriver driver;

    @BeforeEach
    public void preTests() {
        WebDriverManager.chromedriver().setup(); //setear el driver
        driver = new ChromeDriver();
        vuelosPage = new VuelosPage(driver);
        trenesPage = new TrenesPage(vuelosPage.getDriver());
        hotelesPage = new HotelesPage(vuelosPage.getDriver());
        vuelosPage.navigateTo("https://www.rumbo.es/");
    }

    @AfterEach
    public void postTests() {

    }

    @SneakyThrows
    @Test
/*public void CP001_formulario_incorrecto_mail_vacio(){
//ejemplo de test
Assertions.assertEquals("...", ...);
}*/

    public void CP001_hoteles_formulario_incorrecto_mail_vacio() {
        driver.findElement(By.xpath("//button[contains(text(),'Rechazar todo')]")).click();
        vuelosPage.completarOrigen("Sao Paulo (SAO) - Todos los aeropuertos, Brasil");
       // Thread.sleep(1500);
        vuelosPage.completarDestino("Barcelona (BCN) - Todos los aeropuertos, España");
        Thread.sleep(1500);
      //  vuelosPage.completarOrigenDestino("Sao Paulo (SAO), Brasil", "Montevideo (MVD) - Carrasco, Uruguay");
        //vuelosPage.limpiarCampos(true, false);
       // vuelosPage.agregarOrigen("Santiago (SCL)");
       // vuelosPage.agregarDestino("Buenos Aires (BUE)");
        vuelosPage.ingresarFechaIda();
        Thread.sleep(1500);
        vuelosPage.realizarBusqueda();
    }
}