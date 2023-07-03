package framework.engine.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumWrapper {

    public WebDriver driver;

    protected WebDriverWait espera; //nos ayuda a llevar una estructura de manejo de esperas de los elementos web, permite manejar las esperas

    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }

    //Wrappers Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    //metodo write: se utiliza para encontrar un elemento de la interfaz de usuario utilizando un locator y luego ingresar o escribir un texto específico en ese elemento
    public void write(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void write(String inputText, WebElement elemento){
        elemento.sendKeys(inputText);
    }

    // metodo sendKeyw: se utiliza para encontrar un elemento de la interfaz de usuario utilizando un locator y luego enviar una tecla específica al elemento
    public void sendKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public String getUrlTitle(){
        return driver.getTitle();
    }

    public WebElement esperarPorElemento(By localizador) {
        espera = new WebDriverWait(this.driver, 30);//se crea el objeto espera y lo instancio a traves de la clase WebDriverWait, la clase recibe el driver como parametro y una unidad de tiempo
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void seleccionarComboBoxPorTextoVisible(By localizador,String textoVisible) {
        WebElement fechaViaje = driver.findElement(localizador);
        Select fecha = new Select(fechaViaje);
        fecha.selectByVisibleText(textoVisible);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
