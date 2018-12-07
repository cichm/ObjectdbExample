package model.user;

import javax.persistence.Entity;

@Entity
public class IsActive {
    private IsActive(boolean value) {
        this.value = value;
    }

    private boolean value;

    public static IsActive isActive(boolean value) {
        return new IsActive(value);
    }

    public boolean isValue() {
        return value;
    }
}
