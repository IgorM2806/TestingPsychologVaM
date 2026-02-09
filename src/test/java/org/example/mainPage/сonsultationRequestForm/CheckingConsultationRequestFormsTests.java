package org.example.mainPage.сonsultationRequestForm;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.mainPage.MainPageConsultationRequestFormsLocators;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Главная'.")
@Feature("Проверка формы отправки заявки на консультацию.")
public class CheckingConsultationRequestFormsTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingConsultationRequestFormsTests.class);
    MainPageConsultationRequestFormsLocators mainPageConsultationRequestFormsLocators;

    public CheckingConsultationRequestFormsTests() {
        super("https://psycholog-vam.ru");
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckingConsultationForms() throws InterruptedException {
        logger.info("Tests for CheckingConsultationForms(): started.");
        try {
            WebElement controlElement = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);

            assertTrue(controlElement.isDisplayed(), "Раздел 'Заявка на консультацию' не отображается!");
            logger.info("Tests for CheckingConsultationForms(): completed successfully!");
        } catch (Exception e) {
            logger.error("Ошибка в тесте 'CheckingConsultationForms()': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationFormLabel() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement consultationFormLabel = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.consultationFormLabelElement);

            assertEquals("Имя", consultationFormLabel.getText(),
                    "Значение в поле 'Имя' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel(): completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationFormLabel()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationForNameValue() throws InterruptedException {
        logger.info("Tests for CheckingConsultationForNameValue(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement formNameElement = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.nameFieldElement);
            String forNameValue = formNameElement.getAttribute("placeholder");

            assertEquals("Введите своё имя",
                    forNameValue, "Значение поля 'placeholder' для поля ввода 'Имя' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationForNameValue(): completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationFormLabel2() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel2(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement formLabel2Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.emailFieldElement);

            assertEquals("Email", formLabel2Element.getText(),
                    "Название поля 'Email' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel2(): completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationFormLabel3() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel3(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement formEmailElement = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.placeholderEmailElement);
            String forEmailValue = formEmailElement.getAttribute("placeholder");

            assertEquals("Введите адрес электронной почты",
                    forEmailValue, "Значение поля 'placeholder' для поля ввода 'Email' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel3(): completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationFormLabel4() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel4(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement formLabel4Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.nameMessageField);

            assertEquals("Сообщение", formLabel4Element.getText(),
                    "Название поля 'Сообщение' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel4() completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationFormLabel4()' завершился с ошибкой: ", e);
            throw e;
        }
    }
    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingConsultationFormMessageElement() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormMessageElement(): started.");
        try {
            WebElement wb_Text6Element = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            scrollToElement(mainPageConsultationRequestFormsLocators.sectionTitleElement);
            WebElement formMessageElement = basePages
                    .findElement(mainPageConsultationRequestFormsLocators.messageFieldElement);
            String forMessageValue = formMessageElement.getAttribute("placeholder");

            assertEquals("Введите сообщение - не более 255 символов", forMessageValue,
                    "Значение поля 'placeholder' для поля ввода 'Сообщение' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormMessageElement() completed successfully!");
        } catch (Exception e) {
            logger.error("Тест 'CheckingConsultationFormMessageElement()' завершился с ошибкой: ", e);
            throw e;
        }
    }


}
