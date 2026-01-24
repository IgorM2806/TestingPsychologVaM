package org.example.aboutMe;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

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
    public void CheckingMainPoint() {
        logger.info("Starting test 'CheckingMainPoint'.");
        WebElement mainPoint = driver.findElement(By.cssSelector("#menu-list li:first-child a"));
        mainPoint.click();
        String title = driver.getTitle();

        try {
            assertEquals("Значение title целевой страницы не соответствует ожиданию.",
                    title, "psycholog-vam");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingMainPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Обо мне'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Обо мне'.")
    public void CheckingAboutMePoint() {
        logger.info("Starting test 'CheckingAboutMePoint'.");
        WebElement aboutMe = driver.findElement(By.cssSelector("#menu-list li:nth-child(2) a"));
        aboutMe.click();
        String title = driver.getTitle();

        try {
            assertEquals("Значение title целевой страницы не соответствует ожиданию.", title, "About me");
            logger.info("Тест 'CheckingAboutMePoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingAboutMePoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Образование'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Образование'.")
    public void CheckingEducationPoint() {
        logger.info("Starting test 'CheckingEducationPoint'.");
        WebElement education = driver.findElement(By.cssSelector("#menu-list li:nth-child(3) a"));
        education.click();
        String title = driver.getTitle();

        try {
            assertEquals("Значение title целевой страницы не соответствует ожиданию.", title, "Education");
            logger.info("Тест 'CheckingEducationPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingEducationPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Публикации'.")
    public void CheckingAllPublicationsPoint() {
        logger.info("Starting test 'CheckingAllPublicationsPoint'.");
        WebElement allPublications =  driver.findElement(By.cssSelector("#menu-list li:nth-child(4) a"));
        allPublications.click();
        String title = driver.getTitle();

        try{
            assertEquals("Значение title целевой страницы не соответствует ожиданию.",  title, "Все публикации");
            logger.info("Тест 'CheckingAllPublicationsPoint()' завершился успешно.");
        }catch (AssertionError e){
            logger.error("Тест 'CheckingAllPublicationsPoint()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы 'Публикации'.")
    @Step("Отображается раздел 'Контакты' на Главной странице.")
    public void CheckingContactsPoint() {
        logger.info("Starting test 'CheckingContactsPoint'.");
        WebElement contacts =  driver.findElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        contacts.click();

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
    public void CheckingSubmitApplicationPoint() {
        logger.info("Starting test 'CheckingSubmitApplicationPoint()'.");
        WebElement contacts =  driver.findElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        contacts.click();

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
