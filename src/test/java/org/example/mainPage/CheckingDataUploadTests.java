package org.example.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка загрузки данных с сервера.")
public class CheckingDataUploadTests extends BaseTest {

    public CheckingDataUploadTests(){
        super("https://psycholog-vam.ru");
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckingDataUploadTests.class);

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Step("Данные успешно загружены с сервера.")
    public void checkingPublicationBlockDatePublished()  throws InterruptedException{
        logger.info("Starting test 'checkingPublicationBlockDatePublished'.");
        WebElement publication = driver.findElement(By.cssSelector("#Article1"));
        scrollToElement(publication);
        WebElement blogSubjectSpan = waitForElement(By.cssSelector("#Article1 .blogsubject"), 3);
        String fullBlogSubjectText =  blogSubjectSpan.getText();

        try {
            assertFalse(fullBlogSubjectText.contains("Loading date..."), "Загрузка данных не выполнена!");
            logger.info("Tests for checkingPublicationBlockDatePublished(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingPublicationBlockDatePublished': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Step("Данные успешно загружены с сервера.")
    public void checkingPublicationBlockBlogTextSpan() throws InterruptedException{
        logger.info("Starting test 'checkingPublicationBlockBlogTextSpan'.");
        WebElement publication = driver.findElement(By.cssSelector("#Article1"));
        scrollToElement(publication);
        WebElement blogTextSpan = waitForElement(By.cssSelector("#Article1 .blogtext span"), 3);
        String mainText = blogTextSpan.getText();

        try {
            assertNotEquals("Loading content...", mainText, "Не выполнена загрузка данных content!");
            logger.info("Tests for checkingPublicationBlockBlogTextSpan(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingPublicationBlockBlogTextSpan': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Step("Данные успешно загружены с сервера.")
    public void checkingPublicationBlockArticleLink() throws InterruptedException{
        logger.info("Starting test 'checkingPublicationBlockArticleLink'.");
        WebElement publication = driver.findElement(By.cssSelector("#Article1"));
        scrollToElement(publication);
        WebElement articleLink = waitForElement(By.cssSelector("#Article1 span"), 3);
        String articleTitle = articleLink.getText();
        System.out.println("articleTitle: " + articleTitle);
        try {
            assertFalse(articleTitle.contains("Сервис временно недоступен, извините за неудобства!"),
                    "Не выполнена загрузка данных!");
            logger.info("Tests for checkingPublicationBlockArticleLink(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingPublicationBlockArticleLink': ", e);
            throw e;
        }
    }
}
