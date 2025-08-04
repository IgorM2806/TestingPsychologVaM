import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckingEducationPage {
    private WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.psycholog-vam.ru/Education.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checktitle() throws InterruptedException {
        String title = driver.getTitle();
        assert title.contains("Education");
        WebElement heading1 =  driver.findElement(By.id("Heading1"));
        assertEquals("Содержание heading1 не соответсвует ожидаемому значению!", heading1.getText(),
                "Образование");
    }

    @Test
    public void checkMainPoint()  throws InterruptedException {
        WebElement main = driver.findElement(By.cssSelector("#menu-list li:first-child a"));
        main.click();
        String title = driver.getTitle();
        assert title.contains("psycholog-vam");
    }

    @Test
    public void checkSecondPoint()  throws InterruptedException {
        WebElement aboutMe = driver.findElement(By.cssSelector("#menu-list li:nth-child(2) a"));
        aboutMe.click();
        String title = driver.getTitle();
        assert title.contains("About me");
    }
    @Test
    public void checkFourthPoint()  throws InterruptedException {
        WebElement publications = driver.findElement(By.cssSelector("#menu-list li:nth-child(4) a"));
        publications.click();
        String title = driver.getTitle();
        assert title.contains("Все публикации");
        WebElement dropList1 = driver.findElement(By.cssSelector("#wb_DropList1"));
        assert dropList1.isDisplayed();
    }

    @Test
    public void checkFifthPoint()  throws InterruptedException {
        WebElement contacts = driver.findElement(By.cssSelector("#menu-list li:nth-child(5) a"));
        contacts.click();
        String title = driver.getTitle();
        assert title.contains("psycholog-vam");
        WebElement dropList2 = driver.findElement(By.cssSelector("#wb_Text8"));
        assert dropList2.isDisplayed();
    }
}
