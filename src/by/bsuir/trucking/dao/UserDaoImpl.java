package by.bsuir.trucking.dao;


import by.bsuir.trucking.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDaoImpl implements ElementDao<User> {

    private static final String SELECT_CARGO = "SELECT * FROM user";
    private static final String REGISTRATION_USER = "INSERT INTO user(name,surname,login,password) VALUES (?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE user SET  name = ?, surname= ?,login = ?, password= ?,status = ? WHERE id = ? ";
    private static final String DELETE_USER = "DELETE FROM user WHERE id= ?";
    private static final String AUTHORIZATION_USER = "SELECT * FROM user WHERE login =? and password= ?";

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Statement statement = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_CARGO);
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLogin(rs.getString("login"));
                user.setStatus(rs.getString("status"));
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean update(User date) { try{
        PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(UPDATE_USER);
        statement.setString(1,date.getName());
        statement.setString(2,date.getSurname());
        statement.setString(3,date.getLogin());
        statement.setString(4,date.getPassword());
        statement.setString(5,date.getStatus());
        statement.setFloat(6,date.getId());
        statement.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

    }

    @Override
    public boolean delete(int id) {
        try{
            PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(User date) {
        try {
            PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(REGISTRATION_USER);
            statement.setString(1,date.getName());
            statement.setString(2,date.getSurname());
            statement.setString(3,date.getLogin());
            statement.setString(4,date.getPassword());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User authorization(User date){
        try{
            PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(AUTHORIZATION_USER);
            statement.setString(1,date.getLogin());
            statement.setString(2,date.getPassword());
            ResultSet rs = statement.executeQuery();
            User user = new User();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLogin(rs.getString("login"));
                user.setStatus(rs.getString("status"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
