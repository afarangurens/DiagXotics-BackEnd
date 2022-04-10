package com.afas.diagxotics.dao;
import com.afas.diagxotics.model.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;


@Repository("fakeDao")
public class FakeUserDataAccesService implements UserDao{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user){
        DB.add(new User(id, user.getName()));
        return 1;
    }    

    @Override
    public List<User> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<User> selectPersonById(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {

        Optional<User> userMaybe = selectPersonById(id);
        if(userMaybe.isEmpty()){
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;   
    }

    @Override
    public int updateUserById(UUID id, User user) {

        return selectPersonById(id).map(u -> {   
                                        int indexOfUserToUpdate = DB.indexOf(u);
                                        if(indexOfUserToUpdate >= 0){
                                            DB.set(indexOfUserToUpdate, new User(id, user.getName()));
                                            return 1;
                                        }
                                        return 0;
                                    }).orElse(0);
    }
}