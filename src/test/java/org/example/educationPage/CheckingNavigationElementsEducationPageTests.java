package org.example.educationPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Образование'.")
@Feature("Проверка переходов в главном меню страницы.")
public class CheckingNavigationElementsEducationPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingNavigationElementsEducationPageTests.class);
    EducationPageLocators educationPageLocators;

    public CheckingNavigationElementsEducationPageTests() {
        super("https://psycholog-vam.ru/Education.html");
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckMainPoint()  throws InterruptedException {
        logger.info("Starting test 'checkMainPoint()'.");
        try {
            clickingElement(educationPageLocators.mainPointLocator);
            String title = driver.getTitle();

            assertEquals("psycholog-vam",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkMainPoint(): completed successfully!");
        } catch (AssertionError e) {
            logger.info("Tests for checkMainPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckSecondPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSecondPoint()'.");
        try {
            clickingElement(educationPageLocators.secondPointLocator);
            String title = driver.getTitle();

            assertEquals("About me",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkSecondPoint(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Tests for checkSecondPoint(): failed!");
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFourthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFourthPoint()'.");
        try {
            clickingElement(educationPageLocators.fourthPointLocator);
            String title = driver.getTitle();


            assertEquals("Все публикации",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkFourthPoint(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Tests for checkFourthPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFifthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFifthPoint()'.");
        try {
            clickingElement(educationPageLocators.fifthPointLocator);
            WebElement controlElement = basePages.findElement(educationPageLocators.fifthPointControlElementLocator);

            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается при переходе!");
            logger.info("Tests for checkFifthPoint(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Tests for checkFifthPoint(): failed!");
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Образование'.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckSixPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSixPoint()'.");

        try {
            clickingElement(educationPageLocators.sixPointLocator);
            WebElement dropList2 = basePages.findElement(educationPageLocators.sixPointControlElementLocator);

            assertTrue(dropList2.isDisplayed(), "Раздел 'Заявка на консультацию' не отображается при переходе!");
            logger.info("Tests for checkSixPoint(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Tests for checkSixPoint(): failed!");
            throw e;
        }
    }
}
