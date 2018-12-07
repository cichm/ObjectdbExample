package model.userDetails;

import javax.persistence.Entity;

@Entity
public class UserDetails {
    private final Phone phone;
    private final NickName nickName;
    private final City city;
    private final BirthDay birthDay;
    private final BirthMonth birthMonth;
    private final BirthYear birthYear;
    private final ZipCode zipCode;
    private final Avatar avatar;

    public static class Builder {
        private Phone phone = null;
        private NickName nickName = NickName.nickName("0");
        private City city = City.city("0");
        private BirthDay birthDay = BirthDay.birthDay(1);
        private BirthMonth birthMonth = BirthMonth.birthMonth(1);
        private BirthYear birthYear = BirthYear.birthYear(1920);
        private ZipCode zipCode = ZipCode.zipCode("0");
        private Avatar avatar = Avatar.avatar("0");

        public Builder() {
        }

        public Builder phone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public Builder nickName(NickName nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Builder birthDay(BirthDay birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder birthMonth(BirthMonth birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder birthYear(BirthYear birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder zipCode(ZipCode zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder avatar(Avatar avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserDetails build() {
            return new UserDetails(this);
        }
    }

    private UserDetails(Builder builder) {
        this.phone = builder.phone;
        this.nickName = builder.nickName;
        this.city = builder.city;
        this.birthDay = builder.birthDay;
        this.birthMonth = builder.birthMonth;
        this.birthYear = builder.birthYear;
        this.zipCode = builder.zipCode;
        this.avatar = builder.avatar;
    }

    public Phone getPhone() {
        return phone;
    }

    public NickName getNickName() {
        return nickName;
    }

    public City getCity() {
        return city;
    }

    public BirthDay getBirthDay() {
        return birthDay;
    }

    public BirthMonth getBirthMonth() {
        return birthMonth;
    }

    public BirthYear getBirthYear() {
        return birthYear;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "phone=" + phone +
                ", nickName=" + nickName +
                ", city=" + city +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                ", zipCode=" + zipCode +
                ", avatar=" + avatar +
                '}';
    }
}
