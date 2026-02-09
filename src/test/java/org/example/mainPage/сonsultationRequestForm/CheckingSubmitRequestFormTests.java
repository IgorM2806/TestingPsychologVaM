package org.example.mainPage.сonsultationRequestForm;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.mainPage.MainPageConsultationRequestFormsLocators;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Epic("Тестирование страницы 'Главная'")
@Feature("Проверка отображения формы 'Оставить заявку'")
public class CheckingSubmitRequestFormTests extends BaseTest {
    MainPageConsultationRequestFormsLocators mainPageConsultationRequestFormsLocators;
    public CheckingSubmitRequestFormTests(){
        super("https://psycholog-vam.ru");
    }
    public static final Logger logger = LoggerFactory.getLogger(CheckingSubmitRequestFormTests.class);

    @Test
    @Description("Проверка чекбокса в разделе 'Оставить заявку'.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckRequestConsultation()  throws InterruptedException {
        logger.info("Starting test 'checkRequestConsultation'.");
        try {
            scrollToElement(mainPageConsultationRequestFormsLocators.requestConsultationLocator);
            clickingElement(mainPageConsultationRequestFormsLocators.privacyConsentLocator);
            clickingElement(mainPageConsultationRequestFormsLocators.sendButtonLocator);
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            assertNotNull(alertText, "Alert не отображается на экране!");
            logger.info("Tests for checkRequestConsultation(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkRequestConsultation': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка чекбокса в разделе 'Оставить заявку'.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingEmptyConsentCheckbox()  throws InterruptedException {
        logger.info("Starting test 'checkingEmptyConsentCheckbox'.");
        try {
            scrollToElement(mainPageConsultationRequestFormsLocators.requestConsultationLocator);
            clickingElement(mainPageConsultationRequestFormsLocators.sendButtonLocator);
            String alertText = driver.switchTo().alert().getText();

            assertEquals("Необходимо согласиться с условиями конфиденциальности.", alertText,
                    "Отсутствует alert - 'Необходимо согласиться с условиями конфиденциальности'.");
            logger.info("Tests for checkingEmptyConsentCheckbox(): completed successfully!");
        }catch (AssertionError e){
            logger.error("Ошибка в тесте 'checkingEmptyConsentCheckbox': ", e);
            throw e;
        }
    }
}
