package org.example.educationPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.AssertJUnit.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

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
    public void checkingPageTitle() throws InterruptedException {
        logger.info("Starting test 'checkingPageTitle()'.");
        WebElement heading1 =  driver.findElement(By.id("Heading1"));

        try {
            assertEquals("Содержание heading1 не соответствует ожидаемому значению!", heading1.getText(),
                    "Образование");
            logger.info("Tests for checkingPageTitle(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Тест 'checkingPageTitle()' завершился с ошибкой: ");
        }
    }
}
