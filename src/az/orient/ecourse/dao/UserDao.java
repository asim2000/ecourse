package az.orient.ecourse.dao;

import az.orient.ecourse.model.User;

public interface UserDao {

    User login(String username,String password) throws Exception;

}
