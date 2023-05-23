package az.orient.ecourse.service.impl;

import az.orient.ecourse.dao.UserDao;
import az.orient.ecourse.model.User;
import az.orient.ecourse.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) throws Exception {
        return userDao.login(username, password);
    }
}
