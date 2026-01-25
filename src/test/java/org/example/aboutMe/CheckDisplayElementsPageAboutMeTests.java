package org.example.aboutMe;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование страницы 'Обо мне'.")
@Feature("Проверка отображения элементов на странице 'Обо мне'.")
public class CheckDisplayElementsPageAboutMeTests extends BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(CheckDisplayElementsPageAboutMeTests.class);

    public CheckDisplayElementsPageAboutMeTests() {
        super("https://psycholog-vam.ru/SpecialistProfile.html");
    }

    @Test
    @Description("Проверка отображения элементов на странице 'Обо мне'.")
    @Step("Значение title страницы соответствует ожиданию.")
    public void testCheckTitleAboutMePage() {
        logger.info("Starting test 'CheckTitleAboutMePage()'!");
        String title = driver.getTitle();

        try {
            assertEquals("About me", title, "Значение title страницы не соответствует ожиданию!");
            logger.info("Тест 'CheckTitleAboutMePage()' завершился успешно.");
        }catch (Exception e) {
            logger.error("Тест 'CheckTitleAboutMePage()' завершился с ошибкой: ", e);
        }
    }

    @Test
    @Description("Проверка отображения элементов на странице 'Обо мне'.")
    @Step("Содержание заголовка страницы не соответствует ожиданию.")
    public void testCheckingHeaderContentAboutMePage() {
        logger.info("Starting test 'CheckingHeaderContentAboutMePage()'!");
        String header = driver.findElement(By.id("Heading1")).getText();

        try {
            assertEquals("Влада Магнич – психолог, коуч, карьерный консультант и профориентолог",
                    header, "Содержание заголовка не соответствует ожиданию!");
            logger.info("Тест 'CheckingHeaderContentAboutMePage()' завершился успешно.");
        }catch (Exception e) {
            logger.error("Тест 'CheckingHeaderContentAboutMePage()' завершился с ошибкой: ", e);
        }
    }
}
