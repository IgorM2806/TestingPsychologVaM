package org.example.mainPage.сonsultationRequestForm;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование формы 'Заявка на консультацию'")
@Feature("Отправка данных через форму 'Заявка на консультацию'.")
public class FormSubmissionTests extends BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(FormSubmissionTests.class);

    public FormSubmissionTests() {
        super("https://psycholog-vam.ru");
    }

    @ParameterizedTest
    @MethodSource("org.example.FormValidDataProvider#validFormData")
    @Description("Отправка валидных значений.")
    @Step("Успешная отправка валидных значений.")
    @Severity(SeverityLevel.CRITICAL)
    public void testSendingValidValues(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'sendingValidValues()'.");
        String expectedMessage = "Сообщение отправлено!";
        WebElement requestConsultation = basePages.findElement(By.cssSelector("#wb_Text6"));
        scrollToElement(requestConsultation);

        insertingValueIntoFieldName(By.cssSelector("#formName"), name);
        insertingValueIntoFieldEmail(By.cssSelector("#formEmail"), email);
        insertingValueIntoFieldMessage(By.cssSelector("#formMessage"), message);
        clickingValueIntoFieldCheckbox(By.cssSelector("#privacyConsent"));

        clickingElement(By.cssSelector("#formButton"));
        String alert = getTextAlert();

        try {
            assertEquals(expectedMessage, alert, "Содержание alert: "
                    + alert + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'sendingValidValues()' passed.");
        }catch (AssertionError e){
            logger.error("Test 'sendingValidValues()' завершился с ошибкой: ", e);
            throw e;
        }
    }
}
