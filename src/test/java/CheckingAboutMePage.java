import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class CheckingAboutMePage {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://psycholog-vam.ru/SpecialistProfile.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTitleMePage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "About me");
    }

    @Test
    public void CheckingHeader() {
        String header = driver.findElement(By.id("Heading1")).getText();
        assertEquals("Влада Магнич – психолог, коуч, карьерный консультант и профориентолог", header);
    }
    @Test
    public void CheckingMainPoint() {
        WebElement mainPoint = driver.findElement(By.cssSelector("#menu-list li:first-child a"));
        mainPoint.click();
        String title = driver.getTitle();
        assertEquals(title, "psycholog-vam");
    }
    @Test
    public void CheckingAboutMePoint() {
        WebElement aboutMe = driver.findElement(By.cssSelector("#menu-list li:nth-child(2) a"));
        aboutMe.click();
        String title = driver.getTitle();
        assertEquals(title, "About me");
    }
    @Test
    public void CheckingEducationPoint() {
        WebElement education = driver.findElement(By.cssSelector("#menu-list li:nth-child(3) a"));
        education.click();
        String title = driver.getTitle();
        assertEquals(title, "Education");
    }

    @Test
    public void CheckingAllPublicationspoint() {
        WebElement allPublications =  driver.findElement(By.cssSelector("#menu-list li:nth-child(4) a"));
        allPublications.click();
        String title = driver.getTitle();
        assertEquals(title, "Все публикации");
    }
    @Test
    public void CheckingContactsPoint() {
        WebElement contacts =  driver.findElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        contacts.click();
        String title = driver.getTitle();
        assertEquals("Значение title не соответсвует ожиданию!", title, "psycholog-vam");
        WebElement wb_Text8 =  driver.findElement(By.cssSelector("#wb_Text8 span"));
        boolean isVisible = wb_Text8.isDisplayed();
        assertTrue(isVisible);
    }


}
