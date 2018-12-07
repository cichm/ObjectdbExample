package model.user;

import javax.persistence.Entity;

@Entity
public class Name {
    private Name(String value) {
        this.value = value;
    }

    private String value;

    public static Name name(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Prosze wprowadzic prawidlowe imie.");
        }

        return new Name(value);
    }

    public String getValue() {
        return value;
    }
}
