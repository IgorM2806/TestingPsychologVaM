import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CheckingMainPage {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://psycholog-vam.ru");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void checkTitle() throws InterruptedException {
        String title = driver.getTitle();
        assert title.contains("psycholog-vam");
        //Thread.sleep(500);
    }

    @Test
    public void logoSearch() throws InterruptedException {
        WebElement logo = driver.findElement(By.id("Picture1"));
        String actualSrcValue = logo.getAttribute("src");
        //System.out.println("ActualSrcValue: " + actualSrcValue);
        assertEquals("Атрибут src не соответсвует ожидаемому значению!", actualSrcValue,
                "https://psycholog-vam.ru/images/80204593-3_smoll.png");
    }
    @Test
    public void checkingMenuMainPage()  throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement firstPointMenu = driver.findElement(By.cssSelector("#menu-list > li:first-child > a"));
        WebElement secondElementMenu = driver.findElement(By.cssSelector("#menu-list > li:nth-child(2) > a"));


        String actualhrefValue = firstPointMenu.getAttribute("href");
        assertEquals("Значение атрибута href отличается от ожидаемого!",
                actualhrefValue, "https://psycholog-vam.ru/#");
        secondElementMenu.click();
        String title = driver.getTitle();
        assertEquals("При переходе значение title открытой страницы не соответсвует ожиданию!",
                title, "Раздел 1");
        driver.navigate().to("https://psycholog-vam.ru/");
        WebElement thirdElementMenu =  driver.findElement(By.cssSelector("#menu-list > li:nth-child(3) > a"));
        thirdElementMenu.click();
        String title2 = driver.getTitle();
        assertEquals("При переходе значение title открытой страницы не соответсвует ожиданию!", title2,
                "Education");
        driver.navigate().to("https://psycholog-vam.ru/");
        WebElement fourthElementMenu = driver.findElement(By.cssSelector("#menu-list > li:nth-child(4) > a"));
        fourthElementMenu.click();
        String title3 = driver.getTitle();
        assertEquals("При переходе значение title открытой страницы не соответсвует ожиданию!", title3,
                "Все публикации");

    }

    @Test
    public void chekFifthElementMenu() throws  InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement fifthElementMenu = driver.findElement(By.cssSelector("#menu-list > li:nth-child(5) > a"));
        fifthElementMenu.click();
        WebElement wbtext8 = driver.findElement(By.cssSelector("#wb_Text8 span"));
        boolean isVisible = wbtext8.isDisplayed();
        assertTrue("Элемент Контакты не отображается на экране!", isVisible);
    }

    @Test
    public void chekIntroButtonElement() throws InterruptedException {
        WebElement introButton = driver.findElement(By.cssSelector("#introButton"));
        introButton.click();
        String title = driver.getTitle();
        assertEquals("Значение title открытой страницы не соответствует ожиданию!", title, "Раздел 1");
    }

    @Test
    public void chekWhyButtonElement() throws InterruptedException {
        WebElement whyButton = driver.findElement(By.cssSelector("#whyButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                whyButton);
        whyButton.click();
        String title = driver.getTitle();
        assertEquals("Значение title открытой страницы не соответствует ожиданию!", title, "Раздел 3");

    }

    @Test
    public void chekButton2Element() throws InterruptedException {
        WebElement button2 = driver.findElement(By.cssSelector("#Button2"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                button2);
        button2.click();
        String title = driver.getTitle();
        assertEquals("Значение title открытой страницы не соответствует ожиданию!", title, "ККП");


    }

    @Test
    public void chekHowButtonElement() throws InterruptedException {
        WebElement howButton = driver.findElement(By.cssSelector("#howButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                howButton);
        howButton.click();
        String title = driver.getTitle();
        assertEquals("Значение title открытой страницы не соответствует ожиданию!", title, "Coaching");
    }

    @Test
    public void checkingPublicationSection() throws InterruptedException{
        WebElement publication = driver.findElement(By.cssSelector("#testimonialsHeading"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                publication);
        boolean isVisible =  publication.isDisplayed();
        assertTrue("Элемент Публикации не отображается на экране!", isVisible);
    }

    @Test
    public void checkingPublicationBlock()  throws InterruptedException{
        WebElement publication = driver.findElement(By.cssSelector("#Article1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                publication);
        WebElement blogSubjectSpan = driver.findElement(By.cssSelector("#Article1 .blogsubject"));
        String fullBlogSubjectText =  blogSubjectSpan.getText();
        String datePublished = fullBlogSubjectText.split("-")[0].trim();
        assertNotEquals("Loading date... - ", datePublished, "Не выполнена загрузка данных date!");
        WebElement articleLink = driver.findElement(By.cssSelector("#Article1 .blogsubject a"));
        String articleTitle = articleLink.getText();
        assertNotEquals("Loading title...", articleTitle, "Не выполнена загрузка данных title!");
        WebElement blogTextSpan = driver.findElement(By.cssSelector("#Article1 .blogtext span"));
        String mainText = blogTextSpan.getText();
        assertNotEquals("Loading content...", blogTextSpan, "Не выполнена загрузка данных content!");
    }

    @Test
    public void checkRequestConsultation()  throws InterruptedException {
        WebElement requestConsultation = driver.findElement(By.cssSelector("#LayoutGrid3 .col-2"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                requestConsultation);
        boolean isVisible = requestConsultation.isDisplayed();
        assertTrue("Элемент checkRequestConsultation не отображается!", isVisible );
        WebElement formButton = driver.findElement(By.cssSelector("#formButton"));
        formButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertNotNull(alertText, "Alert не отображается на экране!");
    }

    @Test
    public void checkButton1Element() throws InterruptedException {
        WebElement button1 = driver.findElement(By.cssSelector("#Button1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
                button1);
        button1.click();
        WebElement logoElement = driver.findElement(By.cssSelector("#Picture1"));
        boolean logoIsVisible = logoElement.isDisplayed();
        assertTrue("Скролл до header не выполнен!", logoIsVisible);
    }
}
