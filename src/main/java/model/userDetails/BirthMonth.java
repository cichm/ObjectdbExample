package model.userDetails;

import javax.persistence.Entity;

@Entity
public class BirthMonth {
    private BirthMonth(int value) {
        this.value = value;
    }

    private int value;

    public static BirthMonth birthMonth(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Wprowadzono nieprawidlowy miesiac narodzin.");
        }

        return new BirthMonth(value);
    }

    public int getValue() {
        return value;
    }
}
