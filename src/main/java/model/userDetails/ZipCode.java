package model.userDetails;

import javax.persistence.Entity;

@Entity
public class ZipCode {
    private ZipCode(String value) {
        this.value = value;
    }

    private String value;

    public static ZipCode zipCode(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Wprowadzono nieprawidlowy kod pocztowy.");
        }

        return new ZipCode(value);
    }

    public String getValue() {
        return value;
    }
}
