package az.orient.ecourse.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbHelper {

    public static Connection getConnection() throws Exception { // asim
        Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        Class.forName(p.getProperty("db.driver"));
        Connection c = DriverManager.getConnection(p.getProperty("db.url"),p.getProperty("db.username"),p.getProperty("db.password"));
        return c;
    }

}
