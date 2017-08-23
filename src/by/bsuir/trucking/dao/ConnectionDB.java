package by.bsuir.trucking.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private Connection connection;
    private static ConnectionDB ourInstance = new ConnectionDB();

    public static ConnectionDB getInstance() {
        return ourInstance;
    }

    private ConnectionDB() {
        try{
                Properties prop = createPropertiesFromFile();
                if (prop == null){
                    prop = createDefaultProperties();
                }
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(
                        prop.getProperty("db.url"),
                        prop.getProperty("db.login"),
                        prop.getProperty("db.password"));
        }
        catch( SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){return connection;}

    private void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties createDefaultProperties(){
        Properties properties = new Properties();
        properties.setProperty("db.url","jdbc:mysql://localhost:3306/companygoft");
        properties.setProperty("db.login","root");
        properties.setProperty("db.password", "root");
        return properties;
    }

    private Properties createPropertiesFromFile(){
        Properties properties = new Properties();
        InputStream input = null;
        try {

//            File f = new File("db.properties");
//            System.out.println(f.getAbsolutePath());
            input = new FileInputStream("ServerKurc/db.properties");

            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
