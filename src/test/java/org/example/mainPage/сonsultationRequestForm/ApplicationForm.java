package org.example.mainPage.сonsultationRequestForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.BasePages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class ApplicationForm {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String baseUrl;
    protected BasePages basePages;
    private final By formNameLocator = By.cssSelector("#formName");
    private final By formEmailLocator = By.cssSelector("#formEmail");
    private final By formMessageLocator = By.cssSelector("#formMessage");
    private final By privacyConsentLocator = By.cssSelector("#privacyConsent");
    private final By privacyPolicyLocator = By.cssSelector("#privacyPolicy");
    private final By requestConsultationLocator = By.cssSelector("#wb_Text6");
    private final By buttonSendLocator = By.cssSelector("#formButton");

    public ApplicationForm(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
        driver.manage().window().maximize();
        basePages = new BasePages(driver);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void insertingValueIntoFieldName(String name) {
        WebElement element = driver.findElement(formNameLocator);
        element.sendKeys(name);
    }

    public void insertingValueIntoFieldEmail(String email) {
        WebElement element = driver.findElement(formEmailLocator);
        element.sendKeys(email);
    }

    public void insertingValueIntoFieldMessage(String message) {
        WebElement element = driver.findElement(formMessageLocator);
        element.sendKeys(message);
    }

    protected void clickingValueIntoFieldCheckbox() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(privacyConsentLocator));
        element.click();
    }

    protected void scrollToElementApplicationForm() {
        WebElement element = driver.findElement(requestConsultationLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickingElementButtonSend() {
        WebElement element = driver.findElement(buttonSendLocator);
        element.click();
    }

    protected String getTextAlertApplicationForm() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return  alert.getText();
    }

    protected void closingAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    protected void sendingApplicationForm(String name, String email, String message) {
        scrollToElementApplicationForm();
        insertingValueIntoFieldName(name);
        insertingValueIntoFieldEmail(email);
        insertingValueIntoFieldMessage(message);
        clickingValueIntoFieldCheckbox();
        clickingElementButtonSend();
    }
}
