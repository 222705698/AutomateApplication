package za.ac.cput.Factory;

import za.ac.cput.Domain.User;
import za.ac.cput.Util.Helper;

public class UserFactory {
    public static User createUser(String IdentityNumber, String FirstName, String LastName, String PhoneNumber, String EmailAddress,String Address) {
       /* if (IdentityNumber.isEmpty() || IdentityNumber == null)
            return null;
        if (FirstName.isEmpty() || FirstName == null)
            return null;
        if (LastName.isEmpty() || LastName == null)
            return null;
        if (PhoneNumber.isEmpty() || PhoneNumber == null)
            return null;
        if (EmailAddress.isEmpty() || EmailAddress == null)
            return null;*/

        if (Helper.isNullOrEmpty(IdentityNumber)
                || Helper.isNullOrEmpty(FirstName)
                || Helper.isNullOrEmpty(LastName)
                || Helper.isNullOrEmpty(PhoneNumber)
                || !Helper.isValidEmail(EmailAddress)
                   || Helper.isNullOrEmpty(Address))
            return null;


        return new User.Builder().setIdentityNumber(IdentityNumber).setName(FirstName).setSurname(LastName)
                .setPhoneNumber(PhoneNumber)
                .setEmail(EmailAddress).setAddress(Address).build();



    }}
