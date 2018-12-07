package model.user;

import javax.persistence.Entity;

@Entity
public class Sex {
    private Sex(boolean value) {
        this.value = value;
    }

    private boolean value;

    public static Sex sex(boolean value) {
        return new Sex(value);
    }

    public boolean isValue() {
        return value;
    }
}
