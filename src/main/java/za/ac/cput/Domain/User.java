package za.ac.cput.Domain;

public class User {

    private String IdentityNumber;
    private String Name;
    private String surname;
    private String PhoneNumber;
    private String email;
    private String Address;

    public User() {
    }

    private User(Builder builder) {
        this.IdentityNumber = builder.IdentityNumber;
        this.Name = builder.Name;
        this.surname = builder.surname;
        this.PhoneNumber = builder.PhoneNumber;
        this.email = builder.email;
        this.Address = builder.Address;
    }

    public String getIdentityNumber() {
        return IdentityNumber;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return surname;
    }

    public String  getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString() {
        return "User{" +
                "IdentityNumber='" + IdentityNumber + '\'' +
                ", Name='" + Name + '\'' +
                ", surname='" + surname + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    public static class Builder {
        private String IdentityNumber;
        private String Name;
        private String surname;
        private String PhoneNumber;
        private String email;
        private String Address;

        public Builder setIdentityNumber(String identityNumber) {
            IdentityNumber = identityNumber;
            return this;
        }

        public Builder setName(String name) {
            Name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
            return this;

        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;

        }

        public Builder setAddress(String Address) {
            this.Address = Address;
            return this;
        }


        public User build() {
            return new User(this);
        }

    }
}



