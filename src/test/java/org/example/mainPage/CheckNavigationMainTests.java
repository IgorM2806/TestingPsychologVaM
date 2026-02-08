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
    NavigationMainLocator navigationMainLocator = new NavigationMainLocator();

    private static final Logger logger = LoggerFactory.getLogger(CheckNavigationMainTests.class);

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageFirstPointMenu()  throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageFirstPointMenu'.");
        try {
            WebElement firstPointMenu = basePages.findElement(navigationMainLocator.firstPointMenuLocator);
            String actualHrefValue = firstPointMenu.getAttribute("href");

            assertEquals("https://psycholog-vam.ru/index.php",
                    actualHrefValue, "Значение атрибута href отличается от ожидаемого!");
            logger.info("Tests for checkingMenuMainPageFirstPointMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageSecondElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageSecondElementMenu'.");
        try {
            clickingElement(navigationMainLocator.secondElementMenuLocator);
            String title = driver.getTitle();

            assertEquals("About me",
                    title, "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageSecondElementMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageThirdElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageThirdElementMenu'.");
        try {
            clickingElement(navigationMainLocator.thirdElementMenuLocator);
            String title2 = driver.getTitle();

            assertEquals("Education", title2,
                    "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageThirdElementMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkingMenuMainPageFourthElementMenu() throws InterruptedException {
        logger.info("Starting test 'checkingMenuMainPageFourthElementMenu'.");
        try {
            clickingElement(navigationMainLocator.fourthElementMenuLocator);
            String title3 = driver.getTitle();

            assertEquals("Все публикации", title3,
                    "При переходе значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for checkingMenuMainPageFourthElementMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'checkTitle': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов из основного меню Главной страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekFifthElementMenu() throws  InterruptedException {
        logger.info("Starting test 'chekFifthElementMenu'.");
        try {
            clickingElement(navigationMainLocator.fifthElementMenuLocator);
            WebElement controlElement = waitForElement(navigationMainLocator.controlElementLocator, 5);
            boolean isVisible = controlElement.isDisplayed();

            assertTrue(isVisible, "Элемент Контакты не отображается на экране!");
            logger.info("Tests for chekFifthElementMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekFifthElementMenu': ", e);
            throw e;
        }
    }
    @Test
    @Description("Проверка переходов из основного меню Главной страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekSixthElementMenu() throws InterruptedException {
        logger.info("Starting test 'chekSixthElementMenu'.");
        try {
            clickingElement(navigationMainLocator.sixthElementMenuLocator);
            WebElement controlElement = waitForElement(navigationMainLocator.controlElementLocator, 5);
            boolean isVisible = controlElement.isDisplayed();

            assertTrue(isVisible, "Элемент 'Заявка на консультацию' не отображается после перехода.");
            logger.info("Tests for chekSixthElementMenu(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekSixthElementMenu': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreAboutFirstSection() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreAboutFirstSection'.");
        try {
            clickingElement(By.cssSelector("#introButton"));
            String title = driver.getTitle();

            assertEquals("About me", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreAboutFirstSection(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekButtonLearnMoreAboutFirstSection': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMorePC() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMorePC'.");
        try {
            WebElement whyButton = basePages.findElement(navigationMainLocator.buttonLearnMoreLocator);
            scrollToElement(navigationMainLocator.buttonLearnMoreLocator);
            whyButton.click();
            String title = driver.getTitle();

            assertEquals("Psychological counseling",
                    title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMorePC(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekButtonLearnMorePC()': ", e);
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreCCG() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreCCG()'.");
        try {
            WebElement button2 = basePages.findElement(navigationMainLocator.buttonLearnMoreCCGLocator);
            scrollToElement(navigationMainLocator.buttonLearnMoreCCGLocator);
            button2.click();
            String title = driver.getTitle();

            assertEquals("KKP", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreCCG()(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekButtonLearnMoreCCG()()': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void chekButtonLearnMoreCoaching() throws InterruptedException {
        logger.info("Starting test 'chekButtonLearnMoreCoaching'.");
        try {
            WebElement howButton = basePages.findElement(navigationMainLocator.buttonLearnMoreCoachingLocator);
            scrollToElement(navigationMainLocator.buttonLearnMoreCoachingLocator);
            howButton.click();
            String title = driver.getTitle();

            assertEquals("Coaching", title, "Значение title открытой страницы не соответствует ожиданию!");
            logger.info("Tests for chekButtonLearnMoreCoaching(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте 'chekButtonLearnMoreCoaching': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка переходов по элементам навигации страницы.")
    @Severity(SeverityLevel.NORMAL)
    public void checkButtonUp() throws InterruptedException {
        logger.info("Starting test 'checkButtonUp'.");
        try {
            WebElement button1 = basePages.findElement(navigationMainLocator.buttonUpLocator);
            scrollToElement(navigationMainLocator.buttonUpLocator);
            button1.click();
            WebElement logoElement = waitForElement(navigationMainLocator.logoElementLocator, 5);
            boolean logoIsVisible = logoElement.isDisplayed();

            assertTrue(logoIsVisible, "Скролл до header не выполнен!");
            logger.info("Tests for checkButtonUp(): completed successfully!");
        } catch (AssertionError e) {
            logger.error("Ошибка в тесте  'checkButtonUp': ", e);
        }
    }
}
