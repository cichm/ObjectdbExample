package model.userDetails;

import javax.persistence.Entity;

@Entity
public class City {
    private City(String value) {
        this.value = value;
    }

    private String value;

    public static City city(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Wprowadzono nieprawidlowa nazwe miasta.");
        }

        return new City(value);
    }

    public String getValue() {
        return value;
    }
}
