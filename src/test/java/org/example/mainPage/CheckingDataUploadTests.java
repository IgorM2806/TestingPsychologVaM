package org.example.mainPage;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка загрузки данных с сервера.")
public class CheckingDataUploadTests extends BaseTest {
    DataUploadLocators dataUploadLocators;
    public CheckingDataUploadTests(){
        super("https://psycholog-vam.ru");
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckingDataUploadTests.class);

    @Test
    @Description("Проверка отображения информации в разделе 'Публикации' на главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingPublicationBlockDatePublished()  throws TimeoutException{
        logger.info("Starting test 'checkingPublicationBlockDatePublished'.");
        try {
            scrollToElement(dataUploadLocators.publicationBlockLocator);
            waitForPageLoad();
            WebElement blogSubjectSpan = waitForElement(dataUploadLocators.articleDateLocator, 3);
            String fullBlogSubjectText = blogSubjectSpan.getText();

            assertFalse(fullBlogSubjectText.contains("Loading date..."), "Загрузка данных не выполнена!");
            logger.info("Tests for checkingPublicationBlockDatePublished(): completed successfully!");
        } catch (AssertionError ae) {
            logger.error("Ошибка в тесте 'checkingPublicationBlockDatePublished': ", ae);
            throw ae;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания.", te);
            throw te;
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Публикации' на главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingPublicationBlockBlogTextSpan() throws TimeoutException {
        logger.info("Starting test 'checkingPublicationBlockBlogTextSpan'.");
        try {
            scrollToElement(dataUploadLocators.publicationBlockLocator);
            waitForPageLoad();
            WebElement blogTextSpan = waitForElement(dataUploadLocators.contentLocator, 3);
            String mainText = blogTextSpan.getText();

            assertNotEquals("Loading content...", mainText, "Не выполнена загрузка данных content!");
            logger.info("Tests for checkingPublicationBlockBlogTextSpan(): completed successfully!");
        } catch (AssertionError ae) {
            logger.error("Ошибка в тесте 'checkingPublicationBlockBlogTextSpan': ", ae);
            throw ae;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания.", te);
            throw te;
        }
    }

    @Test
    @Description("Проверка отображения информации в разделе 'Публикации' на главной странице.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingPublicationBlockArticleLink() throws TimeoutException{
        logger.info("Starting test 'checkingPublicationBlockArticleLink'.");
        try {
            scrollToElement(dataUploadLocators.publicationBlockLocator);
            waitForPageLoad();
            WebElement articleLink = waitForElement(dataUploadLocators.messageLocator, 3);
            String articleTitle = articleLink.getText();

            assertFalse(articleTitle.contains("Сервис временно недоступен, извините за неудобства!"),
                    "Не выполнена загрузка данных!");
            logger.info("Tests for checkingPublicationBlockArticleLink(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'checkingPublicationBlockArticleLink': ", e);
            throw e;
        }catch (TimeoutException te){
            logger.error("Превышен лимит ожидания.", te);
            throw te;
        }
    }
}
