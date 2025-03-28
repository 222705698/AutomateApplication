package za.ac.cput.Repository;

import za.ac.cput.Domain.User;

import java.util.List;

public interface IUserRepository extends IRepository<User,String>{
    List<User>getAll();
}
