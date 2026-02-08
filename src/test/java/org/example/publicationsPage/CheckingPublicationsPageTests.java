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

public class CheckingPublicationsPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingPublicationsPageTests.class);
    PublicationsPageLocator publicationsPageLocator;

    public CheckingPublicationsPageTests() {
        super("https://psycholog-vam.ru/AllPublications.html");
    }

    @Test
    @Description("Проверка отображения основных элементов страницы 'Публикации'.")
    @Severity(SeverityLevel.NORMAL)
    public void checkTitle() throws InterruptedException {
        logger.info("Starting test 'checkTitle()'.");
        try {
            String title = driver.getTitle();

            assert title.contains("Все публикации");
            logger.info("Tests for checkTitle(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Тест 'checkTitle()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения основных элементов страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPageTitle() throws InterruptedException {
        logger.info("Starting test 'checkingPageTitle()'.");

        try {
            WebElement heading1 = basePages.findElement(publicationsPageLocator.headerLocator);

            assertEquals("Все публикации", heading1.getText(),
                    "Содержание heading1 не соответствует ожидаемому значению!");
            logger.info("Tests for checkingPageTitle(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Тест 'checkingPageTitle()' завершился с ошибкой:", t);
            throw t;
        }
    }
}
