package org.example;

import java.util.ArrayList;
import java.util.List;

public class FormValidDataProvider {

    public static List<Object[]> validFormData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Иван", "petrov@example.com", "Запишите меня на ближайшую дату."});
        return list;
    }
}
