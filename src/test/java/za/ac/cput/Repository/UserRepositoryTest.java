package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.User;
import za.ac.cput.Factory.UserFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.Random.class)

class UserRepositoryTest { private IUserRepository userRepository;
    private static User myUser;
    private static User myUser1;

    @BeforeEach
    void setUp() {
        userRepository = UserRepository.getIRepository(); // Initialize repository

        // Initialize test users
        myUser = UserFactory.createUser("0105055616084", "Sinokholo", "Singazi", "0655528976", "Sinosingazi@gmail.com", "P.O.Box 123456");
        myUser1 = UserFactory.createUser("0726268432828", "Sibahle", "Shange", "0719250925", "Shange@gmail.com", "P.O.Box 123456");

        // Ensure users are valid before adding them to the repository
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
        assertNotNull(myUser, "User creation failed: fields may be incorrect");
        assertNotNull(userRepository.read(myUser.getIdentityNumber()), "User must be added to the repository");
        System.out.println(myUser);
    }



    @Test
    @Order(2)
    void readUser() {
        User fetchedUser = userRepository.read(myUser.getIdentityNumber());
        assertNotNull(fetchedUser, "User should be retrieved using the given identity number");
        System.out.println(fetchedUser);
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
    @Disabled
    @Order(4)
    void deleteUser() {
        assertTrue(userRepository.delete(myUser.getIdentityNumber()), "User should be deleted successfully");
        assertNull(userRepository.read(myUser.getIdentityNumber()), "Deleted user should not exist in the repository");
        System.out.println("Deleted User ID: " + myUser.getIdentityNumber());
    }
    @Test
    @Order(5)
    void testCreateUser_InvalidEmail_ReturnsNull() {
        User invalidEmailUser = UserFactory.createUser("0105055616084", "Invalid", "Email", "0655528976", "invalid-email", "P.O.Box 123456");
        assertNull(invalidEmailUser, "User should be null if email is invalid");
        System.out.println(invalidEmailUser);

    }

}