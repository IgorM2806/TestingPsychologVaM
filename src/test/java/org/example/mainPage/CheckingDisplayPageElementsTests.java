package org.example.mainPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
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
    MainPageLocators mainPageLocators;

    @Test
    @Description("Проверка значения title целевой страницы.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkTitle() {
        logger.info("Starting test 'checkTitle'.");
        String title = driver.getTitle();

        try {
            assert title.contains("psycholog-vam");
            logger.info("Tests for checkTitle(): completed successfully!");
        }catch (Throwable t){
            logger.error("Ошибка в тесте 'checkTitle': ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка отображения логотипа.")
    @Severity(SeverityLevel.MINOR)
    public void checkLogoSource() {
        logger.info("Starting test 'logoSearch'.");
        String expectedSrc = "https://psycholog-vam.ru/images/DSC_6602_smol.JPG";

        try {
            WebElement logo = basePages.findElement(mainPageLocators.logoElementLocator);
            String actualSrcValue = logo.getAttribute("src");

            assertEquals(expectedSrc, actualSrcValue,
                    "Атрибут src не соответствует ожидаемому значению!");
            logger.info("Tests for logoSearch(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Ошибка в тесте 'checkTitle': ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingPublicationSection() {
        logger.info("Starting test 'checkingPublicationSection'.");

        try {
            scrollToElement(mainPageLocators.publicationSectionLocator);
            WebElement publication = basePages.findElement(mainPageLocators.publicationSectionLocator);
            boolean isVisible = publication.isDisplayed();

            assertTrue(isVisible, "Элемент Публикации не отображается на экране!");
            logger.info("Tests for checkingPublicationSection(): completed successfully!");
        } catch (Throwable t) {
            logger.error("Ошибка в тесте 'checkingPublicationSection': ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка отображения блока с цитатой на главной странице.")
    @Severity(SeverityLevel.NORMAL)
    public void displayingBlockQuote() {
        logger.info("Starting test 'displayingBlockQuote()'.");

        try {
            scrollToElement(mainPageLocators.blockQuoteLocator);
            WebElement isVisible = waitForElement(mainPageLocators.blockQuoteLocator, 5);
            boolean isDisplayed = isVisible.isDisplayed();
            assertTrue(isDisplayed, "Блок с цитатой не отображается на Главной странице!");
            logger.info("Tests for displayingBlockQuote(): completed successfully!");
        }catch (Throwable t){
            logger.error("Тест displayingBlockQuote() завершился с ошибкой: ", t);
            throw t;
        }
    }

    @Test
    @Description("Проверка отображения информации в Футере страницы.")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkingDisplayFooterBlockMainPage() throws InterruptedException {
        logger.info("Starting test 'checkingDisplayFooterBlockMainPage()'.");
        String expectedText = "© Copyright INGC  2025";

        try {
            scrollToElement(mainPageLocators.footerLocator);
            WebElement footerText = waitForElement(mainPageLocators.footerLocator, 5);
            String actualText =  footerText.getText();
            assertEquals(expectedText, actualText, "Значение в footer{} " + actualText
                    + " не соответствует ожиданию{} "+ expectedText);
            logger.info("Tests for checkingDisplayFooterBlockMainPage(): completed successfully!");
        }catch (Throwable t){
            logger.error("Тест checkingDisplayFooterBlockMainPage() завершился с ошибкой: ", t);
            throw t;
        }
    }
}
