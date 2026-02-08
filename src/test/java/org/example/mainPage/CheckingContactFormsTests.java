package org.example.mainPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка отображения информации в разделе 'контакты'.")
public class CheckingContactFormsTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingContactFormsTests.class);
    ContactFormsLocators contactFormsLocators;
    public CheckingContactFormsTests(){
        super("https://psycholog-vam.ru/");
    }


    @Test
    @Description("Проверка отображения информации в разделе 'контакты' на Главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingCFMailElement() throws TimeoutException {
        logger.info("Starting test 'checkingCFMailElement()'.");
        String expectedElement = "vlada.magnich@yandex.ru";
        try {
            scrollToElement(contactFormsLocators.cFMailElementLocator);
            WebElement mailElement = driver.findElement(contactFormsLocators.mailElementLocator);

            assertEquals(expectedElement, mailElement.getText(),
                    "Значение в поле Email не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFMailElement()': completed successfully!");
        } catch (AssertionError e) {
            logger.error("Тест 'checkingCFMailElement()' завершился с ошибкой!", e);
            throw e;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания!", te);
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Контакты' на Главной странице.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingCFCallMe() throws TimeoutException {
        logger.info("Starting test 'checkingCFCallMe()'.");
        String expectedText = "+7 903 344 89 75";
        try {
            scrollToElement(contactFormsLocators.cFMailElementLocator);
            WebElement callMe = basePages.findElement(contactFormsLocators.callMeLocator);

            assertEquals(expectedText, callMe.getText(),
                    "Значение в поле 'Позвони мне' не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFCallMe()': completed successfully!");
        } catch (AssertionError e) {
            logger.error("Тест 'checkingCFCallMe()' завершился с ошибкой!", e);
            throw e;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания! ", te);
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Контакты' на Главной странице.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingCFLocation() throws TimeoutException {
        logger.info("Starting test 'checkingCFLocation()'.");
        String expectedText = "Город Казань";
        try {
            scrollToElement(contactFormsLocators.cFMailElementLocator);
            WebElement location = basePages.findElement(contactFormsLocators.locationLocator);

            assertEquals(expectedText, location.getText(),
                    "Значение в поле 'Расположение' не соответствует ожиданию!");
            logger.info("Tests for 'checkingCFLocation()': completed successfully!");
        } catch (AssertionError e) {
            logger.error("Тест 'checkingCFLocation()' завершился с ошибкой!", e);
        }catch (TimeoutException te){
            logger.error("превышен лимит ожидания! ", te);
        }
    }
}
