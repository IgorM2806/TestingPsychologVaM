package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    private String baseUrl;
    protected BasePages basePages;

    public BaseTest(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        basePages = new BasePages(driver);
    }

    @AfterEach
    public void tearDown() {
        if(driver != null){
            driver.quit();           // Безопасное завершение драйвера
        }
    }

    protected WebElement waitForElement(final By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickingElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void insertingValueIntoFieldName(By locator, String value) {
        WebElement element = waitForElement(locator, 3);
        element.sendKeys(value);
    }

    protected void insertingValueIntoFieldEmail(By locator, String value) {
        WebElement element = waitForElement(locator, 3);
        element.sendKeys(value);
    }

    protected void insertingValueIntoFieldMessage(By locator, String value) {
        WebElement element = waitForElement(locator, 3);
        element.sendKeys(value);
    }

    protected void clickingValueIntoFieldCheckbox(By locator) {
        WebElement element = waitForElement(locator, 3);
        element.click();
    }

    protected String getTextAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return  alert.getText();
    }
}
