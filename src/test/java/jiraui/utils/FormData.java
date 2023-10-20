package jiraui.utils;

import java.util.HashMap;
import java.util.Map;

public class FormData {
    private final Map<String, String> fieldMap = new HashMap<>();

    public FormData withField(String fieldName, String fieldValue) {
        fieldMap.put(fieldName, fieldValue);
        return this;
    }

    public String getField(String fieldName) {
        return fieldMap.get(fieldName);
    }

    public static FormData create() {
        return new FormData();
    }
}