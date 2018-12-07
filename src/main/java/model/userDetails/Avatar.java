package model.userDetails;

import javax.persistence.Entity;

@Entity
public class Avatar {
    private Avatar(String value) {
        this.value = value;
    }

    private String value;

    public static Avatar avatar(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Adres do zdjęcia jest nieprawidłowy.");
        }

        return new Avatar(value);
    }

    public String getValue() {
        return value;
    }
}
