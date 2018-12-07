package model.userDetails;

import javax.persistence.Entity;

@Entity
public class BirthDay {
    private BirthDay(int value) {
        this.value = value;
    }

    private int value;

    public static BirthDay birthDay(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Wprowadzono nieprawidlowy dzien urodzin.");
        }

        return new BirthDay(value);
    }

    public int getValue() {
        return value;
    }
}
