package za.ac.cput.Repository;

import za.ac.cput.Domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private static IUserRepository Repository = null;
    private List<User> UserList;

    private UserRepository(){
        UserList = new ArrayList<>();
    }

    public static IUserRepository getIRepository(){
        if (Repository == null){
            Repository = new UserRepository();
        }
        return Repository;
    }

    @Override
    public User create(User user) {
        boolean UserSucess = UserList.add(user);
        if (UserSucess){
            return user;
        }
        System.out.println("User not successfully added");
        return null;
    }

    @Override
    public User read(String UserID) {
        for(User user : UserList) {
            if (user.getIdentityNumber().equals(UserID)) {
                return user;
            }
        }
        System.out.println("User not found with the given Identity Number");
        return null;
    }

    @Override
    public User update(User user) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getIdentityNumber().equals(user.getIdentityNumber())) {
                UserList.set(i, user); // Update the user in the list
                return user; // Return the updated user
            }
        }
        System.out.println("User not found for update");
        return null; // Return null if user is not found for update
    }

    @Override
    public boolean delete(String IdentityNumber) {
        for (User user : UserList) {
            if (user.getIdentityNumber().equals(IdentityNumber)) {
                UserList.remove(user); // Remove the user from the list
                return true; // Return true if deletion is successful
            }
        }
        System.out.println("User not found for deletion");
        return false; // Return false if user is not found to delete
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(UserList);
    }
}
