package model.user;

import model.userDetails.UserDetails;

import javax.persistence.Entity;

@Entity
public class User {
    private User() {}

    private Email email;
    private Name name;
    private Surname surname;
    private Age age;
    private IsActive isActive;
    private Sex sex;
    private UserDetails userDetails;

    public User(Email email, Name name, Surname surname, Age age, IsActive isActive, Sex sex, UserDetails userDetails) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isActive = isActive;
        this.sex = sex;
        this.userDetails = userDetails;
    }

    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public Age getAge() {
        return age;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "email=" + email.getValue() +
                ", name=" + name.getValue() +
                ", surname=" + surname.getValue() +
                ", age=" + age.getValue() +
                ", isActive=" + isActive.isValue() +
                ", sex=" + sex.isValue() +
                ", userDetails=" + userDetails.toString() +
                '}';
    }
}
