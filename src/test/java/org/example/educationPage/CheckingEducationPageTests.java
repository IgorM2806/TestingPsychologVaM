package org.example.educationPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование страницы 'Образование'.")
@Feature("Проверка отображения основных элементов страницы.")
public class CheckingEducationPageTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingEducationPageTests.class);

    public CheckingEducationPageTests() {
        super("https://psycholog-vam.ru/Education.html");
    }


    @Test
    @Description("Проверка отображения основных элементов страницы.")
    @Step("Значение title страницы соответствует ожиданию.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkTitle() throws InterruptedException {
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
    @Step("Содержание заголовка  страницы соответствует ожиданию.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPageTitle() throws InterruptedException {
        logger.info("Starting test 'checkingPageTitle()'.");
        WebElement heading1 = basePages.findElement(By.id("Heading1"));

        try {
            assertEquals("Образование", heading1.getText(),
                    "Содержание heading1 не соответствует ожидаемому значению!");
            logger.info("Tests for checkingPageTitle(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingPageTitle()' завершился с ошибкой: ");
            throw e;
        }
    }
}
