package org.example.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
        scrollToElement(requestConsultation);
        clickingElement(By.cssSelector("#privacyConsent"));
        clickingElement(By.cssSelector("#formButton"));
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        try {
            assertNotNull(alertText, "Alert не отображается на экране!");
            logger.info("Tests for checkRequestConsultation(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkRequestConsultation': ", e);
            throw e;
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
        clickingElement(By.cssSelector("#formButton"));
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alert: " + alertText);

        try {
            assertEquals("Необходимо согласиться с условиями конфиденциальности.", alertText,
                    "Отсутствует Аллерт - 'Необходимо согласиться с условиями конфиденциальности'.");
            logger.info("Tests for checkingEmptyConsentCheckbox(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingEmptyConsentCheckbox': ", e);
            throw e;
        }
    }
}
