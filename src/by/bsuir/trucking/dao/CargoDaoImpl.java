package by.bsuir.trucking.dao;

import by.bsuir.trucking.entity.Cargo;

import java.sql.*;
import java.util.ArrayList;


public class CargoDaoImpl implements ElementDao<Cargo> {
    private static final String SELECT_CARGO = "SELECT * FROM cargo";
    private static final String INSERT_CARGO = "INSERT INTO cargo(id, weight,price,userId) VALUES (?,?,?,?)";
    private static final String UPDATE_CARGO = "UPDATE cargo SET weight = ?,price = ?  WHERE userId = ? AND id = ? ";
    private static final String DELETE_CARGO = "DELETE FROM cargo WHERE id= ? ";
    private static final String SELECT_CARGO_BY_USER_ID = "SELECT * FROM cargo WHERE userId = ?";
    private static final String SEND_CARGO = "UPDATE cargo SET shipId= ?  WHERE id = ? ";
    public CargoDaoImpl() {
    }
    public ArrayList<Cargo> selectCargoByUserId(int id){
        ArrayList<Cargo> cargoList = new ArrayList<>();
        try {
            PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(SELECT_CARGO_BY_USER_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setWeight(rs.getFloat("weight"));
                cargo.setPrice(rs.getFloat("price"));
                cargo.setUserId(rs.getInt("userId"));
                cargo.setShipId(rs.getInt("shipId"));
                cargoList.add(cargo);
            }
            return cargoList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public  ArrayList<Cargo> getAll() {
        ArrayList<Cargo> cargoList = new ArrayList<>();
        try {
            Statement statement = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_CARGO);
            while (rs.next()){
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setWeight(rs.getFloat("weight"));
                cargo.setPrice(rs.getFloat("price"));
                cargo.setUserId(rs.getInt("userId"));
                cargo.setShipId(rs.getInt("shipId"));
                cargoList.add(cargo);
            }
            return cargoList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean update(Cargo date) {
        try{
            PreparedStatement  statement = ConnectionDB.getInstance().getConnection().prepareStatement(UPDATE_CARGO);
            statement.setFloat(1,date.getWeight());
            statement.setFloat(2,date.getPrice());
            statement.setInt(3,date.getUserId());
            statement.setFloat(4,date.getId());
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
            PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(DELETE_CARGO);
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
    public boolean add(Cargo date) {
        try {
            PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(INSERT_CARGO);
            statement.setInt(1,date.getId());
            statement.setFloat(2,date.getWeight());
            statement.setFloat(3,date.getPrice());
            statement.setInt(4,date.getUserId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendCargo(Cargo date){
        try{
            PreparedStatement  statement = ConnectionDB.getInstance().getConnection().prepareStatement(SEND_CARGO);
            statement.setInt(1,date.getShipId());
            statement.setInt(2,date.getId());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
