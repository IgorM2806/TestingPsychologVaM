package org.example.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

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
    public void logoSearch() throws InterruptedException {
        logger.info("Starting test 'logoSearch'.");

        WebElement logo = driver.findElement(By.id("Picture2"));
        String actualSrcValue = logo.getAttribute("src");

        try {
            assertEquals("Атрибут src не соответсвует ожидаемому значению!", actualSrcValue,
                    "https://psycholog-vam.ru/images/DSC_6602_smol.JPG");
            logger.info("Tests for logoSearch(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка отображения раздела 'Публикации' на главной странице.")
    @Step("Раздел 'Публикации' отображается на странице.")
    public void checkingPublicationSection() throws InterruptedException{
        logger.info("Starting test 'checkingPublicationSection'.");
        WebElement publication = driver.findElement(By.cssSelector("#testimonialsHeading"));
        scrollToElement(publication);
        boolean isVisible =  publication.isDisplayed();

        try {
            assertTrue("Элемент Публикации не отображается на экране!", isVisible);
            logger.info("Tests for checkingPublicationSection(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingPublicationSection': ", e);
            throw e;
        }
    }
}
