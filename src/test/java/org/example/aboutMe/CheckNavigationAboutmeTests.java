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
    AboutMeLocators aboutMeLocators;

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Обо мне'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingMainPoint() {
        logger.info("Starting test 'CheckingMainPoint'.");
        try {
            clickingElement(aboutMeLocators.mainPointLocator);
            String title = driver.getTitle();

            assertEquals("psycholog-vam",
                    title, "Значение title целевой страницы не соответствует ожиданию.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingMainPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Обо мне'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingAboutMePoint() {
        logger.info("Starting test 'CheckingAboutMePoint'.");
        try {
            clickingElement(aboutMeLocators.aboutMePointLocators);
            String title = driver.getTitle();

            assertEquals("About me", title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingAboutMePoint()' завершился успешно.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingAboutMePoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingEducationPoint() {
        logger.info("Starting test 'CheckingEducationPoint'.");
        try {
            clickingElement(aboutMeLocators.educationPointLocator);
            String title = driver.getTitle();

            assertEquals("Education", title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingEducationPoint()' завершился успешно.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingEducationPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingAllPublicationsPoint() {
        logger.info("Starting test 'CheckingAllPublicationsPoint'.");
        try {
            clickingElement(aboutMeLocators.allPublicationsPointLocator);
            String title = driver.getTitle();

            assertEquals("Все публикации", title, "Значение title целевой страницы не соответствует ожиданию.");
            logger.info("Тест 'CheckingAllPublicationsPoint()' завершился успешно.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingAllPublicationsPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingContactsPoint() {
        logger.info("Starting test 'CheckingContactsPoint'.");
        try {
            clickingElement(aboutMeLocators.contactsPointLocator);
            WebElement controlElement = waitForElement(aboutMeLocators.controlElementContactsLocator, 5);


            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается на странице!");
            logger.info("Тест 'CheckingContactsPoint()' завершился успешно.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingContactsPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingSubmitApplicationPoint() {
        logger.info("Starting test 'CheckingSubmitApplicationPoint()'.");
        try {
            clickingElement(aboutMeLocators.submitApplicationPointLocator);
            WebElement controlElement = waitForElement(aboutMeLocators.controlElementApplicationLocator, 5);

            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается на странице!");
            logger.info("Тест 'CheckingSubmitApplicationPoint()' завершился успешно.");
        } catch (AssertionError e) {
            logger.error("Тест 'CheckingSubmitApplicationPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }
}
