package org.example.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Тестирование страницы 'Главная'.")
@Feature("Проверка формы отправки заявки на консультацию.")
public class CheckingConsultationRequestFormsTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckingConsultationRequestFormsTests.class);

    public CheckingConsultationRequestFormsTests() {
        super("https://psycholog-vam.ru");
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Раздел 'Заявка на консультацию' отображается на странице 'Главная'.")
    public void testCheckingConsultationForms() throws InterruptedException {
        logger.info("Tests for CheckingConsultationForms(): started.");
        WebElement controlElement = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(controlElement);

        try {
            assertTrue(controlElement.isDisplayed(), "Раздел 'Заявка на консультацию' не отображается!");
            logger.info("Tests for CheckingConsultationForms(): completed successfully!");
        }catch (Exception e){
            logger.error("Ошибка в тесте 'CheckingConsultationForms()': ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Название поля 'Имя' соответствует ожиданию!")
    public void testCheckingConsultationFormLabel() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement consultationFormLabel =  driver.findElement(By.cssSelector("#consultationForm label"));

        try {
            assertEquals("Имя", consultationFormLabel.getText(),
                    "Значение в поле 'Имя' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel(): completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationFormLabel()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Значение поля 'placeholder' для поля ввода 'Имя' соответствует ожиданию!")
    public void testCheckingConsultationForNameValue() throws InterruptedException {
        logger.info("Tests for CheckingConsultationForNameValue(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement formNameElement = driver.findElement(By.cssSelector("#formName"));
        String forNameValue = formNameElement.getAttribute("placeholder");

        try {
            assertEquals("Введите своё имя",
                    forNameValue, "Значение поля 'placeholder' для поля ввода 'Имя' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationForNameValue(): completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Название поля 'Email' соответствует ожиданию!")
    public void testCheckingConsultationFormLabel2() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel2(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement formLabel2Element = driver.findElement(By.cssSelector("#formLabel2"));

        try {
            assertEquals("Email", formLabel2Element.getText(),
                    "Название поля 'Email' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel2(): completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Значение поля 'placeholder' для поля ввода 'Email' соответствует ожиданию!")
    public void testCheckingConsultationFormLabel3() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel3(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement formEmailElement = driver.findElement(By.cssSelector("#formEmail"));
        String forEmailValue = formEmailElement.getAttribute("placeholder");

        try {
            assertEquals("Введите адрес электронной почты",
                    forEmailValue, "Значение поля 'placeholder' для поля ввода 'Email' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel3(): completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationForNameValue()' завершился с ошибкой: ", e);
            throw e;
        }
        System.out.println("Tests for CheckingConsultationFormLabel3Element (): " +
                "completed successfully!");

    }

    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Название поля 'Сообщение' соответствует ожиданию!")
    public void testCheckingConsultationFormLabel4() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormLabel4(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement formLabel4Element = driver.findElement(By.cssSelector("#formLabel4"));

        try {
            assertEquals("Сообщение", formLabel4Element.getText(),
                    "Название поля 'formLabel4' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormLabel4() completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationFormLabel4()' завершился с ошибкой: ", e);
            throw e;
        }
    }
    @Test
    @Description("Проверка формы отправки заявки на консультацию.")
    @Step("Значение поля 'placeholder' для поля ввода 'Сообщение' соответствует ожиданию!")
    public void testCheckingConsultationFormMessageElement() throws InterruptedException {
        logger.info("Tests for CheckingConsultationFormMessageElement(): started.");
        WebElement wb_Text6Element = driver.findElement(By.cssSelector("#wb_Text6 span"));
        scrollToElement(wb_Text6Element);
        WebElement formMessageElement = driver.findElement(By.cssSelector("#formMessage"));
        String forMessageValue = formMessageElement.getAttribute("placeholder");

        try {
            assertEquals("Введите сообщение - не более 255 символов", forMessageValue,
                    "Значение поля 'placeholder' для поля ввода 'Сообщение' не соответствует ожиданию!");
            logger.info("Tests for CheckingConsultationFormMessageElement() completed successfully!");
        }catch (Exception e){
            logger.error("Тест 'CheckingConsultationFormMessageElement()' завершился с ошибкой: ", e);
        }
        System.out.println("Tests for CheckingConsultationFormMessageElement(): completed successfully!");
    }
}
