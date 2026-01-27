package org.example.educationPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Образование'.")
@Feature("Проверка переходов в главном меню страницы.")
public class CheckingNavigationElementsEducationPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingNavigationElementsEducationPageTests.class);

    public CheckingNavigationElementsEducationPageTests() {
        super("https://psycholog-vam.ru/Education.html");
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Step("Переход по пункту Главная соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckMainPoint()  throws InterruptedException {
        logger.info("Starting test 'checkMainPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:first-child a"));
        String title = driver.getTitle();

        try {
            assertEquals("psycholog-vam",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkMainPoint(): completed successfully!");
        }catch (AssertionError e){
            logger.info("Tests for checkMainPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Step("Переход пу пункту 'Обо мне' соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckSecondPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSecondPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(2) a"));
        String title = driver.getTitle();

        try {
            assertEquals("About me",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkSecondPoint(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Tests for checkSecondPoint(): failed!");
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Step("Переход пу пункту 'Публикации' соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFourthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFourthPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(4) a"));
        String title = driver.getTitle();

        try {
            assertEquals("Все публикации",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkFourthPoint(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Tests for checkFourthPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Step("Переход пу пункту 'Контакты' соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFifthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFifthPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        WebElement dropList2 = basePages.findElement(By.cssSelector("#wb_Text8"));

        try {
            assertTrue(dropList2.isDisplayed(), "Раздел 'Контакты' не отображается при переходе!");
            logger.info("Tests for checkFifthPoint(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Tests for checkFifthPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Step("Переход пу пункту 'Оставить заявку' соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckSixPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSixPoint()'.");
        clickingElement(By.cssSelector("#menu-list li:nth-child(6) a"));
        WebElement dropList2 = basePages.findElement(By.cssSelector("#wb_Text6"));

        try {
            assertTrue(dropList2.isDisplayed(), "Раздел 'Заявка на консультацию' не отображается при переходе!");
            logger.info("Tests for checkSixPoint(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Tests for checkSixPoint(): failed!");
            throw e;
        }
    }
}
