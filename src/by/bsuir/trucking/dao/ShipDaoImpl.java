package by.bsuir.trucking.dao;

import by.bsuir.trucking.entity.Ship;

import java.sql.*;
import java.util.ArrayList;

public class ShipDaoImpl implements ElementDao<Ship> {
    private static final String SELECT_SHIP = "SELECT * FROM ship";
    private static final String INSERT_SHIP = "INSERT INTO ship(id, maxWeight) VALUES (?,?)";
    private static final String UPDATE_SHIP = "UPDATE ship SET  maxWeight = ? WHERE id = ? ";
    private static final String DELETE_SHIP = "DELETE FROM ship WHERE id= ?";
    private static final String SEND_SHIP = "UPDATE ship SET  departureDate = ? WHERE id = ? ";
    private static final String SELECT_SHIP_WEIGHT = "SELECT * FROM ship WHERE id =?";

    @Override
    public ArrayList<Ship> getAll() {
        ArrayList<Ship> shipList = new ArrayList<>();
        try {
            Statement statement = ConnectionDB.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_SHIP);
            while (rs.next()){
                Ship ship = new Ship();
                ship.setId(rs.getInt("id"));
                ship.setMaxWeight(rs.getFloat("maxWeight"));
                ship.setDepartureDate(rs.getDate("departureDate"));
                shipList.add(ship);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return shipList;
    }

    @Override
    public boolean update(Ship date) {
        try{
            PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(UPDATE_SHIP);
            statement.setFloat(1,date.getMaxWeight());
            statement.setFloat(2,date.getId());
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
        PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(DELETE_SHIP);
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
    public boolean add(Ship date) { try {
        PreparedStatement statement= ConnectionDB.getInstance().getConnection().prepareStatement(INSERT_SHIP);
        statement.setInt(1,date.getId());
        statement.setFloat(2,date.getMaxWeight());
        statement.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

    public boolean sendShip(Ship date){
        try{
            PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(SEND_SHIP);
//            String string =String.valueOf(date.getDepartureDate().getDay())+String.valueOf(date.getDepartureDate().getMonth())+String.valueOf(date.getDepartureDate().getYear());
            statement.setDate(1, new Date(date.getDepartureDate().getTime()));
            statement.setFloat(2,date.getId());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ship selectShipWeight(Ship s){
        Ship ship = new Ship();
        try {
            PreparedStatement statement = ConnectionDB.getInstance().getConnection().prepareStatement(SELECT_SHIP_WEIGHT);
            statement.setInt(1,s.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ship.setId(rs.getInt("id"));
                ship.setMaxWeight(rs.getFloat("maxWeight"));
                ship.setDepartureDate(rs.getDate("departureDate"));
            }
            if(ship.getId()==0){
                return null;
            }
            else return ship;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

