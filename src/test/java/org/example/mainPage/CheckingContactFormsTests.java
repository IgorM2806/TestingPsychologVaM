package org.example.mainPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка отображения информации в разделе 'контакты'.")
public class CheckingContactFormsTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingContactFormsTests.class);

    public CheckingContactFormsTests(){
        super("https://psycholog-vam.ru/");
    }


    @Test
    @Description("Проверка отображения информации в разделе 'контакты' на Главной странице.")
    @Step("В разделе 'Email' отображается валидная информация.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingCFMailElement() throws InterruptedException {
        logger.info("Starting test 'checkingCFMailElement()'.");
        WebElement wb_Text8 = basePages.findElement(By.cssSelector("#wb_Text8"));
        scrollToElement(wb_Text8);
        WebElement mailelement =  driver.findElement(By.cssSelector("#formListView li:first-child p"));

        try {
            assertEquals("vlada.magnich@yandex.ru", mailelement.getText(),
                    "Значение в поле Mail не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFMailElement()': completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingCFMailElement()' завершился с ошибкой!", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Контакты' на Главной странице.")
    @Step("В разделе 'Позвони мне' отображается валидная информация! ")
    @Severity(SeverityLevel.NORMAL)
    public void checkingCFCallMe() throws InterruptedException {
        logger.info("Starting test 'checkingCFCallMe()'.");
        WebElement wb_Text8 = basePages.findElement(By.cssSelector("#wb_Text8"));
        scrollToElement(wb_Text8);
        WebElement callMe = basePages.findElement(By.cssSelector("#formListView li:nth-child(2) p"));
        try {
            assertEquals("+7 903 344 89 75", callMe.getText(),
                    "Значение в поле 'Позвони мне' не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFCallMe()': completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingCFCallMe()' завершился с ошибкой!", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Контакты' на Главной странице.")
    @Step("В разделе 'Расположение' отображается валидная информация!")
    @Severity(SeverityLevel.NORMAL)
    public void checkingCFLocation() throws InterruptedException {
        logger.info("Starting test 'checkingCFLocation()'.");
        WebElement wb_Text8 = basePages.findElement(By.cssSelector("#wb_Text8"));
        scrollToElement(wb_Text8);
        WebElement location = basePages.findElement(By.cssSelector("#formListView li:nth-child(3) p"));

        try {
            assertEquals("Город Казань", location.getText(),
                    "Значение в поле 'Расположение' не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFLocation()': completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingCFLocation()' завершился с ошибкой!", e);
        }
    }
}
