package framework.engine.selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumWrapper {
    public WebDriver driver;
    protected WebDriverWait espera; //nos ayuda a llevar una estructura de manejo de esperas de los elementos web, permite manejar las esperas

    public SeleniumWrapper(WebDriver driver){

        this.driver = driver;
    }

    public List<WebElement> findElements (By locator){

        return driver.findElements(locator);
    }

    public String getText(WebElement elemento) {

        return elemento.getText();
    }

    public void write(String inputText, By locator){

        driver.findElement(locator).sendKeys(inputText);
    }

    public void write(String inputText, WebElement elemento){

        elemento.sendKeys(inputText);
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

    public void navigateTo(String url){

        driver.navigate().to(url);
    }

    public WebElement esperarPorElemento(By locator){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebDriver getDriver() {

        return driver;
    }

    public void setDriver(WebDriver driver) {

        this.driver = driver;
    }

    public void scrolling(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void esperarXSegundos(int segundos){
        try {
            driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
