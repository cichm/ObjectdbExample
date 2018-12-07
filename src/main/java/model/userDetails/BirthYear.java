package model.userDetails;

import javax.persistence.Entity;

@Entity
public class BirthYear {
    private BirthYear(int value) {
        this.value = value;
    }

    private int value;

    public static BirthYear birthYear(int value) {
        if (value <= 1900) {
            throw new IllegalArgumentException("Wprowadzono nieprawidlowy rok narodzin.");
        }

        return new BirthYear(value);
    }

    public int getValue() {
        return value;
    }
}
