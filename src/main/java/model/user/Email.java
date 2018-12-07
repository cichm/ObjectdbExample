package model.user;

import javax.persistence.Entity;

@Entity
public class Email {
    private Email(String value) {
        this.value = value;
    }

    private String value;

    public static Email email(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Prosze wprowadzic prawidlowy email.");
        }

        return new Email(value);
    }

    public String getValue() {
        return value;
    }
}
