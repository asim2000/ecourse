package az.orient.ecourse.dao.impl;

import az.orient.ecourse.dao.DbHelper;
import az.orient.ecourse.dao.UserDao;
import az.orient.ecourse.model.User;
import az.orient.ecourse.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(String username, String password) throws Exception {
        User user = new User();
        String sql = "select u.*,ur.id role_id,ur.name role_name from qrup58db.user u\n" +
                "inner join qrup58db.user_role ur on u.user_role_id = ur.id\n" +
                "where u.active = 1 and u.username = ? and u.password = ?";
        try (Connection c= DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
              ps.setString(1,username);
              ps.setString(2,password);
              ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                  user.setId(rs.getLong("id"));
                  user.setUsername(rs.getString("username"));
                  UserRole userRole = new UserRole();
                  userRole.setId(rs.getLong("role_id"));
                  userRole.setName(rs.getString("role_name"));
                  user.setUserRole(userRole);
              } else {
                  user = null;
              }
        }
        return user;
    }
}
