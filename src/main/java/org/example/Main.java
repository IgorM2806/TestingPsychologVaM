package org.example;

import org.testng.TestNG;


public class Main {
    public static  void main(String[] args) {
        TestNG testNGCheckingAboutMePage = new TestNG();
        testNGCheckingAboutMePage.setTestClasses(new Class[]{
                CheckingAboutMePage.class,
        });
        TestNG CheckingConsultationRequestForms = new TestNG();
        CheckingConsultationRequestForms.setTestClasses(new Class[]{
                CheckingConsultationRequestForms.class,
        });
        TestNG CheckingContactForms =  new TestNG();
        CheckingContactForms.setTestClasses(new Class[]{
                CheckingContactForms.class,
        });
        TestNG CheckingEducationPage =  new TestNG();
        CheckingEducationPage.setTestClasses(new Class[]{
                CheckingEducationPage.class
        });
        TestNG CheckingMainPage = new TestNG();
        CheckingMainPage.setTestClasses(new Class[]{
                CheckingMainPage.class
        });

        testNGCheckingAboutMePage.run();
        CheckingConsultationRequestForms.run();
        CheckingContactForms.run();
        CheckingEducationPage.run();
        CheckingMainPage.run();
    }
}