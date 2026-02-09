package org.example.mainPage;

import org.openqa.selenium.By;

public class MainPageConsultationRequestFormsLocators {
    public static By sectionTitleElement = By.cssSelector("#wb_Text6 span");
    public static By consultationFormLabelElement = By.cssSelector("#consultationForm label");
    public static By nameFieldElement = By.cssSelector("#formName");
    public static By emailFieldElement = By.cssSelector("#formLabel2");
    public static By placeholderEmailElement = By.cssSelector("#formEmail");
    public static By messageFieldElement = By.cssSelector("#formMessage");
    public static By nameMessageField =  By.cssSelector("#formLabel4");
    public static By requestConsultationLocator =  By.cssSelector("#LayoutGrid3 .col-2");
    public static By privacyConsentLocator =  By.cssSelector("#privacyConsent");
    public static By sendButtonLocator =   By.cssSelector("#formButton");
}
