package org.example.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка флормы 'Оставить заявку'")
public class CheckingSubmitRequestFormTests extends BaseTest {

    public CheckingSubmitRequestFormTests(){
        super("https://psycholog-vam.ru");
    }
    public static final Logger logger = LoggerFactory.getLogger(CheckingSubmitRequestFormTests.class);

    @Test
    @Description("Проверка чекбокса в разделе 'Оставить заявку'.")
    @Step("При установке чекбокса не отображается alert с запросом" +
            " подтвердить согласие на обработку персональных данных.")
    public void checkRequestConsultation()  throws InterruptedException {
        logger.info("Starting test 'checkRequestConsultation'.");
        WebElement requestConsultation = driver.findElement(By.cssSelector("#LayoutGrid3 .col-2"));
        WebElement privacyConsentElement = driver.findElement(By.cssSelector("#privacyConsent"));
        scrollToElement(requestConsultation);
        WebElement formButton = driver.findElement(By.cssSelector("#formButton"));
        privacyConsentElement.click();
        formButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        try {
            assertNotNull(alertText, "Alert не отображается на экране!");
            logger.info("Tests for checkRequestConsultation(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkRequestConsultation': ", e);
        }
    }

    @Test
    @Description("Проверка чекбокса в разделе 'Оставить заявку'.")
    @Step("ПРИ ОТСУТСТВИИ установки чекбокса отображается предупреждение (alert)," +
            " запрашивающее подтверждение согласия на обработку персональных данных.")
    public void checkingEmptyConsentCheckbox()  throws InterruptedException {
        logger.info("Starting test 'checkingEmptyConsentCheckbox'.");
        WebElement requestConsultation = driver.findElement(By.cssSelector("#LayoutGrid3 .col-2"));
        scrollToElement(requestConsultation);
        WebElement formButton = driver.findElement(By.cssSelector("#formButton"));
        formButton.click();
        String alertText = driver.switchTo().alert().getText();

        try {
            assertEquals("Отсутствует Аллерт - 'Необходимо согласиться с условиями конфиденциальности.'", alertText,
                    "Необходимо согласиться с условиями конфиденциальности.");
            logger.info("Tests for checkingEmptyConsentCheckbox(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingEmptyConsentCheckbox': ", e);
        }
    }
}
