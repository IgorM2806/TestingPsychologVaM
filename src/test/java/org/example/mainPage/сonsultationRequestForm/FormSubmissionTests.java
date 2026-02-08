package org.example.mainPage.сonsultationRequestForm;

import io.qameta.allure.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование формы 'Заявка на консультацию'")
@Feature("Отправка данных через форму 'Заявка на консультацию'.")
public class FormSubmissionTests extends ApplicationForm {
    public static final Logger logger = LoggerFactory.getLogger(FormSubmissionTests.class);

    public FormSubmissionTests() {
        super("https://psycholog-vam.ru");
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#validFormData")
    @Description("Отправка валидных значений.")
    @Severity(SeverityLevel.CRITICAL)
    public void testSendingValidValues(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'sendingValidValues()'.");
        String expectedMessage = " Сообщение отправлено!";

        try {
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String alertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, alertText, "Содержание alert: "
                    + alertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'sendingValidValues()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'sendingValidValues()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#invalidNameFieldOneCharacter")
    @Description("Отправка невалидного значения в поле 'Имя'")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidNameFieldOneCharacter(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testInvalidNameFieldOneCharacter()'.");
        String expectedMessage = "Имя должно содержать от 2 до 30 символов.";

        try {
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'invalidNameFieldOneCharacter()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testInvalidNameFieldOneCharacter()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#invalidNameFieldThirtyOneCharacter")
    @Description("Отправка невалидного значения в поле 'Имя'")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidNameFieldThirtyOneCharacter(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testInvalidNameFieldThirtyOneCharacter()'.");
        String expectedMessage = "Имя должно содержать от 2 до 30 символов.";

        try {
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testInvalidNameFieldThirtyOneCharacter()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testInvalidNameFieldThirtyOneCharacter()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#emptyValuesForm")
    @Description("Отправка формы с пустыми значениями!")
    @Severity(SeverityLevel.CRITICAL)
    public void testSendingEmptyValues(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testSendingEmptyValues()'.");
        String expectedMessage = "Поле \"Введите своё имя\" не заполнено.\n" + "Поле \"Введите адрес электронной почты\" не заполнено.\n"
                + "Поле \"Введите сообщение - не более 255 символов\" не заполнено.";

        try {
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage.trim(), actualAlertText.trim(), "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testSendingEmptyValues()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testSendingEmptyValues()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#invalidNameSpecialCharacters")
    @Description("Отправка формы со спецсимволами в поле 'Имя'")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidNameSpecialCharacters(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testInvalidNameSpecialCharacters()'.");
        String expectedMessage = "Имя содержит недопустимые символы. Используйте буквы и цифры.";
        try {
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testInvalidNameSpecialCharacters()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testInvalidNameSpecialCharacters()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#invalidEmailField")
    @Description("Отправка формы с невалидным значением Email")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailField(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'invalidEmailField()'.");
        try {
            String expectedMessage = "Адрес электронной почты указан неверно.";
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testInvalidEmailField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testInvalidEmailField()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#emptyEmailField")
    @Description("Отправка формы с пустым полем  Email")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyEmailField(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testEmptyEmailField()'.");
        try {
            String expectedMessage = "Поле \"Введите адрес электронной почты\" не заполнено.";
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testEmptyEmailField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testEmptyEmailField()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#emptyEmptyMessageField")
    @Description("Отправка формы с пустым полем  'Сообщение'")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyMessageField(String name, String email, String message) throws InterruptedException {
        logger.info("Starting test 'testEmptyMessageField()'.");
        try {
            String expectedMessage = "Поле \"Введите сообщение - не более 255 символов\" не заполнено.";
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + "Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testEmptyMessageField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testEmptyMessageField()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#sendingSpecialCharactersMessageField")
    @Description("Отправка формы с пустым полем  'Сообщение'")
    @Severity(SeverityLevel.NORMAL)
    public void testSendingSpecialCharactersMessageField(String name, String email, String message)
            throws InterruptedException {
        logger.info("Starting test 'testSendingSpecialCharactersMessageField()'.");
        try {
            String expectedMessage = "Ваше сообщение было очищено от нестандартных символов. Сообщение отправлено!";
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + " Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testSendingSpecialCharactersMessageField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testSendingSpecialCharactersMessageField()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#sendingValueMore250CharactersMessageField")
    @Description("Отправка формы с пустым полем  'Сообщение'")
    @Severity(SeverityLevel.NORMAL)
    public void testSendingValueMore250CharactersMessageField(String name, String email, String message)
            throws InterruptedException {
        logger.info("Starting test 'testSendingValueMore250CharactersMessageField()'.");
        try {
            String expectedMessage = "Сообщение не должно превышать 255 символов.";
            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + " Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testSendingValueMore250CharactersMessageField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testSendingValueMore250CharactersMessageField()' завершился с ошибкой: ", e);
            throw e;
        }
    }

    @ParameterizedTest
    @MethodSource("org.example.FormData#validFormData")
    @Description("Отправка формы с пустым полем  'Сообщение'")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckingProhibitionResending(String name, String email, String message)
            throws InterruptedException {
        try {
            logger.info("Starting test 'testSendingValueMore250CharactersMessageField()'.");
            String expectedMessage = "Повторная отправка доступна через 1 минуту.";

            scrollToElementApplicationForm();
            sendingApplicationForm(name, email, message);
            closingAlert();
            sendingApplicationForm(name, email, message);
            String actualAlertText = getTextAlertApplicationForm();

            assertEquals(expectedMessage, actualAlertText, "Содержание alert: "
                    + actualAlertText + " Не соответствует ожиданию: " + expectedMessage);
            logger.info("Test 'testSendingValueMore250CharactersMessageField()' passed.");
        } catch (AssertionError e) {
            logger.error("Test 'testSendingValueMore250CharactersMessageField()' завершился с ошибкой: ", e);
            throw e;
        }
    }
}
