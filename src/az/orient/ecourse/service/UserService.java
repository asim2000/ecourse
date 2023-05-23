package az.orient.ecourse.service;

import az.orient.ecourse.model.User;

public interface UserService {

    User login(String username, String password) throws Exception;

}
