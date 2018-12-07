package model.user;

import javax.persistence.Entity;

@Entity
public class Surname {
    private Surname(String value) {
        this.value = value;
    }

    private String value;

    public static Surname surname(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Prosze wprowadzic prawidlowe nazwisko.");
        }

        return new Surname(value);
    }

    public String getValue() {
        return value;
    }
}
