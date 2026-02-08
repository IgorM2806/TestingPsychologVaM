package org.example;

import java.util.ArrayList;
import java.util.List;

public class FormData {

    public static List<Object[]> validFormData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrov@example.com", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> invalidNameFieldOneCharacter() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"И", "petrov@example.com", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> invalidNameFieldThirtyOneCharacter() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"ИванИванИванИванИванИванИванИва",
                "petrov@example.com", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> emptyValuesForm() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"",
                "", ""});
        return list;
    }

    public static List<Object[]> invalidNameSpecialCharacters() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"#Иван&", "petrov@example.com", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> invalidEmailField() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrovexample.com", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> emptyEmailField() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "", "Запишите меня на ближайшую дату."});
        return list;
    }

    public static List<Object[]> emptyEmptyMessageField() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrov@example.com", ""});
        return list;
    }

    public static List<Object[]> sendingSpecialCharactersMessageField() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrov@example.com", "@#$%&*(**^%() Test тест"});
        return list;
    }

    public static List<Object[]> sendingValueMore250CharactersMessageField() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrov@example.com", "pLQdYFw8zRjE6XvHc2UOkNqBmS1ZiTl0aGPJyWn7KsVx3DMBAr" +
                "9C4hOt5eILsugZbfVQr0xNpJkHdYMiAEFtcO86XySvBHpRQ1K4ujNzLwGm2Jb9TXfCihYsPoEW03DQm75LRakcBSxoUWH6" +
                "vt4gyPzNJrEdqi8lpLQdYFw8zRjE6XvHc2UOkNqBmS1ZiTl0aGPJyWn7KsVx3DMBAr9C4hOt5eILsugZbfVQr0xNpJkHdYM" +
                "iGFHGFGFHGFHFH256"});
        return list;
    }
}
