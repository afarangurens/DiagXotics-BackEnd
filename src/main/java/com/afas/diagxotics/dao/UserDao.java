package com.afas.diagxotics.dao;
import com.afas.diagxotics.model.User;
import java.util.UUID;
import java.util.List;

public interface UserDao{
    
    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
    List<User> selectAllPeople();
}