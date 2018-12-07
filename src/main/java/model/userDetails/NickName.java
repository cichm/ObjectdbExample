package model.userDetails;

import javax.persistence.Entity;

@Entity
public class NickName {
    private NickName(String value) {
        this.value = value;
    }

    private String value;

    public static NickName nickName(String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Wprowadzono bledny nickname.");
        }

        return new NickName(value);
    }

    public String getValue() {
        return value;
    }
}
