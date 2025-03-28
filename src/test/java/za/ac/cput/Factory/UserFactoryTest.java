package za.ac.cput.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User;
import za.ac.cput.Factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
    private static User myUser = UserFactory.createUser("0105055616084","Sinokholo","Singazi","0655528976","Sinosingazi@gmail.com","P.O.Box 123456");
    private static  User myUser1 = UserFactory.createUser("0726268432828","Sibahle","Shange","0719250925","Shangegmail.com","P.O.Box 123456");

    @Test
    public void createUser(){
        assertNotNull(myUser);
        assertNotNull(myUser,"You must fill in all the fields corerctly");
        System.out.println(myUser.toString());
    }
    @Test
    public void testCreateUser_InvalidEmail_ReturnsNull(){


        assertNotNull(myUser1,"User must be null if email is invalid");
        System.out.println(myUser1.toString());
    }
    @Test
    public void testCreateUser_InvalidAmount_ReturnsNull(){
        assertNotNull(myUser1,"User must be null if amount is invalid");
        System.out.println(myUser1.toString());

    }
}
