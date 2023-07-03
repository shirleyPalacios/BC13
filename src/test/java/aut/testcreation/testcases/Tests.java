package aut.testcreation.testcases;

import aut.testcreation.pages.HotelesPage;
import aut.testcreation.pages.TrenesPage;
import aut.testcreation.pages.VuelosPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    /*public void CP001_formulario_incorrecto_mail_vacio(){
        //ejemplo de test
        Assertions.assertEquals("...", ...);
    }*/

  //public void CP001_hoteles_() {
      //vuelosPage.cerrarCookies();
     // vuelosPage.completarFormularioBusqueda("Brasil", "Buenos Aires", "jue, 27 jul", "lun, 7 ago");
      //hotelesPage.completarFormularioRegistro(); //aca se le pasan todos los datos para completar el registro segun los tipos de datos
     // Assertions.assertEquals("", hotelesPage.obtenerErrorMailVacio());
    }
}