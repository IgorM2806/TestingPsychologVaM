package org.example.publicationsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingNavigationElementsPublicationPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingNavigationElementsPublicationPageTests.class);
    PublicationsPageLocator publicationsPageLocator;

    public CheckingNavigationElementsPublicationPageTests() {
        super("https://psycholog-vam.ru/AllPublications.html");
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkMainPoint()  throws InterruptedException {
        logger.info("Starting test 'checkMainPoint()'.");

        try {
            clickingElement(publicationsPageLocator.mainPointLocator);
            String title = driver.getTitle();

            assertEquals("psycholog-vam",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkMainPoint(): completed successfully!");
        } catch (Throwable t) {
            logger.info("Tests for checkMainPoint(): failed! - ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkSecondPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSecondPoint()'.");

        try {
            clickingElement(publicationsPageLocator.secondPointLocator);
            String title = driver.getTitle();

            assertEquals("About me",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkSecondPoint(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Tests for checkSecondPoint(): failed! - ", t);
            throw t;
        }
    }
    @Test
    @Description("Проверка переходов в главном меню страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkFourthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFourthPoint()'.");
        try {
            clickingElement(publicationsPageLocator.fourthPointLocator);
            String title = driver.getTitle();

            assertEquals("Все публикации",
                    title, "Значение title целевой страницы не соответствует ожиданию:{}");
            logger.info("Tests for checkFourthPoint(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Tests for checkFourthPoint(): failed! - ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkFifthPoint()  throws InterruptedException {
        logger.info("Starting test 'checkFifthPoint()'.");

        try {
            clickingElement(publicationsPageLocator.fifthPointLocator);
            WebElement controlElement = basePages.findElement(publicationsPageLocator.fifthPointControlElementLocator);

            assertTrue(controlElement.isDisplayed(), "Раздел 'Контакты' не отображается при переходе!");
            logger.info("Tests for checkFifthPoint(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Tests for checkFifthPoint(): failed! - ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка переходов в главном меню страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkSixPoint()  throws InterruptedException {
        logger.info("Starting test 'checkSixPoint()'.");
        try {
            clickingElement(publicationsPageLocator.sixPointLocator);
            WebElement controlElement = basePages.findElement(publicationsPageLocator.sixPointControlElementLocator);

            assertTrue(controlElement.isDisplayed(),
                    "Раздел 'Заявка на консультацию' не отображается при переходе!");
            logger.info("Tests for checkSixPoint(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Tests for checkSixPoint(): failed! - ", t);
            throw t;
        }
    }
}
