package org.example.educationPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование страницы 'Образование'.")
@Feature("Проверка отображения основных элементов страницы.")
public class CheckingEducationPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingEducationPageTests.class);
    EducationPageLocators educationPageLocators;
    public CheckingEducationPageTests() {
        super("https://psycholog-vam.ru/Education.html");
    }


    @Test
    @Description("Проверка отображения основных элементов страницы.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkTitle() {
        logger.info("Starting test 'checkTitle()'.");
        String title = driver.getTitle();

        try {
            assert title.contains("Education");
            logger.info("Tests for checkTitle(): completed successfully!");

        }catch (AssertionError e){
            logger.error("Тест 'checkTitle()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения основных элементов страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPageTitle() throws TimeoutException {
        logger.info("Starting test 'checkingPageTitle()'.");
        try {
            WebElement heading1 = basePages.findElement(educationPageLocators.headerLocator);

            assertEquals("Образование", heading1.getText(),
                    "Содержание heading1 не соответствует ожидаемому значению!");
            logger.info("Tests for checkingPageTitle(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Тест 'checkingPageTitle()' завершился с ошибкой: ");
            throw e;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания! ", te);
            throw te;
        }
    }
}
