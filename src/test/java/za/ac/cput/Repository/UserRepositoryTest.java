package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.User;
import za.ac.cput.Factory.UserFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class UserRepositoryTest { private IUserRepository userRepository;
    private static User myUser;
    private static User myUser1;

    @BeforeEach
    void setUp() {
        userRepository = UserRepository.getIRepository();


        myUser = UserFactory.createUser("0105055616084", "Sinokholo", "Singazi", "0655528976", "Sinosingazi@gmail.com", "P.O.Box 123456");
        myUser1 = UserFactory.createUser("0726268432828", "Sibahle", "Shange", "0719250925", "Shange@gmail.com", "P.O.Box 123456");


        if (myUser != null) {
            userRepository.create(myUser);
        }
        if (myUser1 != null) {
            userRepository.create(myUser1);
        }
    }

    @Test
    @Order(1)
    void createUser() {
        assertNotNull(myUser);
        assertNotNull(userRepository.read(myUser.getIdentityNumber()));
        System.out.println(myUser);
    }



    @Test
    @Order(2)
    void readUser() {
        User readUser = userRepository.read(myUser.getIdentityNumber());
        assertNotNull(readUser, "User should be retrieved using the given identity number");
        System.out.println(readUser);
    }

    @Test
    @Order(3)
    void updateUser() {
        User updatedUser = new User.Builder()
                .setIdentityNumber(myUser.getIdentityNumber())
                .setName("Masibuve") // Updating the name
                .setSurname(myUser.getSurname())
                .setPhoneNumber(myUser.getPhoneNumber())
                .setEmail(myUser.getEmail())
                .setAddress(myUser.getAddress())
                .build();

        User result = userRepository.update(updatedUser);
        assertNotNull(result, "User should be updated successfully");
        assertEquals("Masibuve", result.getName(), "User name should be updated");
        System.out.println("Updated User: " + result);
    }

    @Test
    @Order(4)
    void deleteUser() {
        assertTrue(userRepository.delete(myUser.getIdentityNumber()), "User should be deleted successfully");
        System.out.println("Deleted User ID: " + myUser.getIdentityNumber());
    }
    @Test
    @Order(5)
    void testCreateUser_InvalidEmail_ReturnsNull() {
        User invalidEmailUser = UserFactory.createUser("0105055616084", "Invalid", "Email", "0655528976", "invalid-email", "P.O.Box 123456");
        assertNull(invalidEmailUser);
        System.out.println(invalidEmailUser);

    }

}