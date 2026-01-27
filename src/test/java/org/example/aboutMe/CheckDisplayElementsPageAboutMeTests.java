package org.example.aboutMe;

import io.qameta.allure.*;
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
    @Severity(SeverityLevel.CRITICAL)
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
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingHeaderContentAboutMePage() {
        logger.info("Starting test 'CheckingHeaderContentAboutMePage()'!");
        String header =basePages.findElement(By.id("Heading1")).getText();

        try {
            assertEquals("Влада Магнич – психолог, коуч, карьерный консультант и профориентолог",
                    header, "Содержание заголовка не соответствует ожиданию!");
            logger.info("Тест 'CheckingHeaderContentAboutMePage()' завершился успешно.");
        }catch (Exception e) {
            logger.error("Тест 'CheckingHeaderContentAboutMePage()' завершился с ошибкой: ", e);
        }
    }
}
