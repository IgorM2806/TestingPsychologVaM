package org.example.aboutMe;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Обо мне'.")
@Feature("Проверка переходов по элементам навигации страницы 'Обо мне'.")
public class CheckNavigationAboutmeTests extends BaseTest {

    public CheckNavigationAboutmeTests(){
        super("https://psycholog-vam.ru/SpecialistProfile.html");
    }
    public static final Logger logger = LoggerFactory.getLogger(CheckNavigationAboutmeTests.class);

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Обо мне'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Главная'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingMainPoint() {
        logger.info("Starting test 'CheckingMainPoint'.");
        clickingElement(By.cssSelector("#menu-list li:first-child a"));
        String title = driver.getTitle();

        try {
            assertEquals("psycholog-vam",
                    title, "Значение title целевой страницы не соответствует ожиданию.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingMainPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Обо мне'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Обо мне'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingAboutMePoint() {
        logger.info("Starting test 'CheckingAboutMePoint'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(2) a"));
        String title = driver.getTitle();

        try {
            assertEquals("About me", title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingAboutMePoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingAboutMePoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Образование'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingEducationPoint() {
        logger.info("Starting test 'CheckingEducationPoint'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(3) a"));
        String title = driver.getTitle();

        try {
            assertEquals("Education", title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingEducationPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingEducationPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Публикации'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingAllPublicationsPoint() {
        logger.info("Starting test 'CheckingAllPublicationsPoint'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(4) a"));
        String title = driver.getTitle();

        try{
            assertEquals("Все публикации",  title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingAllPublicationsPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingAllPublicationsPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Step("Отображается раздел 'Контакты' на Главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingContactsPoint() {
        logger.info("Starting test 'CheckingContactsPoint'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        WebElement controlElement = waitForElement(By.cssSelector("#wb_Text8 span"), 5);

        try {
            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается на странице!");
            logger.info("Тест 'CheckingContactsPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingContactsPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Step("Отображается раздел 'Контакты' на Главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingSubmitApplicationPoint() {
        logger.info("Starting test 'CheckingSubmitApplicationPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(5) a"));

        WebElement controlElement = waitForElement(By.cssSelector("#wb_Text8 span"), 5);

        try {
            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается на странице!");
            logger.info("Тест 'CheckingSubmitApplicationPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingSubmitApplicationPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }
}
