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
@Feature("Проверка переходов по элементам навигации страницы.")
public class CheckNavigationMainTests extends BaseTest {

    public CheckNavigationMainTests(){
        super("https://psycholog-vam.ru/");
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckNavigationMainTests.class);

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Главная'")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageFirstPointMenu()  throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageFirstPointMenu'.");
        WebElement firstPointMenu = basePages.findElement(By.cssSelector("#menu-list > li:first-child > a"));
        String actualHrefValue = firstPointMenu.getAttribute("href");

        try {
            assertEquals("https://psycholog-vam.ru/index.php",
                    actualHrefValue, "Значение атрибута href отличается от ожидаемого!");
            logger.info("Tests for checkingMenuMainPageFirstPointMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Обо мне'")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageSecondElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageSecondElementMenu'.");
        clickingElement(By.cssSelector("#menu-list > li:nth-child(2) > a"));
        String title = driver.getTitle();

        try {
            assertEquals("About me",
                    title, "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageSecondElementMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Образование'")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageThirdElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageThirdElementMenu'.");
        clickingElement(By.cssSelector("#menu-list > li:nth-child(3) > a"));
        String title2 = driver.getTitle();

        try {
            assertEquals("Education", title2,
                    "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageThirdElementMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Публикации'")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageFourthElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageFourthElementMenu'.");
        clickingElement(By.cssSelector("#menu-list > li:nth-child(4) > a"));
        String title3 = driver.getTitle();

        try {
            assertEquals("Все публикации", title3,
                    "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageFourthElementMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню Главной страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по пункту 'Контакты'")
    @Severity(SeverityLevel.NORMAL)
    public void chekFifthElementMenu() throws  InterruptedException {
        logger.info("Starting test 'chekFifthElementMenu'.");
        clickingElement(By.cssSelector("#menu-list > li:nth-child(5) > a"));
        WebElement controlElement = waitForElement(By.cssSelector("#wb_Text8 span"), 5);
        boolean isVisible = controlElement.isDisplayed();

        try {
            assertTrue(isVisible, "Элемент Контакты не отображается на экране!");
            logger.info("Tests for chekFifthElementMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekFifthElementMenu': ",  e);
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов из основного меню Главной страницы.")
    @Step("Целевой раздел главной страницы отображается на экране,")
    @Severity(SeverityLevel.NORMAL)
    public void chekSixthElementMenu() throws InterruptedException {
        logger.info("Starting test 'chekSixthElementMenu'.");
        clickingElement(By.cssSelector("#menu-list > li:nth-child(6) > a"));
        WebElement controlElement = waitForElement(By.cssSelector("#wb_Text6 span"), 5);
        boolean isVisible = controlElement.isDisplayed();

        try {
            assertTrue(isVisible, "Элемент 'Заявка на консультацию' не отображается после перехода.");
            logger.info("Tests for chekSixthElementMenu(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekSixthElementMenu': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по кнопке 'Узнать больше' первого раздела.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreAboutFirstSection() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreAboutFirstSection'.");
        clickingElement(By.cssSelector("#introButton"));
        String title = driver.getTitle();

        try {
            assertEquals("About me", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreAboutFirstSection(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekButtonLearnMoreAboutFirstSection': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по кнопке 'Узнать больше'" +
            " раздела 'Психологическое консультирование'.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMorePC() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMorePC'.");
        WebElement whyButton = basePages.findElement(By.cssSelector("#whyButton"));
        scrollToElement(whyButton);
        whyButton.click();
        String title = driver.getTitle();

        try {
            assertEquals("Psychological counseling",
                    title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMorePC(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekButtonLearnMorePC()': ", e);
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по кнопке 'Узнать больше'" +
            " раздела 'Карьерное консультирование и профориентация'.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreCCG() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreCCG()'.");
        WebElement button2 = basePages.findElement(By.cssSelector("#Button2"));
        scrollToElement(button2);
        button2.click();
        String title = driver.getTitle();

        try {
            assertEquals("KKP", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreCCG()(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekButtonLearnMoreCCG()()': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Step("Целевая страница соответствует ожиданию при переходе по кнопке 'Узнать больше'" +
            " раздела 'Коучинг'.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreCoaching() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreCoaching'.");
        WebElement howButton = basePages.findElement(By.cssSelector("#howButton"));
        scrollToElement(howButton);
        howButton.click();
        String title = driver.getTitle();

        try {
            assertEquals("Coaching", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreCoaching(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'chekButtonLearnMoreCoaching': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Step("Переход выполнен успешно отображается логотип.")
    @Severity(SeverityLevel.NORMAL)
    public void checkButtonUp() throws InterruptedException {
        logger.info("Starting test 'checkButtonUp'.");
        WebElement button1 = basePages.findElement(By.cssSelector("#Button1"));
        scrollToElement(button1);
        button1.click();
        WebElement logoElement = waitForElement(By.cssSelector("#RollOver1 a"), 5);
        boolean logoIsVisible = logoElement.isDisplayed();

        try {
            assertTrue(logoIsVisible, "Скролл до header не выполнен!");
            logger.info("Tests for checkButtonUp(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте  'checkButtonUp': ", e);
        }
    }
}
