package model.user;

import javax.persistence.Entity;

@Entity
public class Age {
    private Age(int value) {
        this.value = value;
    }

    private int value;

    public static Age age(int value) {
        if (value < 18) {
            throw new IllegalArgumentException("Prosze wprowadzic prawidłowy wiek.");
        }

        return new Age(value);
    }

    public int getValue() {
        return value;
    }
}
