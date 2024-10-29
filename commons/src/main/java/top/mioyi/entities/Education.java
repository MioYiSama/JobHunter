package top.mioyi.entities;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Education {
    UNKNOWN("未知"),
    ASSOCIATE("大专"),
    BACHELOR("本科"),
    MASTER("硕士"),
    DOCTORATE("博士");

    private final String value;

    Education(String value) {
        this.value = value;
    }

    public static Education parse(String value) {
        return Arrays.stream(Education.values())
                .filter(education -> education.value.equals(value))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
