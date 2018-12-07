package model.userDetails;

import javax.persistence.Entity;

@Entity
public class Phone {
    private Phone(String value) {
        this.value = value;
    }

    private String value;

    public static Phone phone(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Wprowadzono bledny numer telefonu.");
        }

        return new Phone(value);
    }

    public String getValue() {
        return value;
    }
}
