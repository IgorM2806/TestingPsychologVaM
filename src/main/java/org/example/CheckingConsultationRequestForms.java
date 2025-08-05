package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckingConsultationRequestForms {
    private WebDriver driver;

    @BeforeMethod
    public void SeTup(){
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\User\\distr\\psychologVaM\\" +
                "TestingPsychologVaM_2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://psycholog-vam.ru/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void CheckingConsultationRequestForms() throws InterruptedException {
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", wb_Text6Element);
        assert  wb_Text6Element.isDisplayed();
        WebElement consultationFormLabel =  driver.findElement(By.cssSelector("#consultationForm label"));
        WebElement formNameElement = driver.findElement(By.cssSelector("#formName"));
        WebElement formLabel2Element = driver.findElement(By.cssSelector("#formLabel2"));
        WebElement formEmailElement = driver.findElement(By.cssSelector("#formEmail"));
        WebElement formLabel4Element = driver.findElement(By.cssSelector("#formLabel4"));
        WebElement formMessageElement = driver.findElement(By.cssSelector("#formMessage"));
        assertEquals("Значение в поле 'Имя' не соответствует ожиданию!", consultationFormLabel.getText(),
                "Имя");
        String forNameValue = formNameElement.getAttribute("placeholder");
        assertEquals("Значение поля 'placeholder' для поля ввода 'Имя' не соответствует ожиданию!",
                forNameValue, "Введите своё имя");
        assertEquals("Значение в поле 'Email' не соответствует ожиданию!", formLabel2Element.getText(),
                "Email");
        String forEmailValue = formEmailElement.getAttribute("placeholder");
        assertEquals("Значение поля 'placeholder' для поля ввода 'Email' не соответствует ожиданию!",
                forEmailValue, "Введите адрес электронной почты");
        assertEquals("Название поля 'formLabel4' не соответствует ожиданию!", formLabel4Element.getText(),
                "Сообщение");
        String forMessageValue = formMessageElement.getAttribute("placeholder");
        assertEquals("Значение поля 'placeholder' для поля ввода 'Сообщение' не соответствует ожиданию!",
                forMessageValue, "Введите сообщение - не более 255 символов");
        System.out.println("Tests for CheckingConsultationRequestForms(): completed successfully!");
    }

}
