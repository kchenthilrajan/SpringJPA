package com.sample.dao;

import com.sample.entities.UserDetail;
import java.util.List;

public interface UserDao {
    void createUser(UserDetail userDetail);
    List<String> getAllUserNames();
    void deleteUser(UserDetail userDetail);
}
