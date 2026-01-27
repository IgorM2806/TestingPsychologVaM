package org.example.publicationsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingPublicationsPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingPublicationsPageTests.class);

    public CheckingPublicationsPageTests() {
        super("https://psycholog-vam.ru/AllPublications.html");
    }

    @Test
    @Description("Проверка отображения основных элементов страницы 'Публикации'.")
    @Step("Значение title страницы соответствует ожиданию.")
    @Severity(SeverityLevel.NORMAL)
    public void checkTitle() throws InterruptedException {
        logger.info("Starting test 'checkTitle()'.");
        String title = driver.getTitle();

        try {
            assert title.contains("Все публикации");
            logger.info("Tests for checkTitle(): completed successfully!");

        }catch (AssertionError e){
            logger.error("Тест 'checkTitle()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения основных элементов страницы.")
    @Step("Содержание заголовка  страницы соответствует ожиданию.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPageTitle() throws InterruptedException {
        logger.info("Starting test 'checkingPageTitle()'.");
        WebElement heading1 = basePages.findElement(By.id("wb_DropList1"));

        try {
            assertEquals("Все публикации", heading1.getText(),
                    "Содержание heading1 не соответствует ожидаемому значению!");
            logger.info("Tests for checkingPageTitle(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingPageTitle()' завершился с ошибкой:", e);
            throw e;
        }
    }
}
