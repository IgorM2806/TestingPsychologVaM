package org.example.mainPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка отображения основных элементов Главной страницы.")
public class CheckingDisplayPageElementsTests extends BaseTest {

    public CheckingDisplayPageElementsTests(){
        super("https://psycholog-vam.ru");
    }
    private static final Logger logger = LoggerFactory.getLogger(CheckingDisplayPageElementsTests.class);

    @Test
    @Description("Проверка значения title целевой страницы.")
    @Step("Открыта целевая страница.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkTitle() throws InterruptedException {
        logger.info("Starting test 'checkTitle'.");
        String title = driver.getTitle();
        try {
            assert title.contains("psycholog-vam");
            logger.info("Tests for checkTitle(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения логотипа.")
    @Step("Логотип соответствует ожиданию.")
    @Severity(SeverityLevel.MINOR)
    public void logoSearch() throws InterruptedException {
        logger.info("Starting test 'logoSearch'.");

        WebElement logo = basePages.findElement(By.id("Picture2"));
        String actualSrcValue = logo.getAttribute("src");

        try {
            assertEquals("https://psycholog-vam.ru/images/DSC_6602_smol.JPG", actualSrcValue,
                    "Атрибут src не соответсвует ожидаемому значению!");
            logger.info("Tests for logoSearch(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Step("Раздел 'Публикации' отображается на странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingPublicationSection() throws InterruptedException{
        logger.info("Starting test 'checkingPublicationSection'.");
        WebElement publication = basePages.findElement(By.cssSelector("#testimonialsHeading"));
        scrollToElement(publication);
        boolean isVisible =  publication.isDisplayed();

        try {
            assertTrue(isVisible, "Элемент Публикации не отображается на экране!");
            logger.info("Tests for checkingPublicationSection(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingPublicationSection': ", e);
            throw e;
        }
    }
}
